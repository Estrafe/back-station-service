package me.diegxherrera.backstationservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePlatformRequest {
    private UUID stationId;
    private int platformNumber;
    private boolean isAccessible;
    private Integer lengthInMeters;
}