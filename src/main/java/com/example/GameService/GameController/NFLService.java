package com.example.GameService.GameController;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class NFLService {

    private final GameController gameController;
    public NFLService(GameController gameController) {
        this.gameController = gameController;
    }

    Logger logger;

    List<String> sportbooks = Arrays.asList("FanDuel", "Caesars", "Bet365",
            "Fanatics", "DraftKings", "Betrivers",
            "BetMGM", "Betway", "ClutchBet", "Desert Diamond");

    public void findGamesUsages(Profile[] profiles, Game[] gameList){
//        find games that are used in bets
//        check if games have resolved
//        if they have, settle the bets
    }

    private void getLiveOdds(List<Integer> scoreIds, List<String> sportbooks){

        for (Integer scoreId : scoreIds) {
            // check if any customers are betting or following that game
            for (String sportbook : sportbooks) {
                String liveOddsPerGame = String.format("https://api.sportsdata.io/v3/nfl/odds/json/InGameLineMovementWithResulting/%s/%s", scoreId, sportbook);

                //send live bet line data message in broker
            }
        }
    }

    @SneakyThrows
    @PostConstruct
    //@Scheduled(cron = "0 */15 * * * ?")
    //4:38PM every day
    // * is every time and 0 is once
    @Transactional
    public void updateLiveOdds(){
        Boolean gamesInProgress = gameController.getNFLGameProgress();
        if(gamesInProgress){
            List<Integer> gameIds = new ArrayList<>();
            List<LinkedHashMap> nflWeekGames = gameController.getNFLSchedule();
            for (LinkedHashMap nflWeekGame : nflWeekGames) {
                try{
                    gameIds.add((Integer) nflWeekGame.get("GameId"));
                } catch (Exception e){
                    logger.info(e.toString());
                }
            getLiveOdds(gameIds, sportbooks);
            }
        }
    }



    //sends message to kafka producer
}