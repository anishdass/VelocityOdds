package com.velocity.sports.odds_engine.model;

import java.time.Instant;

public record MatchUpdate(
        String matchId,
        String sport,
        String homeTeam,
        String awayTeam,
        String homeOdds,
        String awayOdds,
        Instant timestamp) {
}
