package com.forest.surveillance.dto;

public class ForestAreaDto {
    private Long id;
    private String name;
    private String location;
    private Double latitude;
    private Double longitude;
    private String boundaryGeoJson;
    private Long assignedGuardId;
    private String assignedGuardName;
    private boolean active = true;

    public ForestAreaDto() {
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
