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

//    @Autowired
//    private GameService gameService;
//
//    @Mock
//    private GameController gameController;
//
//
//    GameDTO gameDTO = new GameDTO(
//        "ScoreId": 18776,
//            "Season": 2024,
//            "SeasonType": 1,
//            "Week": 8,
//            "Day": "2024-10-28T00:00:00",
//            "DateTime": "2024-10-28T20:15:00",
//            "Status": "Scheduled",
//            "AwayTeamId": 23,
//            "HomeTeamId": 28,
//            "AwayTeamName": "NYG",
//            "HomeTeamName": "PIT",
//            "GlobalGameId": 18776,
//            "GlobalAwayTeamId": 23,
//            "GlobalHomeTeamId": 28,
//            "HomeTeamScore": null,
//            "AwayTeamScore": null,
//            "TotalScore": 0,
//            "HomeRotationNumber": 417,
//            "AwayRotationNumber": 416,
//            "GameId": 18776,
//            "PregameOdds": [
//        {
//            "GameOddId": 5563687,
//                "Sportsbook": "Scrambled",
//                "ScoreId": 18776,
//                "Created": "2024-10-28T14:07:09",
//                "Updated": "2024-10-28T15:54:55",
//                "HomeMoneyLine": -386,
//                "AwayMoneyLine": 314,
//                "DrawMoneyLine": null,
//                "HomePointSpread": -8.6,
//                "AwayPointSpread": 12.3,
//                "HomePointSpreadPayout": -160,
//                "AwayPointSpreadPayout": -154,
//                "OverUnder": 52.2,
//                "OverPayout": -154,
//                "UnderPayout": -160,
//                "SportsbookId": 7,
//                "OddType": "pregame",
//                "SportsbookUrl": "https://sportsbook.draftkings.com/event/30568623",
//                "GameId": 18776,
//                "Unlisted": null
//        },
//        {
//            "GameOddId": 5564128,
//                "Sportsbook": "Scrambled",
//                "ScoreId": 18776,
//                "Created": "2024-10-28T14:39:14",
//                "Updated": "2024-10-28T15:54:55",
//                "HomeMoneyLine": -393,
//                "AwayMoneyLine": 322,
//                "DrawMoneyLine": null,
//                "HomePointSpread": -8.6,
//                "AwayPointSpread": 12.3,
//                "HomePointSpreadPayout": -157,
//                "AwayPointSpreadPayout": -157,
//                "OverUnder": 52.2,
//                "OverPayout": -160,
//                "UnderPayout": -154,
//                "SportsbookId": 8,
//                "OddType": "pregame",
//                "SportsbookUrl": "https://sportsbook.fanduel.com/football/nfl/new-york-giants-@-pittsburgh-steelers-33691832",
//                "GameId": 18776,
//                "Unlisted": null
//        });
//
//    @Test
//    @Transactional
//    void testconvertGames(GameDTO gameDTO){
//
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
//
//
//
//
//    }
//
//    @Test
//    void testsGameFilter(){
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
//        assertEquals(expectedGame.getExpiration(), actualGame.getExpiration());
//    }
}