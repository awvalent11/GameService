package com.example.GameService.GameController;


import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameController gameController;

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

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public ArrayList<Game> getGamesSpecificWeek(){
        System.out.println("You're hitting me!");
        ArrayList<Game> gameList = new ArrayList<>();
        List<GameDTO> games = gameController.getOdds();
        //filter non-Game fields
        for( GameDTO game : games){
            gameList.add(filterGame(game));
        }
        System.out.println(gameList);
        return gameList;

    }

    public void findGamesUsages(Profile[] profiles, Game[] gameList){
        //find games that are used in bets
        //check if games have resolved
        //if they have, settle the bets
    }

        //sends message to kafka producer
}
