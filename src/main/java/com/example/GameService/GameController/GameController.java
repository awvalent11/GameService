package com.example.GameService.GameController;


import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@NoArgsConstructor
@RequestMapping("/gambling-api")
public class GameController {
    String nflAPI = "https://api.sportsdata.io/v3/nfl/odds/json/GameOddsByWeek/2022REG9?key=a1c6821b242546c180c07e0d1e508670";
    String nflOdds = "https://api.sportsdata.io/v3/nfl/odds/json/BettingEventsByDate/2023-11-26?key=a1c6821b242546c180c07e0d1e508670";
    //

    String MLBSCHEDULE = "https://api.sportsdata.io/v3/mlb/odds/json/GameOddsByDate/2024-04-16?key=a8798167747e4ea49679b2b92c522c6c";
    String MLBSCHEDULEUSEABLE = String.format("https://api.sportsdata.io/v3/mlb/odds/json/GameOddsByDate/%s?key=a8798167747e4ea49679b2b92c522c6c", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));



    @GetMapping("/all-bets")
    public Game[] getAllBets(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Game[]> responseEntity = restTemplate.getForEntity(nflAPI, Game[].class);
        return responseEntity.getBody();
    }

    @GetMapping("/odds")
    public List<GameDTO> getOdds(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GameDTO[]> responseEntity = restTemplate.getForEntity(nflOdds, GameDTO[].class);
        return List.of(Objects.requireNonNull(responseEntity.getBody()));
    }

    @GetMapping("/mlb-schedule")
    public Object getMLBSchedule(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(MLBSCHEDULEUSEABLE, Object.class);
        return List.of(Objects.requireNonNull(responseEntity.getBody()));
    }



    @GetMapping("/hey")
    public String hey(){
        return "Hey :)";
    }
}
