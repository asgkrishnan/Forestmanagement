package com.forest.surveillance.repository;

import com.forest.surveillance.entity.MonitoringRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitoringRecordRepository extends JpaRepository<MonitoringRecord, Long> {
    List<MonitoringRecord> findByAreaIdOrderByCreatedTimestampDesc(Long areaId);
    List<MonitoringRecord> findAllByOrderByCreatedTimestampDesc();
}
