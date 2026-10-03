package com.forest.surveillance.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "satellite_images")
public class SatelliteImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "area_id", nullable = false)
    private Long areaId;

    @Column(name = "acquisition_date", nullable = false)
    private LocalDate acquisitionDate;

    private Double cloudCoverPercentage;

    private String satelliteSource = "Sentinel-2 L2A";

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String ndviMapUrl;

    public SatelliteImage() {
    }

    public SatelliteImage(Long areaId, LocalDate acquisitionDate, Double cloudCoverPercentage, String satelliteSource, String imageUrl, String ndviMapUrl) {
        this.areaId = areaId;
        this.acquisitionDate = acquisitionDate;
        this.cloudCoverPercentage = cloudCoverPercentage;
        this.satelliteSource = satelliteSource;
        this.imageUrl = imageUrl;
        this.ndviMapUrl = ndviMapUrl;
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

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Double getCloudCoverPercentage() {
        return cloudCoverPercentage;
    }

    public void setCloudCoverPercentage(Double cloudCoverPercentage) {
        this.cloudCoverPercentage = cloudCoverPercentage;
    }

    public String getSatelliteSource() {
        return satelliteSource;
    }

    public void setSatelliteSource(String satelliteSource) {
        this.satelliteSource = satelliteSource;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNdviMapUrl() {
        return ndviMapUrl;
    }

    public void setNdviMapUrl(String ndviMapUrl) {
        this.ndviMapUrl = ndviMapUrl;
    }
}
