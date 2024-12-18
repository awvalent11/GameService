package com.example.GameService.GameController;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class GameService {

    private final GameController gameController;

    public static List<Game> todaysGames = new ArrayList<>();
    public static List<Game> weeksNFLGames = new ArrayList<>();

    Logger logger;

    public GameService(GameController gameController) {
        this.gameController = gameController;
    }

    private static void assignGames(List<Game> games){
        //Should return a List<Game>
        todaysGames.addAll(games);
    }

    private static void assignNFLGames(List<Game> games){
        //Should return a List<Game>
        weeksNFLGames.addAll(games);
    }


    public Game convertGame(GameDTO game){
        Game returnedGame = new Game();

        for(LinkedHashMap odds: game.getPregameOdds()){
            try {
                returnedGame.setId(game.getGameId());
                returnedGame.setHome(game.getHomeTeamName());
                returnedGame.setAway(game.getAwayTeamName());
                returnedGame.setStartTime(game.getDateTime());
                Boolean gameStatus = parseStatus(game.getStatus());
                returnedGame.setStatus(gameStatus);
                Odds pregameOdds = new Odds( (Double) odds.get("HomePointSpread"),
                        (Double) odds.get("OverUnder"),
                        (Integer) odds.get("HomeMoneyLine"),
                        (Integer) odds.get("AwayMoneyLine"),
                        (String) odds.get("SportsbookUrl"));
                if(pregameOdds.getSportsbookUrl()!= null){
                    returnedGame.getOdds().add(pregameOdds);
                }
            }catch (Error err){
                logger.info(err.toString());
            }
        }


        return returnedGame;
    }

    private Boolean parseStatus(String aPistatus) {
        return aPistatus.equals("Final");
    }

    public List<GameDTO> parseGame(ArrayList<LinkedHashMap> games) throws NullPointerException {
        List<GameDTO> gameList = new ArrayList<>();
        for(LinkedHashMap game : games) {
            try {
                System.out.println(String.format("I am a game! %s", game));
//                GameDTO gameDTO = GameDTO.builder().build();
//                gameDTO.setGameId((Integer) game.get("GameId"));
//                gameDTO.setAwayTeamName((String) game.get("AwayTeamName"));
//                gameDTO.setHomeTeamName((String) game.get("HomeTeamName"));
//                gameDTO.setDateTime((String) game.get("DateTime"));
//                gameDTO.setStatus((String) game.get("Status"));
//                gameDTO.setPregameOdds((List<LinkedHashMap>) game.get("PregameOdds"));
//                gameList.add(gameDTO);

            }catch (Error err){
                logger.info(err.toString());
            }
        }
        return gameList;
    }

    @SneakyThrows
    @PostConstruct
    @Scheduled(cron = "0 38 16 * * ?")
    //4:38PM every day
    // * is every time and 0 is once
    @Transactional
    public void getGamesSpecificWeek(){

        ArrayList mlbSchedule = gameController.getMLBSchedule();
        List<GameDTO> todayGames = parseGame(mlbSchedule);
        List<Game> convertedGames = new ArrayList<>();
        for(GameDTO game: todayGames){
            Game convertedGame = convertGame(game);
            convertedGames.add(convertedGame);
        }
        GameService.assignGames(convertedGames);

        //"GlobalGameId": 10070978 -> Can we use that bad boy to zip together odds?


    }

    @SneakyThrows
    @PostConstruct
    @Scheduled(cron = "0 35 16 * * ?")
    //4:35PM every day
    // * is every time and 0 is once
    @Transactional
    public void getNFLGamesForWeek(){

        ArrayList nflSchedule = gameController.getNFLSchedule();
        List<GameDTO> nflWeekGames = parseGame(nflSchedule);
        List<Game> convertedGames = new ArrayList<>();
        for(GameDTO game: nflWeekGames){
            Game convertedGame = convertGame(game);
            convertedGames.add(convertedGame);
        }
        GameService.assignNFLGames(convertedGames);

        //"GlobalGameId": 10070978 -> Can we use that bad boy to zip together odds?


    }

    public void findGamesUsages(Profile[] profiles, Game[] gameList){
        //find games that are used in bets
        //check if games have resolved
        //if they have, settle the bets
    }

        //sends message to kafka producer
}
