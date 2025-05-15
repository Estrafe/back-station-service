package me.diegxherrera.backstationservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "platform")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlatformEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID platformId;

    @Column(nullable = false)
    private UUID stationId;

    @Column(nullable = false)
    private UUID platformNumber;

    @Column(nullable = false)
    private Boolean isAccessible;

    @Column
    private Integer lengthInMeters;
}