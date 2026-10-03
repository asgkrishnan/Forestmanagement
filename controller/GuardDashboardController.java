package com.forest.surveillance.controller;

import com.forest.surveillance.dto.GuardInvestigationDto;
import com.forest.surveillance.entity.DeforestationAlert;
import com.forest.surveillance.service.DeforestationAlertService;
import com.forest.surveillance.service.InvestigationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guard")
public class GuardDashboardController {

    private final DeforestationAlertService alertService;
    private final InvestigationService investigationService;

    public GuardDashboardController(DeforestationAlertService alertService, InvestigationService investigationService) {
        this.alertService = alertService;
        this.investigationService = investigationService;
    }

    @GetMapping("/alerts/{guardId}")
    public ResponseEntity<List<DeforestationAlert>> getGuardAlerts(@PathVariable Long guardId) {
        return ResponseEntity.ok(alertService.getAlertsByGuard(guardId));
    }

    @PutMapping("/alerts/{id}/investigation")
    public ResponseEntity<DeforestationAlert> updateInvestigation(@PathVariable Long id, @RequestBody GuardInvestigationDto dto) {
        DeforestationAlert updated = investigationService.updateInvestigation(id, dto);
        return ResponseEntity.ok(updated);
    }
}
