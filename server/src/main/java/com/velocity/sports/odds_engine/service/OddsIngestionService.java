package com.velocity.sports.odds_engine.service;

import com.velocity.sports.odds_engine.model.MatchEntity;
import com.velocity.sports.odds_engine.model.MatchUpdate;
import com.velocity.sports.odds_engine.repository.OddsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class OddsIngestionService {
    private final SimpMessagingTemplate messagingTemplate;
    private final Random random = new Random();
    private final OddsRepository oddsRepository;

    private final List<String> matchIds = List.of("M1", "M2", "M3", "M4", "M5");

    @Scheduled(fixedRate = 1000, initialDelay = 2000)
    public void generateLiveUpdates() {
        String randomMatch = matchIds.get(random.nextInt(matchIds.size()));

//        Generate new odds
        MatchUpdate update=new MatchUpdate(
                randomMatch,
                "Soccer",
                "Team A",
                "Team B",
                1.5 + random.nextDouble(),
                2.5 + random.nextDouble(),
                Instant.now()
        );

//        Save to database
        MatchEntity entity=new MatchEntity();
        entity.setMatchId(update.matchId());
        entity.setHomeOdds(update.homeOdds());
        entity.setAwayOdds(update.awayOdds());
        entity.setTimestamp(update.timestamp());
        oddsRepository.save(entity);

//        Push to Web socket
        messagingTemplate.convertAndSend("/topic/odds", update);

        log.info("Direct broadcast: {} | Prices: {} / {}", randomMatch, update.homeOdds(), update.awayOdds());
    }
}