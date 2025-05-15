package me.diegxherrera.backstationservice.service.impl;

import lombok.RequiredArgsConstructor;
import me.diegxherrera.backstationservice.dto.request.CreatePlatformRequest;
import me.diegxherrera.backstationservice.dto.request.UpdatePlatformRequest;
import me.diegxherrera.backstationservice.dto.response.PlatformResponseDTO;
import me.diegxherrera.backstationservice.exception.PlatformNotFoundException;
import me.diegxherrera.backstationservice.mapper.PlatformMapper;
import me.diegxherrera.backstationservice.model.PlatformEntity;
import me.diegxherrera.backstationservice.repository.PlatformRepository;
import me.diegxherrera.backstationservice.service.PlatformService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {

    private final PlatformRepository platformRepository;
    private final PlatformMapper platformMapper;

    @Override
    public PlatformResponseDTO createPlatform(CreatePlatformRequest request) {
        PlatformEntity platform = platformMapper.fromCreateRequest(request);
        PlatformEntity saved = platformRepository.save(platform);
        return platformMapper.toResponseDTO(saved);
    }

    @Override
    public PlatformResponseDTO getPlatformById(UUID id) {
        PlatformEntity platform = platformRepository.findById(id)
                .orElseThrow(() -> new PlatformNotFoundException("Platform with ID " + id + " not found"));
        return platformMapper.toResponseDTO(platform);
    }

    @Override
    public List<PlatformResponseDTO> getAllPlatforms() {
        return platformRepository.findAll().stream()
                .map(platformMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlatformResponseDTO updatePlatform(UUID id, UpdatePlatformRequest request) {
        PlatformEntity existing = platformRepository.findById(id)
                .orElseThrow(() -> new PlatformNotFoundException("Platform with ID " + id + " not found"));

        platformMapper.partialUpdate(existing, request);
        PlatformEntity saved = platformRepository.save(existing);
        return platformMapper.toResponseDTO(saved);
    }

    @Override
    public void deletePlatform(UUID id) {
        if (!platformRepository.existsById(id)) {
            throw new PlatformNotFoundException("Platform with ID " + id + " not found");
        }
        platformRepository.deleteById(id);
    }
}