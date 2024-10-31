package com.example.GameService.GameController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GameDTO {

//    private String home;
//    private String away;
//    private Double odds;
//    private LocalDate expiration;
//    private LocalDate dateTime; //start time
//    private Double moneyLine;
//    private Double payoff;
//    private Double position;
//    private String status;
//    private String awayTeamName;
//    private String homeTeamName;
//    private List<Object> pregameOdds;


    private Integer gameId;
    private String season;
    private String seasonType;
    private String day;
    private String dateTime;
    private String status;
    private String awayTeamId;
    private String homeTeamId;
    private String awayTeamName;
    private String homeTeamName;
    private String globalGameId;
    private String globalAwayTeamId;
    private String globalHomeTeamId;
    private String homeTeamScore;
    private String awayTeamScore;
    private String totalScore;
    private String homeRotationNumber;
    private String AwayRotationNumber;
    private List<LinkedHashMap> pregameOdds;

}
