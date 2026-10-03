package com.forest.surveillance.service;

import com.forest.surveillance.dto.MonitoringAnalysisResultDto;
import com.forest.surveillance.entity.ForestArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Component
public class MonitoringTask {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringTask.class);

    private final NdviChangeDetectionService changeDetectionService;

    public MonitoringTask(NdviChangeDetectionService changeDetectionService) {
        this.changeDetectionService = changeDetectionService;
    }

    @Async
    public CompletableFuture<MonitoringAnalysisResultDto> executeMonitoringAsync(ForestArea area, LocalDate previousDate, LocalDate currentDate) {
        logger.info("Thread [{}]: Starting asynchronous satellite band processing for forest area: {}", 
                Thread.currentThread().getName(), area.getName());

        try {
            // Simulate multi-band raster processing delay in worker thread
            Thread.sleep(800);
            MonitoringAnalysisResultDto result = changeDetectionService.analyzeChange(area, previousDate, currentDate);
            logger.info("Thread [{}]: Multithreaded satellite change analysis finished for: {}", 
                    Thread.currentThread().getName(), area.getName());
            return CompletableFuture.completedFuture(result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Monitoring task interrupted: {}", e.getMessage());
            return CompletableFuture.failedFuture(e);
        }
    }
}
