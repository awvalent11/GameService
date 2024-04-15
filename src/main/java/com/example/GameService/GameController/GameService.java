package com.example.GameService.GameController;


import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameController gameController;

    Logger logger;

    public GameService(GameController gameController) {
        this.gameController = gameController;
    }


    public Game filterGame(GameDTO game){
        Game returnedGame = Game.builder().build();
//
        returnedGame.setHome(game.getHome());
        returnedGame.setAway(game.getAway());
        returnedGame.setOdds(game.getOdds());
        returnedGame.setExpiration(game.getGameStartTime());

        return returnedGame;
    }

    @SneakyThrows
    @Scheduled(fixedRate = 100000)
    @Transactional
    public void getGamesSpecificWeek(){
//        logger.info("You're hitting me!");
//        System.out.println("You're hitting me, SOUT!");
//        ArrayList<Game> gameList = new ArrayList<>();
//        List<GameDTO> games = gameController.getOdds();
        //filter non-Game fields
//        System.out.printf("Games: %s%n", games);
//        for( GameDTO game : games){
//            gameList.add(filterGame(game));
//        }
//        System.out.println(gameList);
        Object mlbSchedule = gameController.getMLBSchedule();
        System.out.println(mlbSchedule);
        //"GlobalGameId": 10070978 -> Can we use that bad boy to zip together odds?


    }

    public void findGamesUsages(Profile[] profiles, Game[] gameList){
        //find games that are used in bets
        //check if games have resolved
        //if they have, settle the bets
    }

        //sends message to kafka producer
}
