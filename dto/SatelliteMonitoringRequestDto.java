package com.forest.surveillance.dto;

import java.time.LocalDate;

public class SatelliteMonitoringRequestDto {
    private Long areaId;
    private LocalDate previousDate;
    private LocalDate currentDate;

    public SatelliteMonitoringRequestDto() {
    }

    public SatelliteMonitoringRequestDto(Long areaId, LocalDate previousDate, LocalDate currentDate) {
        this.areaId = areaId;
        this.previousDate = previousDate;
        this.currentDate = currentDate;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public LocalDate getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(LocalDate previousDate) {
        this.previousDate = previousDate;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
}
