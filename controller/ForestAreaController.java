package com.forest.surveillance.controller;

import com.forest.surveillance.dto.ForestAreaDto;
import com.forest.surveillance.service.ForestAreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forest-areas")
public class ForestAreaController {

    private final ForestAreaService forestAreaService;

    public ForestAreaController(ForestAreaService forestAreaService) {
        this.forestAreaService = forestAreaService;
    }

    @GetMapping
    public ResponseEntity<List<ForestAreaDto>> getAllAreas() {
        return ResponseEntity.ok(forestAreaService.getAllForestAreas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForestAreaDto> getAreaById(@PathVariable Long id) {
        return ResponseEntity.ok(forestAreaService.getForestAreaById(id));
    }

    @PostMapping
    public ResponseEntity<ForestAreaDto> createArea(@RequestBody ForestAreaDto dto) {
        ForestAreaDto created = forestAreaService.createForestArea(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForestAreaDto> updateArea(@PathVariable Long id, @RequestBody ForestAreaDto dto) {
        return ResponseEntity.ok(forestAreaService.updateForestArea(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateArea(@PathVariable Long id) {
        forestAreaService.deactivateForestArea(id);
        return ResponseEntity.noContent().build();
    }
}
