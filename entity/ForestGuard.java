package com.forest.surveillance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FOREST_GUARD")
public class ForestGuard extends User {

    @Column(name = "guard_id_code")
    private String guardIdCode;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "assigned_area_id")
    private Long assignedAreaId;

    public ForestGuard() {
        super();
        setRole(Role.FOREST_GUARD);
    }

    public ForestGuard(String username, String password, String fullName, String email, String guardIdCode, String phoneNumber, Long assignedAreaId) {
        super(username, password, fullName, email, Role.FOREST_GUARD);
        this.guardIdCode = guardIdCode;
        this.phoneNumber = phoneNumber;
        this.assignedAreaId = assignedAreaId;
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
}
