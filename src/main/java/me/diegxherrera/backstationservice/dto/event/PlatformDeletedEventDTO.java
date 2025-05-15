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
public class PlatformDeletedEventDTO {
    private UUID platformId;  // Unique identifier of the platform being deleted
}