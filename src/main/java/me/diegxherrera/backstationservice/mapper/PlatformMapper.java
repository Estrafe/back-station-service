package me.diegxherrera.backstationservice.mapper;

import me.diegxherrera.backstationservice.dto.request.CreatePlatformRequest;
import me.diegxherrera.backstationservice.dto.request.UpdatePlatformRequest;
import me.diegxherrera.backstationservice.dto.response.PlatformResponseDTO;
import me.diegxherrera.backstationservice.model.PlatformEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PlatformMapper {

    PlatformResponseDTO toResponseDTO(PlatformEntity platform);

    PlatformEntity fromCreateRequest(CreatePlatformRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget PlatformEntity platform, UpdatePlatformRequest request);
}