package com.forest.surveillance.config;

import com.forest.surveillance.entity.*;
import com.forest.surveillance.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private final UserRepository userRepository;
    private final ForestAreaRepository forestAreaRepository;
    private final DeforestationAlertRepository alertRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            UserRepository userRepository,
            ForestAreaRepository forestAreaRepository,
            DeforestationAlertRepository alertRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.forestAreaRepository = forestAreaRepository;
        this.alertRepository = alertRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        try {
            // 1. Seed Users (Admin & Forest Guard)
            if (userRepository.count() == 0) {
                Admin admin = new Admin("admin", passwordEncoder.encode("admin123"), "System Admin", "admin@forest.gov");
                userRepository.save(admin);

                ForestGuard guard = new ForestGuard("guard1", passwordEncoder.encode("guard123"), "Officer John Silva", "guard1@forest.gov", "FG001", "+15550199", 1L);
                userRepository.save(guard);
                logger.info("Initialized default seed Admin and Forest Guard accounts.");
            }

            // 2. Seed Forest Areas
            if (forestAreaRepository.count() == 0) {
                ForestArea area1 = new ForestArea(
                    "Amazon Sector Alpha",
                    "Northern Reserve, Zone 4",
                    -3.4653,
                    -62.2159,
                    "{\"type\":\"Polygon\",\"coordinates\":[[[-62.22,-3.47],[-62.21,-3.47],[-62.21,-3.46],[-62.22,-3.46],[-62.22,-3.47]]]}",
                    1L,
                    "Officer John Silva"
                );

                ForestArea area2 = new ForestArea(
                    "Black Forest Ridge",
                    "Southern Range, Zone 12",
                    48.1371,
                    11.5754,
                    "{\"type\":\"Polygon\",\"coordinates\":[[[11.57,48.13],[11.58,48.13],[11.58,48.14],[11.57,48.14],[11.57,48.13]]]}",
                    null,
                    "Unassigned"
                );

                ForestArea area3 = new ForestArea(
                    "Borneo Rainforest Sector",
                    "East Kalimantan Province",
                    -0.7893,
                    113.9213,
                    "{\"type\":\"Polygon\",\"coordinates\":[[[113.91,-0.79],[113.93,-0.79],[113.93,-0.78],[113.91,-0.78],[113.91,-0.79]]]}",
                    null,
                    "Unassigned"
                );

                forestAreaRepository.saveAll(List.of(area1, area2, area3));
                logger.info("Initialized default seed Forest Areas.");
            }

            // 3. Seed Deforestation Alerts
            if (alertRepository.count() == 0) {
                DeforestationAlert alert = new DeforestationAlert();
                alert.setAreaId(1L);
                alert.setAreaName("Amazon Sector Alpha");
                alert.setDetectionDate(LocalDate.now().minusDays(2));
                alert.setPreviousDate(LocalDate.now().minusDays(32));
                alert.setCurrentDate(LocalDate.now().minusDays(2));
                alert.setChangePercentage(28.4);
                alert.setEstimatedAffectedAreaHectares(52.5);
                alert.setStatus(AlertStatus.POTENTIAL);
                alert.setAssignedGuardId(1L);
                alert.setAssignedGuardName("Officer John Silva");
                alert.setInvestigationStatus(InvestigationStatus.PENDING);
                alert.setPreviousImageUrl("data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI2MDAiIGhlaWdodD0iNDAwIj48cmVjdCB3aWR0aD0iNjAwIiBoZWlnaHQ9IjQwMCIgZmlsbD0iIzE1ODAzZCIvPjx0ZXh0IHg9IjMwIiB5PSI1MCIgZmlsbD0iI2ZmZiI+QW1hem9uIFNlY3RvciBBbHBoYSAtIEJlZm9yZSAoTkRWSTogMC44NSk8L3RleHQ+PC9zdmc+");
                alert.setCurrentImageUrl("data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI2MDAiIGhlaWdodD0iNDAwIj48cmVjdCB3aWR0aD0iNjAwIiBoZWlnaHQ9IjQwMCIgZmlsbD0iI2ExNjIwNyIvPjx0ZXh0IHg9IjMwIiB5PSI1MCIgZmlsbD0iI2ZmZiI+QW1hem9uIFNlY3RvciBBbHBoYSAtIEFmdGVyIChOREZJOiAwLjM4KTwvdGV4dD48L3N2Zz4=");
                alert.setChangeOverlayUrl("data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI2MDAiIGhlaWdodD0iNDAwIj48cmVjdCB3aWR0aD0iNjAwIiBoZWlnaHQ9IjQwMCIgZmlsbD0iIzAyMDYxNyIvPjxwYXRoIGQ9Ik0xNTAgMTAwIEwgNDAwIDMwMCBM IDEwMCAzNTAgWiIgZmlsbD0iI2VmNDQ0NCIvPjx0ZXh0IHg9IjMwIiB5PSI1MCIgZmlsbD0iI2ZmZiI+Q0hBTkdFIE9WRVJMQVk8L3RleHQ+PC9zdmc+");

                alertRepository.save(alert);
                logger.info("Initialized default seed Deforestation Alerts.");
            }
        } catch (Exception e) {
            logger.warn("Data initialization deferred or failed gracefully: {}", e.getMessage());
        }
    }
}
