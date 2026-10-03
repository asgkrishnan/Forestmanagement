package com.forest.surveillance.dto;

import java.time.LocalDate;

public class MonitoringAnalysisResultDto {
    private Long recordId;
    private Long areaId;
    private String areaName;
    private LocalDate previousDate;
    private LocalDate currentDate;
    private Double previousNdvi;
    private Double currentNdvi;
    private Double ndviDifference;
    private Double changePercentage;
    private Double estimatedAffectedAreaHectares;
    private String status; // "POTENTIAL_DEFORESTATION" or "NORMAL_VEGETATION"
    private String previousImageUrl;
    private String currentImageUrl;
    private String changeOverlayUrl;
    private String satelliteSource;
    private boolean apiConfigured;
    private String configMessage;

    public MonitoringAnalysisResultDto() {
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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

    public Double getPreviousNdvi() {
        return previousNdvi;
    }

    public void setPreviousNdvi(Double previousNdvi) {
        this.previousNdvi = previousNdvi;
    }

    public Double getCurrentNdvi() {
        return currentNdvi;
    }

    public void setCurrentNdvi(Double currentNdvi) {
        this.currentNdvi = currentNdvi;
    }

    public Double getNdviDifference() {
        return ndviDifference;
    }

    public void setNdviDifference(Double ndviDifference) {
        this.ndviDifference = ndviDifference;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getSatelliteSource() {
        return satelliteSource;
    }

    public void setSatelliteSource(String satelliteSource) {
        this.satelliteSource = satelliteSource;
    }

    public boolean isApiConfigured() {
        return apiConfigured;
    }

    public void setApiConfigured(boolean apiConfigured) {
        this.apiConfigured = apiConfigured;
    }

    public String getConfigMessage() {
        return configMessage;
    }

    public void setConfigMessage(String configMessage) {
        this.configMessage = configMessage;
    }
}
