package com.example.GameService.GameController;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Mock
    private GameController gameController;

    @Test
    void testsGameFilter(){
        GameDTO gameDTO = GameDTO.builder()
                .away("HOU")
                .home("PHI")
                .odds(-100.00)
                .position(200.00)
              //  .gameStartTime(LocalDate.parse("2022-01-01Z1000"))
                .build();

        Game expectedGame = Game.builder()
                .away("HOU")
                .home("PHI")
                .odds(-100.00)
                .position(200.00)
             //   .expiration(LocalDate.parse("2022-01-01Z1000"))
                .build();
        Game actualGame = gameService.filterGame(gameDTO);

        assertEquals(expectedGame.getAway(), actualGame.getAway());
        assertEquals(expectedGame.getHome(), actualGame.getHome());
        assertEquals(expectedGame.getOdds(), actualGame.getOdds());
        assertNull(actualGame.getPosition());
        //assertEquals(expectedGame.getExpiration(), actualGame.getExpiration());
    }
}