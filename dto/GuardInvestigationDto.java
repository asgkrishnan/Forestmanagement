package com.forest.surveillance.dto;

import com.forest.surveillance.entity.InvestigationStatus;

public class GuardInvestigationDto {
    private InvestigationStatus status;
    private String guardRemarks;

    public GuardInvestigationDto() {
    }

    public GuardInvestigationDto(InvestigationStatus status, String guardRemarks) {
        this.status = status;
        this.guardRemarks = guardRemarks;
    }

    public InvestigationStatus getStatus() {
        return status;
    }

    public void setStatus(InvestigationStatus status) {
        this.status = status;
    }

    public String getGuardRemarks() {
        return guardRemarks;
    }

    public void setGuardRemarks(String guardRemarks) {
        this.guardRemarks = guardRemarks;
    }
}
