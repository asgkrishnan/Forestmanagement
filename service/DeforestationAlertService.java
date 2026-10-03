package com.forest.surveillance.service;

import com.forest.surveillance.dto.AlertApprovalDto;
import com.forest.surveillance.dto.MonitoringAnalysisResultDto;
import com.forest.surveillance.entity.*;
import com.forest.surveillance.exception.ForestAreaNotFoundException;
import com.forest.surveillance.exception.ForestGuardNotFoundException;
import com.forest.surveillance.notification.NotificationService;
import com.forest.surveillance.repository.DeforestationAlertRepository;
import com.forest.surveillance.repository.ForestAreaRepository;
import com.forest.surveillance.repository.ForestGuardRepository;
import com.forest.surveillance.repository.InvestigationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeforestationAlertService {

    private final DeforestationAlertRepository alertRepository;
    private final ForestAreaRepository forestAreaRepository;
    private final ForestGuardRepository forestGuardRepository;
    private final InvestigationRepository investigationRepository;
    private final NotificationService notificationService;

    public DeforestationAlertService(
            DeforestationAlertRepository alertRepository,
            ForestAreaRepository forestAreaRepository,
            ForestGuardRepository forestGuardRepository,
            InvestigationRepository investigationRepository,
            NotificationService notificationService) {
        this.alertRepository = alertRepository;
        this.forestAreaRepository = forestAreaRepository;
        this.forestGuardRepository = forestGuardRepository;
        this.investigationRepository = investigationRepository;
        this.notificationService = notificationService;
    }



    public List<DeforestationAlert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public DeforestationAlert getAlertById(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found with ID: " + id));
    }

    public List<DeforestationAlert> getAlertsByGuard(Long guardId) {
        return alertRepository.findByAssignedGuardIdOrderByCreatedAtDesc(guardId);
    }

    public DeforestationAlert createPotentialAlert(MonitoringAnalysisResultDto analysisResult) {
        ForestArea area = forestAreaRepository.findById(analysisResult.getAreaId())
                .orElseThrow(() -> new ForestAreaNotFoundException("Forest area not found: " + analysisResult.getAreaId()));

        DeforestationAlert alert = new DeforestationAlert();
        alert.setAreaId(area.getId());
        alert.setAreaName(area.getName());
        alert.setDetectionDate(LocalDate.now());
        alert.setPreviousDate(analysisResult.getPreviousDate());
        alert.setCurrentDate(analysisResult.getCurrentDate());
        alert.setChangePercentage(analysisResult.getChangePercentage());
        alert.setEstimatedAffectedAreaHectares(analysisResult.getEstimatedAffectedAreaHectares());
        alert.setStatus(AlertStatus.POTENTIAL);
        alert.setAssignedGuardId(area.getAssignedGuardId());
        alert.setAssignedGuardName(area.getAssignedGuardName());
        alert.setInvestigationStatus(InvestigationStatus.PENDING);
        alert.setPreviousImageUrl(analysisResult.getPreviousImageUrl());
        alert.setCurrentImageUrl(analysisResult.getCurrentImageUrl());
        alert.setChangeOverlayUrl(analysisResult.getChangeOverlayUrl());

        return alertRepository.save(alert);
    }

    public DeforestationAlert approveAlert(Long alertId, AlertApprovalDto dto) {
        DeforestationAlert alert = getAlertById(alertId);

        alert.setStatus(AlertStatus.APPROVED);
        alert.setAdminDecision("APPROVED");
        alert.setAdminRemarks(dto.getAdminRemarks());

        if (dto.getGuardId() != null) {
            ForestGuard guard = forestGuardRepository.findById(dto.getGuardId())
                    .orElseThrow(() -> new ForestGuardNotFoundException("Forest guard not found with ID: " + dto.getGuardId()));
            alert.setAssignedGuardId(guard.getId());
            alert.setAssignedGuardName(guard.getFullName());
        }

        ForestGuard assignedGuard = null;
        if (alert.getAssignedGuardId() != null) {
            Optional<ForestGuard> guardOpt = forestGuardRepository.findById(alert.getAssignedGuardId());
            if (guardOpt.isPresent()) {
                assignedGuard = guardOpt.get();
            }
        }

        // Trigger SMS notification service
        Notification notif = notificationService.sendSmsNotification(assignedGuard, alert);
        alert.setSmsStatus(notif.getDeliveryStatus());

        // Create / initialize investigation entry
        Investigation investigation = investigationRepository.findByAlertId(alertId)
                .orElse(new Investigation(alert.getId(), alert.getAssignedGuardId(), InvestigationStatus.PENDING, "Awaiting field inspection."));
        investigation.setStatus(InvestigationStatus.PENDING);
        investigationRepository.save(investigation);

        return alertRepository.save(alert);
    }

    public DeforestationAlert rejectAlert(Long alertId, String adminRemarks) {
        DeforestationAlert alert = getAlertById(alertId);
        alert.setStatus(AlertStatus.REJECTED);
        alert.setAdminDecision("REJECTED");
        alert.setAdminRemarks(adminRemarks);
        alert.setSmsStatus("N/A - REJECTED");

        return alertRepository.save(alert);
    }
}
