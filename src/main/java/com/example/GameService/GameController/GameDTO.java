package com.example.GameService.GameController;

import lombok.*;

import java.time.LocalDate;

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
    private LocalDate gameStartTime;
    private Double moneyLine;
    private Double payoff;
    private Double position;
    private Boolean status;
}
