package com.forest.surveillance.repository;

import com.forest.surveillance.entity.AlertStatus;
import com.forest.surveillance.entity.DeforestationAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeforestationAlertRepository extends JpaRepository<DeforestationAlert, Long> {
    List<DeforestationAlert> findByStatusOrderByCreatedAtDesc(AlertStatus status);
    List<DeforestationAlert> findByAssignedGuardIdOrderByCreatedAtDesc(Long guardId);
    List<DeforestationAlert> findByAssignedGuardIdAndStatusOrderByCreatedAtDesc(Long guardId, AlertStatus status);
    long countByStatus(AlertStatus status);
}
