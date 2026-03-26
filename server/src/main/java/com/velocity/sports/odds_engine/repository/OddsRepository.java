package com.velocity.sports.odds_engine.repository;

import com.velocity.sports.odds_engine.model.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OddsRepository extends JpaRepository<MatchEntity, Long> {
}
