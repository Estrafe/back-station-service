package me.diegxherrera.backstationservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStationRequest {
    private String stationName;
    private UUID cityId;
    private List<UUID> routeIds;
    private boolean international;
}