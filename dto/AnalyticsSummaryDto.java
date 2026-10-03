package com.forest.surveillance.dto;

import java.util.List;
import java.util.Map;

public class AnalyticsSummaryDto {
    private long totalForestAreas;
    private long totalForestGuards;
    private long totalMonitoringRecords;
    private long totalPotentialAlerts;
    private long totalApprovedAlerts;
    private long totalPendingAlerts;
    private long totalRejectedAlerts;

    private List<Map<String, Object>> monthlyStats;
    private List<Map<String, Object>> yearlyStats;
    private List<Map<String, Object>> areaAlertDistribution;
    private List<Map<String, Object>> guardActivity;

    public AnalyticsSummaryDto() {
    }

    public long getTotalForestAreas() {
        return totalForestAreas;
    }

    public void setTotalForestAreas(long totalForestAreas) {
        this.totalForestAreas = totalForestAreas;
    }

    public long getTotalForestGuards() {
        return totalForestGuards;
    }

    public void setTotalForestGuards(long totalForestGuards) {
        this.totalForestGuards = totalForestGuards;
    }

    public long getTotalMonitoringRecords() {
        return totalMonitoringRecords;
    }

    public void setTotalMonitoringRecords(long totalMonitoringRecords) {
        this.totalMonitoringRecords = totalMonitoringRecords;
    }

    public long getTotalPotentialAlerts() {
        return totalPotentialAlerts;
    }

    public void setTotalPotentialAlerts(long totalPotentialAlerts) {
        this.totalPotentialAlerts = totalPotentialAlerts;
    }

    public long getTotalApprovedAlerts() {
        return totalApprovedAlerts;
    }

    public void setTotalApprovedAlerts(long totalApprovedAlerts) {
        this.totalApprovedAlerts = totalApprovedAlerts;
    }

    public long getTotalPendingAlerts() {
        return totalPendingAlerts;
    }

    public void setTotalPendingAlerts(long totalPendingAlerts) {
        this.totalPendingAlerts = totalPendingAlerts;
    }

    public long getTotalRejectedAlerts() {
        return totalRejectedAlerts;
    }

    public void setTotalRejectedAlerts(long totalRejectedAlerts) {
        this.totalRejectedAlerts = totalRejectedAlerts;
    }

    public List<Map<String, Object>> getMonthlyStats() {
        return monthlyStats;
    }

    public void setMonthlyStats(List<Map<String, Object>> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }

    public List<Map<String, Object>> getYearlyStats() {
        return yearlyStats;
    }

    public void setYearlyStats(List<Map<String, Object>> yearlyStats) {
        this.yearlyStats = yearlyStats;
    }

    public List<Map<String, Object>> getAreaAlertDistribution() {
        return areaAlertDistribution;
    }

    public void setAreaAlertDistribution(List<Map<String, Object>> areaAlertDistribution) {
        this.areaAlertDistribution = areaAlertDistribution;
    }

    public List<Map<String, Object>> getGuardActivity() {
        return guardActivity;
    }

    public void setGuardActivity(List<Map<String, Object>> guardActivity) {
        this.guardActivity = guardActivity;
    }
}
