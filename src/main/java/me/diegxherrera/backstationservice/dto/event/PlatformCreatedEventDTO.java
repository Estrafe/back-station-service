package me.diegxherrera.backstationservice.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformCreatedEventDTO {
    private UUID platformId;  // Unique identifier of the platform
    private String platformNumber;  // Platform number
    private Boolean isAccessible;  // Accessibility status of the platform
    private UUID stationId;  // The station where the platform belongs
    private Integer lengthInMeters;  // Length of the platform
}