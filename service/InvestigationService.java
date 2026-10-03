package com.forest.surveillance.service;

import com.forest.surveillance.dto.GuardInvestigationDto;
import com.forest.surveillance.entity.AlertStatus;
import com.forest.surveillance.entity.DeforestationAlert;
import com.forest.surveillance.entity.Investigation;
import com.forest.surveillance.repository.DeforestationAlertRepository;
import com.forest.surveillance.repository.InvestigationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InvestigationService {

    private final DeforestationAlertRepository alertRepository;
    private final InvestigationRepository investigationRepository;

    public InvestigationService(DeforestationAlertRepository alertRepository, InvestigationRepository investigationRepository) {
        this.alertRepository = alertRepository;
        this.investigationRepository = investigationRepository;
    }

    public DeforestationAlert updateInvestigation(Long alertId, GuardInvestigationDto dto) {
        DeforestationAlert alert = alertRepository.findById(alertId)
                .orElseThrow(() -> new RuntimeException("Alert not found with ID: " + alertId));

        if (alert.getStatus() != AlertStatus.APPROVED) {
            throw new IllegalStateException("Only APPROVED alerts can be investigated by Forest Guards.");
        }

        alert.setInvestigationStatus(dto.getStatus());
        alert.setGuardRemarks(dto.getGuardRemarks());

        Investigation investigation = investigationRepository.findByAlertId(alertId)
                .orElse(new Investigation(alertId, alert.getAssignedGuardId(), dto.getStatus(), dto.getGuardRemarks()));

        investigation.setStatus(dto.getStatus());
        investigation.setRemarks(dto.getGuardRemarks());
        investigation.setUpdatedAt(LocalDateTime.now());
        investigationRepository.save(investigation);

        return alertRepository.save(alert);
    }
}
