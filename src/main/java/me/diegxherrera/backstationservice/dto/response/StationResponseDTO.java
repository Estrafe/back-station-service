package me.diegxherrera.backstationservice.dto.response;

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
public class StationResponseDTO {
    private UUID stationId;  // Unique identifier of the station
    private String stationName;  // Name of the station
    private UUID cityId;  // The city where the station is located
    private Set<UUID> routeIds;  // A set of UUIDs representing routes that serve the station
    private Boolean isInternational;  // Whether the station is international or not
}