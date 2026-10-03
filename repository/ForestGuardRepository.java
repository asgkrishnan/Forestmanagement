package com.forest.surveillance.repository;

import com.forest.surveillance.entity.ForestGuard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForestGuardRepository extends JpaRepository<ForestGuard, Long> {
    Optional<ForestGuard> findByGuardIdCode(String guardIdCode);
    Optional<ForestGuard> findByUsername(String username);
    List<ForestGuard> findByActiveTrue();
}
