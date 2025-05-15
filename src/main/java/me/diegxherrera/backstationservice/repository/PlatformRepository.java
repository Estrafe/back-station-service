package me.diegxherrera.backstationservice.repository;

import me.diegxherrera.backstationservice.model.PlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlatformRepository extends JpaRepository<PlatformEntity, UUID> {
    // Example: Find platforms by station ID
    List<PlatformEntity> findByStationId(UUID stationId);
}