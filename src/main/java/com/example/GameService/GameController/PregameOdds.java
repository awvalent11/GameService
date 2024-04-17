package com.example.GameService.GameController;

import lombok.*;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PregameOdds {

        private Double gameOddId;
        private String sportsbook;
        private Double gameId;
        private String created;
        private String updated;
        private Double homeMoneyLine;
        private Double awayMoneyLine;
        private Double homePointSpread;
        private Double awayPointSpread;
        private Double homePointSpreadPayout;
        private Double awayPointSpreadPayout;
        private Double overUnder;
        private Double overPayout;
        private Double underPayout;
        private Double sportsbookId;
        private String sportsbookUrl;
        private String oddType;

}
