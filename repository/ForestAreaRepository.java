package com.forest.surveillance.repository;

import com.forest.surveillance.entity.ForestArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForestAreaRepository extends JpaRepository<ForestArea, Long> {
    List<ForestArea> findByActiveTrue();
    List<ForestArea> findByAssignedGuardId(Long guardId);
}
