package com.example.GameService.GameController;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class NFLService {

    private final GameController gameController;
//
//    public static List<Game> todaysGames = new ArrayList<>();
//
//    Logger logger;
//
    public NFLService(GameController gameController) {
        this.gameController = gameController;
    }

    public List<Object> checkGamesInProgress(){
        return this.gameController.getNFLGameProgress();
    }
//
//    private static void assignGames(List<Game> games){
//        //Should return a List<Game>
//        todaysGames.addAll(games);
//    }
//
//
//    public Game convertGame(GameDTO game){
//        Game returnedGame = new Game();
//
//        for(LinkedHashMap odds: game.getPregameOdds()){
//            try {
//                returnedGame.setHome(game.getHomeTeamName());
//                returnedGame.setAway(game.getAwayTeamName());
//                Boolean gameStatus = parseStatus(game.getStatus());
//                returnedGame.setStatus(gameStatus);
//                Odds pregameOdds = new Odds( (Double) odds.get("HomePointSpread"),
//                        (Double) odds.get("OverUnder"),
//                        (Integer) odds.get("HomeMoneyLine"),
//                        (Integer) odds.get("AwayMoneyLine"),
//                        (String) odds.get("SportsbookUrl"));
//                if(pregameOdds.getSportsbookUrl()!= null){
//                    returnedGame.getOdds().add(pregameOdds);
//                }
//            }catch (Error err){
//                logger.info(err.toString());
//            }
//        }
//
//
//        return returnedGame;
//    }
//
//    private Boolean parseStatus(String aPistatus) {
//        return aPistatus.equals("Final");
//    }
//
//    private List<GameDTO> parseGame(ArrayList<LinkedHashMap> games) throws NullPointerException {
//        List<GameDTO> gameList = new ArrayList<>();
//        for(LinkedHashMap game : games) {
//            try {
//                System.out.println(String.format("I am a game! %s", game));
//                GameDTO gameDTO = GameDTO.builder().build();
//                gameDTO.setGameId((Integer) game.get("GameId"));
//                gameDTO.setAwayTeamName((String) game.get("AwayTeamName"));
//                gameDTO.setHomeTeamName((String) game.get("HomeTeamName"));
//                gameDTO.setStatus((String) game.get("Status"));
//                gameDTO.setPregameOdds((List<LinkedHashMap>) game.get("PregameOdds"));
//                gameList.add(gameDTO);
//
//
//            }catch (Error err){
//                logger.info(err.toString());
//            }
//        }
//        return gameList;
//    }
//


//    public void findGamesUsages(Profile[] profiles, Game[] gameList){
        //find games that are used in bets
        //check if games have resolved
        //if they have, settle the bets
//    }

    //sends message to kafka producer
}