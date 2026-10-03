package com.forest.surveillance.controller;

import com.forest.surveillance.dto.AlertApprovalDto;
import com.forest.surveillance.entity.DeforestationAlert;
import com.forest.surveillance.service.DeforestationAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final DeforestationAlertService alertService;

    public AlertController(DeforestationAlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public ResponseEntity<List<DeforestationAlert>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeforestationAlert> getAlertById(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.getAlertById(id));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<DeforestationAlert> approveAlert(@PathVariable Long id, @RequestBody AlertApprovalDto dto) {
        DeforestationAlert approved = alertService.approveAlert(id, dto);
        return ResponseEntity.ok(approved);
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<DeforestationAlert> rejectAlert(@PathVariable Long id, @RequestBody AlertApprovalDto dto) {
        DeforestationAlert rejected = alertService.rejectAlert(id, dto.getAdminRemarks());
        return ResponseEntity.ok(rejected);
    }
}
