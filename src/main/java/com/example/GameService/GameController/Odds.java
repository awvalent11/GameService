package com.example.GameService.GameController;


import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Odds {
    private Double pointsSpread;
    private Double overUnder;
    private Integer moneyLine;
    private String sportsbookUrl;

    public Odds(Double pointsSpread,
                Double overUnder,
                Integer moneyLine,
                String sportsbookUrl) {
        this.pointsSpread = pointsSpread;
        this.overUnder = overUnder;
        this.moneyLine = moneyLine;
        this.sportsbookUrl = sportsbookUrl;
        this.sportsBook = getSportsBook(sportsbookUrl);
    }


    private String sportsBook;

    private String getSportsBook(String url) {
        if (sportsbookUrl == null) {
            return "No Sportsbook";
        } else if(url.contains("fanduel")){
            return "Fanduel";
        } else if(url.contains("draftkings")){
            return "Draftkings";
        } else if(url.contains("betrivers")){
            return "Betrivers";
        }else if(url.contains("playsugarhouse")){
            return "Playsugarhouse";
        }else if(url.contains("caesars")){
            return "Caesars";
        }else if(url.contains("betmgm")){
            return "Betmgm";
        } else {
            return "Howdy :)";
        }
    }
}
