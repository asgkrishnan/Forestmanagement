package com.forest.surveillance.dto;

public class ForestGuardDto {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String guardIdCode;
    private String phoneNumber;
    private Long assignedAreaId;
    private String assignedAreaName;
    private boolean active = true;

    public ForestGuardDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuardIdCode() {
        return guardIdCode;
    }

    public void setGuardIdCode(String guardIdCode) {
        this.guardIdCode = guardIdCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getAssignedAreaId() {
        return assignedAreaId;
    }

    public void setAssignedAreaId(Long assignedAreaId) {
        this.assignedAreaId = assignedAreaId;
    }

    public String getAssignedAreaName() {
        return assignedAreaName;
    }

    public void setAssignedAreaName(String assignedAreaName) {
        this.assignedAreaName = assignedAreaName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
