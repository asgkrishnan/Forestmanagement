package com.forest.surveillance.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "deforestation_alerts")
public class DeforestationAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "area_id", nullable = false)
    private Long areaId;

    @Column(name = "area_name", nullable = false)
    private String areaName;

    @Column(name = "detection_date", nullable = false)
    private LocalDate detectionDate;

    @Column(name = "observation_prev_date")
    private LocalDate previousDate;

    @Column(name = "observation_curr_date")
    private LocalDate currentDate;

    private Double changePercentage;
    private Double estimatedAffectedAreaHectares;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlertStatus status = AlertStatus.POTENTIAL;

    private String adminDecision;

    @Column(columnDefinition = "TEXT")
    private String adminRemarks;

    private Long assignedGuardId;
    private String assignedGuardName;

    private String smsStatus = "PENDING";

    @Enumerated(EnumType.STRING)
    private InvestigationStatus investigationStatus = InvestigationStatus.PENDING;

    @Column(columnDefinition = "TEXT")
    private String guardRemarks;

    @Column(columnDefinition = "TEXT")
    private String previousImageUrl;

    @Column(columnDefinition = "TEXT")
    private String currentImageUrl;

    @Column(columnDefinition = "TEXT")
    private String changeOverlayUrl;

    private LocalDateTime createdAt = LocalDateTime.now();

    public DeforestationAlert() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public LocalDate getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(LocalDate detectionDate) {
        this.detectionDate = detectionDate;
    }

    public LocalDate getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(LocalDate previousDate) {
        this.previousDate = previousDate;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public Double getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(Double changePercentage) {
        this.changePercentage = changePercentage;
    }

    public Double getEstimatedAffectedAreaHectares() {
        return estimatedAffectedAreaHectares;
    }

    public void setEstimatedAffectedAreaHectares(Double estimatedAffectedAreaHectares) {
        this.estimatedAffectedAreaHectares = estimatedAffectedAreaHectares;
    }

    public AlertStatus getStatus() {
        return status;
    }

    public void setStatus(AlertStatus status) {
        this.status = status;
    }

    public String getAdminDecision() {
        return adminDecision;
    }

    public void setAdminDecision(String adminDecision) {
        this.adminDecision = adminDecision;
    }

    public String getAdminRemarks() {
        return adminRemarks;
    }

    public void setAdminRemarks(String adminRemarks) {
        this.adminRemarks = adminRemarks;
    }

    public Long getAssignedGuardId() {
        return assignedGuardId;
    }

    public void setAssignedGuardId(Long assignedGuardId) {
        this.assignedGuardId = assignedGuardId;
    }

    public String getAssignedGuardName() {
        return assignedGuardName;
    }

    public void setAssignedGuardName(String assignedGuardName) {
        this.assignedGuardName = assignedGuardName;
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    public InvestigationStatus getInvestigationStatus() {
        return investigationStatus;
    }

    public void setInvestigationStatus(InvestigationStatus investigationStatus) {
        this.investigationStatus = investigationStatus;
    }

    public String getGuardRemarks() {
        return guardRemarks;
    }

    public void setGuardRemarks(String guardRemarks) {
        this.guardRemarks = guardRemarks;
    }

    public String getPreviousImageUrl() {
        return previousImageUrl;
    }

    public void setPreviousImageUrl(String previousImageUrl) {
        this.previousImageUrl = previousImageUrl;
    }

    public String getCurrentImageUrl() {
        return currentImageUrl;
    }

    public void setCurrentImageUrl(String currentImageUrl) {
        this.currentImageUrl = currentImageUrl;
    }

    public String getChangeOverlayUrl() {
        return changeOverlayUrl;
    }

    public void setChangeOverlayUrl(String changeOverlayUrl) {
        this.changeOverlayUrl = changeOverlayUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
