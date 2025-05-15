package me.diegxherrera.backstationservice.repository;

import me.diegxherrera.backstationservice.model.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StationRepository extends JpaRepository<StationEntity, UUID> {
    // Example: Find stations by city ID
    List<StationEntity> findByCityId(UUID cityId);
}