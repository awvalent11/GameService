package com.example.GameService.GameController;


//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class Game {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String home;
    private String away;
    private List<Odds> odds;
   // private LocalDate startTime;
   // private Double payoff;
   // private Double position;
    private Boolean status;
    // Scheduled, InProgress,
    //True means game is over, false means game is not
    public Game(){
        this.odds = new ArrayList<>();
    }

}
