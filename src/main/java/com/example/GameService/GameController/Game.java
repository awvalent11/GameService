package com.example.GameService.GameController;


//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
public class Game {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String home;
    private String away;
    private Double odds;
    private LocalDate startTime;
    private Double moneyLine;
    private Double payoff;
    private Double position;
    private Boolean status;
    //True means game is over, false means game is not

}
