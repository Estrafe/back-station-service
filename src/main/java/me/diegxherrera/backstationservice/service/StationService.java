package me.diegxherrera.backstationservice.service;

import me.diegxherrera.backstationservice.dto.request.CreateStationRequest;
import me.diegxherrera.backstationservice.dto.request.UpdateStationRequest;
import me.diegxherrera.backstationservice.dto.response.StationResponseDTO;

import java.util.List;
import java.util.UUID;

public interface StationService {

    // Create a new station and return a StationResponseDTO
    StationResponseDTO createStation(CreateStationRequest request);

    // Get a station by its ID and return a StationResponseDTO
    StationResponseDTO getStationById(UUID id);

    // Get all stations and return a list of StationResponseDTO
    List<StationResponseDTO> getAllStations();

    // Update a station and return the updated StationResponseDTO
    StationResponseDTO updateStation(UUID id, UpdateStationRequest request);

    // Delete a station by its ID
    void deleteStation(UUID id);
}