package com.forest.surveillance.service;

import com.forest.surveillance.dto.ForestGuardDto;
import com.forest.surveillance.entity.ForestArea;
import com.forest.surveillance.entity.ForestGuard;
import com.forest.surveillance.exception.ForestGuardNotFoundException;
import com.forest.surveillance.repository.ForestAreaRepository;
import com.forest.surveillance.repository.ForestGuardRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ForestGuardService {

    private final ForestGuardRepository forestGuardRepository;
    private final ForestAreaRepository forestAreaRepository;
    private final PasswordEncoder passwordEncoder;

    public ForestGuardService(ForestGuardRepository forestGuardRepository, ForestAreaRepository forestAreaRepository, PasswordEncoder passwordEncoder) {
        this.forestGuardRepository = forestGuardRepository;
        this.forestAreaRepository = forestAreaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<ForestGuardDto> getAllGuards() {
        return forestGuardRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ForestGuardDto getGuardById(Long id) {
        ForestGuard guard = forestGuardRepository.findById(id)
                .orElseThrow(() -> new ForestGuardNotFoundException("Forest Guard not found with ID: " + id));
        return mapToDto(guard);
    }

    public ForestGuardDto createGuard(ForestGuardDto dto) {
        ForestGuard guard = new ForestGuard();
        guard.setUsername(dto.getUsername());
        guard.setPassword(passwordEncoder.encode(dto.getPassword() != null ? dto.getPassword() : "guard123"));
        guard.setFullName(dto.getFullName());
        guard.setEmail(dto.getEmail());
        guard.setGuardIdCode(dto.getGuardIdCode() != null ? dto.getGuardIdCode() : "FG" + System.currentTimeMillis() % 1000);
        guard.setPhoneNumber(dto.getPhoneNumber());
        guard.setAssignedAreaId(dto.getAssignedAreaId());
        guard.setActive(dto.isActive());

        ForestGuard saved = forestGuardRepository.save(guard);

        if (dto.getAssignedAreaId() != null) {
            updateAreaGuardAssociation(saved);
        }

        return mapToDto(saved);
    }

    public ForestGuardDto updateGuard(Long id, ForestGuardDto dto) {
        ForestGuard guard = forestGuardRepository.findById(id)
                .orElseThrow(() -> new ForestGuardNotFoundException("Forest Guard not found with ID: " + id));

        guard.setFullName(dto.getFullName());
        guard.setEmail(dto.getEmail());
        if (dto.getGuardIdCode() != null) {
            guard.setGuardIdCode(dto.getGuardIdCode());
        }
        guard.setPhoneNumber(dto.getPhoneNumber());
        guard.setAssignedAreaId(dto.getAssignedAreaId());
        guard.setActive(dto.isActive());

        if (dto.getPassword() != null && !dto.getPassword().trim().isEmpty()) {
            guard.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        ForestGuard updated = forestGuardRepository.save(guard);

        if (dto.getAssignedAreaId() != null) {
            updateAreaGuardAssociation(updated);
        }

        return mapToDto(updated);
    }

    public void deactivateGuard(Long id) {
        ForestGuard guard = forestGuardRepository.findById(id)
                .orElseThrow(() -> new ForestGuardNotFoundException("Forest Guard not found with ID: " + id));
        guard.setActive(false);
        forestGuardRepository.save(guard);
    }

    private void updateAreaGuardAssociation(ForestGuard guard) {
        if (guard.getAssignedAreaId() != null) {
            Optional<ForestArea> areaOpt = forestAreaRepository.findById(guard.getAssignedAreaId());
            if (areaOpt.isPresent()) {
                ForestArea area = areaOpt.get();
                area.setAssignedGuardId(guard.getId());
                area.setAssignedGuardName(guard.getFullName());
                forestAreaRepository.save(area);
            }
        }
    }

    private ForestGuardDto mapToDto(ForestGuard guard) {
        ForestGuardDto dto = new ForestGuardDto();
        dto.setId(guard.getId());
        dto.setUsername(guard.getUsername());
        dto.setFullName(guard.getFullName());
        dto.setEmail(guard.getEmail());
        dto.setGuardIdCode(guard.getGuardIdCode());
        dto.setPhoneNumber(guard.getPhoneNumber());
        dto.setAssignedAreaId(guard.getAssignedAreaId());
        dto.setActive(guard.isActive());

        if (guard.getAssignedAreaId() != null) {
            forestAreaRepository.findById(guard.getAssignedAreaId())
                    .ifPresent(area -> dto.setAssignedAreaName(area.getName()));
        }

        return dto;
    }
}
