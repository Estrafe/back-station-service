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
public class DeletePlatformRequest {
    private UUID platformId; // The ID of the platform to be deleted
}