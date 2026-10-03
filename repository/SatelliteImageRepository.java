package com.forest.surveillance.repository;

import com.forest.surveillance.entity.SatelliteImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SatelliteImageRepository extends JpaRepository<SatelliteImage, Long> {
    List<SatelliteImage> findByAreaIdOrderByAcquisitionDateDesc(Long areaId);
}
