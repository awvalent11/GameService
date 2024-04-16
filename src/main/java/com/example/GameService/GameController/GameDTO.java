package com.example.GameService.GameController;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GameDTO {

    private String home;
    private String away;
    private Double odds;
    private LocalDate expiration;
    private LocalDate dateTime; //start time
    private Double moneyLine;
    private Double payoff;
    private Double position;
    private String status;
    private String awayTeamName;
    private String homeTeamName;
    private List<Object> pregameOdds;


    private String getSportsBook(String url) {
//        Pattern pattern = Pattern.compile(url, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(url);
//        switch(){
//
//
//        }
//        Matcher draftkings = pattern.matcher("Visit W3Schools!");
//        Matcher fanduel
//                playsugarhouse
//                betrivers
//                caesars
//                betmgm
         return "Howdy :)";
    }
}
