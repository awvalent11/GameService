package com.example.GameService.GameController;


import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
@NoArgsConstructor
@RequestMapping("/")
public class GameController {
    String nflAPI = "https://api.sportsdata.io/v3/nfl/odds/json/GameOddsByWeek/2022REG9?key=a1c6821b242546c180c07e0d1e508670";
    String nflOdds = "https://api.sportsdata.io/v3/nfl/odds/json/BettingEventsByDate/2023-11-26?key=a1c6821b242546c180c07e0d1e508670";
    String NFLLIVEODDS = "https://api.sportsdata.io/v3/nfl/odds/json/LiveGameOddsByWeek/2024/1?key=a1c6821b242546c180c07e0d1e508670";
//    "Returns in-play game odds (spread, moneyline, total) for games in a given " +
//            "week and season. Only returns the most recently seen odds, not " +
//            "inclusive of line movement. As this is in-game, it will only return " +
//            "results while the game is in progress."


    String NFLGAMESINPROGRESS = "https://api.sportsdata.io/v3/nfl/scores/json/AreAnyGamesInProgress?key=a1c6821b242546c180c07e0d1e508670";
    String NFLODDSWEEKLY = "https://api.sportsdata.io/v3/nfl/odds/json/GameOddsByWeek/2024/%s?key=a1c6821b242546c180c07e0d1e508670";

    String MLBSCHEDULE = "https://api.sportsdata.io/v3/mlb/odds/json/GameOddsByDate/2024-04-16?key=a8798167747e4ea49679b2b92c522c6c";
    String MLBSCHEDULEUSEABLE = String.format("https://api.sportsdata.io/v3/mlb/odds/json/GameOddsByDate/%s?key=a8798167747e4ea49679b2b92c522c6c", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));


    public Integer getNFLWeek(){
        LocalDate specificDate = LocalDate.of(2024, 8, 28);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the difference in days
        long daysDifference = ChronoUnit.DAYS.between(specificDate, currentDate);

        // Calculate the number of weeks
        long weeksPassed = daysDifference / 7;
        return (int) weeksPassed;
    }
    @GetMapping("gambling-api/mlb-schedule")
    public ArrayList<LinkedHashMap> getMLBSchedule(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList> responseEntity = restTemplate.getForEntity(MLBSCHEDULEUSEABLE, ArrayList.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @CrossOrigin
    @GetMapping("gambling-api/nfl-schedule")
    public ArrayList<LinkedHashMap> getNFLSchedule(){
        RestTemplate restTemplate = new RestTemplate();
        Integer week = getNFLWeek();
        ResponseEntity<ArrayList> responseEntity = restTemplate.getForEntity(String.format(NFLODDSWEEKLY, week), ArrayList.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @CrossOrigin
    @GetMapping("gambling-api/mlb-today-games")
    public List<Game> getMLBTodayGames(){
        return GameService.todaysGames;
    }

    @CrossOrigin
    @GetMapping("gambling-api/nfl-week-games")
    public List<Game> getNFLTodayGames(){
        return GameService.weeksNFLGames;
    }


    // Will only return True if there are actively games in progress
    //Useful for kicking off live odds
    @CrossOrigin
    @GetMapping("gambling-api/nfl-games-progress")
    public Boolean getNFLGameProgress(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(NFLGAMESINPROGRESS, Boolean.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @CrossOrigin
    @GetMapping("gambling-api/nfl-live-odds")
    public Object getNFLLiveOdds(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(NFLLIVEODDS, Object.class);
        return Objects.requireNonNull(responseEntity.getBody());
    }

    @GetMapping("health")
    public String health(){
        return "Healthy :)";
    }
}
