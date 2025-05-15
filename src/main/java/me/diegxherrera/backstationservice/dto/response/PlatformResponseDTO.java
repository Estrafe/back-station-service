package me.diegxherrera.backstationservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformResponseDTO {
    private UUID platformId;  // Platform unique identifier
    private String platformNumber;  // Platform number (e.g., 1, 2, 3)
    private Boolean isAccessible;  // Whether the platform is accessible or not
    private UUID stationId;  // The station where the platform belongs
    private Integer lengthInMeters;  // The length of the platform
}