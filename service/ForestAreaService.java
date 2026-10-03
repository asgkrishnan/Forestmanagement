package com.forest.surveillance.service;

import com.forest.surveillance.dto.ForestAreaDto;
import com.forest.surveillance.entity.ForestArea;
import com.forest.surveillance.entity.ForestGuard;
import com.forest.surveillance.exception.ForestAreaNotFoundException;
import com.forest.surveillance.repository.ForestAreaRepository;
import com.forest.surveillance.repository.ForestGuardRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ForestAreaService {

    private final ForestAreaRepository forestAreaRepository;
    private final ForestGuardRepository forestGuardRepository;

    public ForestAreaService(ForestAreaRepository forestAreaRepository, ForestGuardRepository forestGuardRepository) {
        this.forestAreaRepository = forestAreaRepository;
        this.forestGuardRepository = forestGuardRepository;
    }



    public List<ForestAreaDto> getAllForestAreas() {
        return forestAreaRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ForestAreaDto getForestAreaById(Long id) {
        ForestArea area = forestAreaRepository.findById(id)
                .orElseThrow(() -> new ForestAreaNotFoundException("Forest Area not found with ID: " + id));
        return mapToDto(area);
    }

    public ForestAreaDto createForestArea(ForestAreaDto dto) {
        ForestArea area = new ForestArea();
        area.setName(dto.getName());
        area.setLocation(dto.getLocation());
        area.setLatitude(dto.getLatitude());
        area.setLongitude(dto.getLongitude());
        area.setBoundaryGeoJson(dto.getBoundaryGeoJson());
        area.setAssignedGuardId(dto.getAssignedGuardId());
        area.setActive(dto.isActive());

        if (dto.getAssignedGuardId() != null) {
            Optional<ForestGuard> guardOpt = forestGuardRepository.findById(dto.getAssignedGuardId());
            guardOpt.ifPresent(guard -> {
                area.setAssignedGuardName(guard.getFullName());
                guard.setAssignedAreaId(area.getId());
                forestGuardRepository.save(guard);
            });
        }

        ForestArea saved = forestAreaRepository.save(area);
        return mapToDto(saved);
    }

    public ForestAreaDto updateForestArea(Long id, ForestAreaDto dto) {
        ForestArea area = forestAreaRepository.findById(id)
                .orElseThrow(() -> new ForestAreaNotFoundException("Forest Area not found with ID: " + id));

        area.setName(dto.getName());
        area.setLocation(dto.getLocation());
        area.setLatitude(dto.getLatitude());
        area.setLongitude(dto.getLongitude());
        area.setBoundaryGeoJson(dto.getBoundaryGeoJson());
        area.setAssignedGuardId(dto.getAssignedGuardId());
        area.setActive(dto.isActive());

        if (dto.getAssignedGuardId() != null) {
            Optional<ForestGuard> guardOpt = forestGuardRepository.findById(dto.getAssignedGuardId());
            if (guardOpt.isPresent()) {
                ForestGuard guard = guardOpt.get();
                area.setAssignedGuardName(guard.getFullName());
                guard.setAssignedAreaId(area.getId());
                forestGuardRepository.save(guard);
            }
        } else {
            area.setAssignedGuardName("Unassigned");
        }

        ForestArea updated = forestAreaRepository.save(area);
        return mapToDto(updated);
    }

    public void deactivateForestArea(Long id) {
        ForestArea area = forestAreaRepository.findById(id)
                .orElseThrow(() -> new ForestAreaNotFoundException("Forest Area not found with ID: " + id));
        area.setActive(false);
        forestAreaRepository.save(area);
    }

    private ForestAreaDto mapToDto(ForestArea area) {
        ForestAreaDto dto = new ForestAreaDto();
        dto.setId(area.getId());
        dto.setName(area.getName());
        dto.setLocation(area.getLocation());
        dto.setLatitude(area.getLatitude());
        dto.setLongitude(area.getLongitude());
        dto.setBoundaryGeoJson(area.getBoundaryGeoJson());
        dto.setAssignedGuardId(area.getAssignedGuardId());
        dto.setAssignedGuardName(area.getAssignedGuardName() != null ? area.getAssignedGuardName() : "Unassigned");
        dto.setActive(area.isActive());
        return dto;
    }
}
