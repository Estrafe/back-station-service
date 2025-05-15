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
public class StationUpdatedEventDTO {
    private UUID stationId;  // Unique identifier of the station
    private String stationName;  // Updated name of the station
    private UUID cityId;  // Updated city ID
    private Set<UUID> routeIds;  // Updated set of routes serving this station
    private Boolean isInternational;  // Whether the station is international or not
}