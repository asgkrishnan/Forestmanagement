package com.forest.surveillance.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitoring_records")
public class MonitoringRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "area_id", nullable = false)
    private Long areaId;

    @Column(name = "area_name", nullable = false)
    private String areaName;

    @Column(name = "observation_prev_date", nullable = false)
    private LocalDate previousDate;

    @Column(name = "observation_curr_date", nullable = false)
    private LocalDate currentDate;

    private Double previousNdvi;
    private Double currentNdvi;
    private Double ndviDifference;
    private Double changePercentage;
    private Double estimatedAffectedAreaHectares;

    @Column(columnDefinition = "TEXT")
    private String previousImageUrl;

    @Column(columnDefinition = "TEXT")
    private String currentImageUrl;

    @Column(columnDefinition = "TEXT")
    private String changeOverlayUrl;

    private LocalDateTime createdTimestamp = LocalDateTime.now();

    public MonitoringRecord() {
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

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
}
