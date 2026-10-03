package com.forest.surveillance.controller;

import com.forest.surveillance.dto.MonitoringAnalysisResultDto;
import com.forest.surveillance.dto.SatelliteMonitoringRequestDto;
import com.forest.surveillance.entity.DeforestationAlert;
import com.forest.surveillance.entity.ForestArea;
import com.forest.surveillance.entity.MonitoringRecord;
import com.forest.surveillance.repository.ForestAreaRepository;
import com.forest.surveillance.repository.MonitoringRecordRepository;
import com.forest.surveillance.service.DeforestationAlertService;
import com.forest.surveillance.service.NdviChangeDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitoring")
public class SatelliteMonitoringController {

    private final ForestAreaRepository forestAreaRepository;
    private final NdviChangeDetectionService changeDetectionService;
    private final DeforestationAlertService alertService;
    private final MonitoringRecordRepository monitoringRecordRepository;

    public SatelliteMonitoringController(
            ForestAreaRepository forestAreaRepository,
            NdviChangeDetectionService changeDetectionService,
            DeforestationAlertService alertService,
            MonitoringRecordRepository monitoringRecordRepository) {
        this.forestAreaRepository = forestAreaRepository;
        this.changeDetectionService = changeDetectionService;
        this.alertService = alertService;
        this.monitoringRecordRepository = monitoringRecordRepository;
    }

    @PostMapping("/analyze")
    public ResponseEntity<MonitoringAnalysisResultDto> analyzeSatelliteData(@RequestBody SatelliteMonitoringRequestDto request) {
        ForestArea area = forestAreaRepository.findById(request.getAreaId())
                .orElseThrow(() -> new RuntimeException("Forest Area not found with ID: " + request.getAreaId()));

        MonitoringAnalysisResultDto result = changeDetectionService.analyzeChange(area, request.getPreviousDate(), request.getCurrentDate());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create-alert")
    public ResponseEntity<DeforestationAlert> createPotentialAlert(@RequestBody MonitoringAnalysisResultDto analysisResult) {
        DeforestationAlert alert = alertService.createPotentialAlert(analysisResult);
        return ResponseEntity.ok(alert);
    }

    @GetMapping("/records")
    public ResponseEntity<List<MonitoringRecord>> getMonitoringRecords() {
        return ResponseEntity.ok(monitoringRecordRepository.findAllByOrderByCreatedTimestampDesc());
    }
}
