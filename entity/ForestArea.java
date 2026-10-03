package com.forest.surveillance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "forest_areas")
public class ForestArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(columnDefinition = "TEXT")
    private String boundaryGeoJson;

    @Column(name = "assigned_guard_id")
    private Long assignedGuardId;

    @Column(name = "assigned_guard_name")
    private String assignedGuardName;

    private boolean active = true;

    public ForestArea() {
    }

    public ForestArea(String name, String location, Double latitude, Double longitude, String boundaryGeoJson, Long assignedGuardId, String assignedGuardName) {
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.boundaryGeoJson = boundaryGeoJson;
        this.assignedGuardId = assignedGuardId;
        this.assignedGuardName = assignedGuardName;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getBoundaryGeoJson() {
        return boundaryGeoJson;
    }

    public void setBoundaryGeoJson(String boundaryGeoJson) {
        this.boundaryGeoJson = boundaryGeoJson;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
