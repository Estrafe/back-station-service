package me.diegxherrera.backstationservice.service.impl;

import lombok.RequiredArgsConstructor;
import me.diegxherrera.backstationservice.dto.request.CreateStationRequest;
import me.diegxherrera.backstationservice.dto.request.UpdateStationRequest;
import me.diegxherrera.backstationservice.dto.response.StationResponseDTO;
import me.diegxherrera.backstationservice.exception.StationNotFoundException;
import me.diegxherrera.backstationservice.mapper.StationMapper;
import me.diegxherrera.backstationservice.model.StationEntity;
import me.diegxherrera.backstationservice.repository.StationRepository;
import me.diegxherrera.backstationservice.service.StationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    @Override
    public StationResponseDTO createStation(CreateStationRequest request) {
        StationEntity station = stationMapper.fromCreateRequest(request);
        StationEntity savedStation = stationRepository.save(station);
        return stationMapper.toResponseDTO(savedStation);
    }

    @Override
    public StationResponseDTO getStationById(UUID id) {
        StationEntity station = stationRepository.findById(id)
                .orElseThrow(() -> new StationNotFoundException("Station with ID " + id + " not found"));
        return stationMapper.toResponseDTO(station);
    }

    @Override
    public List<StationResponseDTO> getAllStations() {
        return stationRepository.findAll().stream()
                .map(stationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StationResponseDTO updateStation(UUID id, UpdateStationRequest request) {
        StationEntity existingStation = stationRepository.findById(id)
                .orElseThrow(() -> new StationNotFoundException("Station with ID " + id + " not found"));

        stationMapper.partialUpdate(existingStation, request);
        StationEntity savedStation = stationRepository.save(existingStation);
        return stationMapper.toResponseDTO(savedStation);
    }

    @Override
    public void deleteStation(UUID id) {
        if (!stationRepository.existsById(id)) {
            throw new StationNotFoundException("Station with ID " + id + " not found");
        }
        stationRepository.deleteById(id);
    }
}