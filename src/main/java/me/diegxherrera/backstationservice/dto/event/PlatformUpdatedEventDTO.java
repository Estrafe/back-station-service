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
public class PlatformUpdatedEventDTO {
    private UUID platformId;  // Unique identifier of the platform
    private String platformNumber;  // Updated platform number
    private Boolean isAccessible;  // Updated accessibility status
    private Integer lengthInMeters;  // Updated length of the platform
}