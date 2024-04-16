package com.example.GameService.GameController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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
        returnedGame.setStartTime(game.getDateTime());

        return returnedGame;
    }

    private Boolean parseStatus(String aPistatus) {
        if(aPistatus.equals("Final")) {
            return true;
        } else return false;
    }

    private List<Game> parseGame(ArrayList games) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(String.valueOf(games));
        List<Game> gameList = new ArrayList<>();
        String gamesAsString = objectMapper.writeValueAsString(games);
        gamesAsString.replace("=", ":");
        String[] gameDTOList = gamesAsString.split("]}");
        ArrayList<String> gameDTOArrayList = new ArrayList<>(List.of(gameDTOList));
        System.out.println(gameDTOArrayList);
        for(String game : gameDTOArrayList) {
            try {
                System.out.println(String.format("I am a game: %s", game));
            }catch (Error err){
                logger.info(err.toString());
            }
        }
        return gameList;
//        for(Map.Entry<String, String> entry : games.entrySet())
//        List<GameDTO> gameDTOS = (List<GameDTO>) games;
//        for(GameDTO gameDTO : gameDTOS){
//            Game game = Game.builder()
//                    .away(gameDTO.getAwayTeamName())
//                    .home(gameDTO.getHomeTeamName())
//                    .startTime(gameDTO.getDateTime())
//                    .status(parseStatus(gameDTO.getStatus()))
//                    .build();
//            gameList.add(game);
//        }
//        return objectMapper.readValue(games);
//        return gamesAsString;

    }

    @SneakyThrows
    @Scheduled(fixedRate = 100000)
    @Transactional
    public void getGamesSpecificWeek(){

        ArrayList mlbSchedule = gameController.getMLBSchedule();
//        System.out.println(mlbSchedule);
        List<Game> todayGames = parseGame(mlbSchedule);
        System.out.println(todayGames);
        //"GlobalGameId": 10070978 -> Can we use that bad boy to zip together odds?


    }

    public void findGamesUsages(Profile[] profiles, Game[] gameList){
        //find games that are used in bets
        //check if games have resolved
        //if they have, settle the bets
    }

        //sends message to kafka producer
}
