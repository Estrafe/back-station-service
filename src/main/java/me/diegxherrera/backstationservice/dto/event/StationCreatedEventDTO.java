package me.diegxherrera.backstationservice.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StationCreatedEventDTO {
    private UUID stationId;  // Unique identifier of the station
    private String stationName;  // Name of the station
    private UUID cityId;  // The city ID where the station is located
    private Set<UUID> routeIds;  // Routes that serve this station
    private Boolean isInternational;  // Whether the station is international or not
}