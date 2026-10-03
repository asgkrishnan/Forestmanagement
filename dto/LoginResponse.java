package com.forest.surveillance.dto;

import com.forest.surveillance.entity.Role;

public class LoginResponse {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private Role role;
    private String guardIdCode;
    private String phoneNumber;
    private Long assignedAreaId;
    private String token;

    public LoginResponse() {
    }

    public LoginResponse(Long id, String username, String fullName, String email, Role role, String token) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.token = token;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
