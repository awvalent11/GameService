package com.example.GameService.GameController;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Mock
    private GameController gameController;

    @Test
    @Transactional
    void testconvertGames(GameDTO gameDTO){

//        LinkedHashMap odds = new LinkedHashMap();
//        odds.put("Odds", );
//
//        List<LinkedHashMap> pregameOdds = new ArrayList<>();
//        pregameOdds.add()
//
//        GameDTO gameDTO = GameDTO.builder()
//                .gameId(1)
//                .status("Scheduled")
//                .homeTeamName("HOU")
//                .awayTeamName("PHI")
//                .pregameOdds()
//                .build();
//




    }

    @Test
    void testsGameFilter(){
//        GameDTO gameDTO = GameDTO.builder()
//                .away("HOU")
//                .home("PHI")
//                .odds(-100.00)
//                .position(200.00)
//              //  .gameStartTime(LocalDate.parse("2022-01-01Z1000"))
//                .build();
//
//        Game expectedGame = Game.builder()
//                .away("HOU")
//                .home("PHI")
//                .odds(-100.00)
//                .position(200.00)
//             //   .expiration(LocalDate.parse("2022-01-01Z1000"))
//                .build();
//        Game actualGame = gameService.convertGame(gameDTO);
//
//        assertEquals(expectedGame.getAway(), actualGame.getAway());
//        assertEquals(expectedGame.getHome(), actualGame.getHome());
//        assertEquals(expectedGame.getOdds(), actualGame.getOdds());
//        assertNull(actualGame.getPosition());
        //assertEquals(expectedGame.getExpiration(), actualGame.getExpiration());
    }
}