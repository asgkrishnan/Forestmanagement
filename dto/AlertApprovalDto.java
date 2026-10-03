package com.forest.surveillance.dto;

public class AlertApprovalDto {
    private String adminRemarks;
    private Long guardId;

    public AlertApprovalDto() {
    }

    public AlertApprovalDto(String adminRemarks, Long guardId) {
        this.adminRemarks = adminRemarks;
        this.guardId = guardId;
    }

    public String getAdminRemarks() {
        return adminRemarks;
    }

    public void setAdminRemarks(String adminRemarks) {
        this.adminRemarks = adminRemarks;
    }

    public Long getGuardId() {
        return guardId;
    }

    public void setGuardId(Long guardId) {
        this.guardId = guardId;
    }
}
