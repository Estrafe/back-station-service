package me.diegxherrera.backstationservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "station")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = true)
    private String stationName;

    @Column(nullable = true)
    private UUID cityId;

    @ElementCollection
    @CollectionTable(name = "station_routes", joinColumns = @JoinColumn(name = "station_id"))
    @Column(name = "route_id")
    private Set<UUID> routeIds;

    @Column(nullable = true)
    private Boolean international;
}