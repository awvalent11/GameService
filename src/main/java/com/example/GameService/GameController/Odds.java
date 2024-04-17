package com.example.GameService.GameController;


import lombok.*;

@NoArgsConstructor
@Builder
@Getter
@Setter
public class Odds {
    private Double pointsSpread;
    private Double overUnder;
    private Integer moneyLine;
    private String sportsbookUrl;

    public Odds(Double pointsSpread, Double overUnder, Integer moneyLine, String sportsbookUrl) {
        this.pointsSpread = pointsSpread;
        this.overUnder = overUnder;
        this.moneyLine = moneyLine;
        this.sportsbookUrl = sportsbookUrl;
    }
}
