package com.velocity.sports.odds_engine.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "odds_history")
@Data
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matchId;
    private double homeOdds;
    private double awayOdds;
    private Instant timestamp;
}
