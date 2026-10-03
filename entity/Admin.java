package com.forest.surveillance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    private String department = "Central Forest Authority";

    public Admin() {
        super();
        setRole(Role.ADMIN);
    }

    public Admin(String username, String password, String fullName, String email) {
        super(username, password, fullName, email, Role.ADMIN);
        this.department = "Central Forest Authority";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
