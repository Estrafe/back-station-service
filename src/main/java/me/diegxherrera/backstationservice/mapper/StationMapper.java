package me.diegxherrera.backstationservice.mapper;

import me.diegxherrera.backstationservice.dto.request.CreateStationRequest;
import me.diegxherrera.backstationservice.dto.request.UpdateStationRequest;
import me.diegxherrera.backstationservice.dto.response.StationResponseDTO;
import me.diegxherrera.backstationservice.model.StationEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface StationMapper {

    StationResponseDTO toResponseDTO(StationEntity stationEntity);

    StationEntity fromCreateRequest(CreateStationRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget StationEntity stationEntity, UpdateStationRequest request);
}