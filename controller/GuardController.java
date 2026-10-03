package com.forest.surveillance.controller;

import com.forest.surveillance.dto.ForestGuardDto;
import com.forest.surveillance.service.ForestGuardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guards")
public class GuardController {

    private final ForestGuardService forestGuardService;

    public GuardController(ForestGuardService forestGuardService) {
        this.forestGuardService = forestGuardService;
    }

    @GetMapping
    public ResponseEntity<List<ForestGuardDto>> getAllGuards() {
        return ResponseEntity.ok(forestGuardService.getAllGuards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForestGuardDto> getGuardById(@PathVariable Long id) {
        return ResponseEntity.ok(forestGuardService.getGuardById(id));
    }

    @PostMapping
    public ResponseEntity<ForestGuardDto> createGuard(@RequestBody ForestGuardDto dto) {
        ForestGuardDto created = forestGuardService.createGuard(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForestGuardDto> updateGuard(@PathVariable Long id, @RequestBody ForestGuardDto dto) {
        return ResponseEntity.ok(forestGuardService.updateGuard(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateGuard(@PathVariable Long id) {
        forestGuardService.deactivateGuard(id);
        return ResponseEntity.noContent().build();
    }
}
