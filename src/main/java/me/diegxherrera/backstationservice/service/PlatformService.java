package me.diegxherrera.backstationservice.service;

import me.diegxherrera.backstationservice.dto.request.CreatePlatformRequest;
import me.diegxherrera.backstationservice.dto.request.UpdatePlatformRequest;
import me.diegxherrera.backstationservice.dto.response.PlatformResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PlatformService {
    PlatformResponseDTO createPlatform(CreatePlatformRequest request);
    PlatformResponseDTO getPlatformById(UUID id);
    List<PlatformResponseDTO> getAllPlatforms();
    PlatformResponseDTO updatePlatform(UUID id, UpdatePlatformRequest request);
    void deletePlatform(UUID id);
}