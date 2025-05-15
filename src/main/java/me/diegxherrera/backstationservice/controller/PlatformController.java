package me.diegxherrera.backstationservice.controller;

import lombok.RequiredArgsConstructor;
import me.diegxherrera.backstationservice.dto.request.CreatePlatformRequest;
import me.diegxherrera.backstationservice.dto.request.UpdatePlatformRequest;
import me.diegxherrera.backstationservice.dto.response.PlatformResponseDTO;
import me.diegxherrera.backstationservice.service.PlatformService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/platforms")
@RequiredArgsConstructor
public class PlatformController {

    private final PlatformService platformService;

    @PostMapping
    public ResponseEntity<PlatformResponseDTO> createPlatform(@RequestBody CreatePlatformRequest request) {
        return ResponseEntity.ok(platformService.createPlatform(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformResponseDTO> getPlatformById(@PathVariable UUID id) {
        return ResponseEntity.ok(platformService.getPlatformById(id));
    }

    @GetMapping
    public ResponseEntity<List<PlatformResponseDTO>> getAllPlatforms() {
        return ResponseEntity.ok(platformService.getAllPlatforms());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlatformResponseDTO> updatePlatform(@PathVariable UUID id,
                                                              @RequestBody UpdatePlatformRequest request) {
        return ResponseEntity.ok(platformService.updatePlatform(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlatform(@PathVariable UUID id) {
        platformService.deletePlatform(id);
        return ResponseEntity.noContent().build();
    }
}