package com.forest.surveillance.controller;

import com.forest.surveillance.dto.AnalyticsSummaryDto;
import com.forest.surveillance.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping
    public ResponseEntity<AnalyticsSummaryDto> getAnalytics() {
        return ResponseEntity.ok(analyticsService.getDashboardAnalytics());
    }
}
