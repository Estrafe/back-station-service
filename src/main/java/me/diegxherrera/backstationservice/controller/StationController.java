package me.diegxherrera.backstationservice.controller;

import lombok.RequiredArgsConstructor;
import me.diegxherrera.backstationservice.dto.request.CreateStationRequest;
import me.diegxherrera.backstationservice.dto.request.UpdateStationRequest;
import me.diegxherrera.backstationservice.dto.response.StationResponseDTO;
import me.diegxherrera.backstationservice.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stations")
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;

    @PostMapping
    public ResponseEntity<StationResponseDTO> createStation(@RequestBody CreateStationRequest request) {
        return ResponseEntity.ok(stationService.createStation(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StationResponseDTO> getStationById(@PathVariable UUID id) {
        return ResponseEntity.ok(stationService.getStationById(id));
    }

    @GetMapping
    public ResponseEntity<List<StationResponseDTO>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StationResponseDTO> updateStation(@PathVariable UUID id,
                                                            @RequestBody UpdateStationRequest request) {
        return ResponseEntity.ok(stationService.updateStation(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable UUID id) {
        stationService.deleteStation(id);
        return ResponseEntity.noContent().build();
    }
}