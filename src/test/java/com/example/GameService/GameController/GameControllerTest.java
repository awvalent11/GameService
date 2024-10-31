package com.example.GameService.GameController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GameController gameController;

    @Autowired
    private ObjectMapper objectMapper;

    public static boolean isInClosedRange(Integer number) {
        return (14 <= number && number <= 16);
    }

    public static boolean isInClosedNFL(String nflName) {
        switch (nflName){

            case "KC":
                return true;
            case "DEN":
                return true;
            case "NO":
                return true;
            case "WAS":
                return true;
            case "PHI":
                return true;
            case "PIT":
                return true;
            case "NYJ":
                return true;
            case "NYG":
                return true;
            case "SEA":
                return true;
            case "LV":
                return true;
            case "DAL":
                return true;
            case "ATL":
                return true;
            case "LAR":
                return true;
            case "LAC":
                return true;
            case "GB":
                return true;
            case "DET":
                return true;
            case "MIN":
                return true;
            case "TB":
                return true;
            case "JAX":
                return true;
            case "ARI":
                return true;
            case "CHI":
                return true;
            case "BAL":
                return true;
            case "BUF":
                return true;
            case "MIA":
                return true;
            case "CAR":
                return true;
            case "CIN":
                return true;
            case "CLE":
                return true;
            case "IND":
                return true;
            case "TEN":
                return true;
            case "NE":
                return true;
            case "HOU":
                return true;
            default:
                return false;
        }
    }

    @Test
    public void getNFLWeek(){
        long daysDifference = ChronoUnit.DAYS.between(LocalDate.of(2024, 8, 27), LocalDate.now());

        int expectedDays = (int) daysDifference;
        Integer expectedWeeks = expectedDays / 7;
        Integer intToTest = gameController.getNFLWeek();
        assertNotNull(intToTest);
        assertEquals(expectedWeeks, intToTest);
    }

    @Test
    void getNFLSchedule() throws Exception {

        MvcResult result;
        result = mockMvc.perform(MockMvcRequestBuilders.
                        get("/gambling-api/nfl-schedule")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        List resultList = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);

        assertEquals(15, resultList.size());

    }

    @Test
    void getNFLTodayGames() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/gambling-api/nfl-week-games"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].size()").value(6))
                .andExpect(jsonPath("$[3]").hasJsonPath()).andReturn();

        List resultList = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
        assertTrue(isInClosedRange(resultList.size()));



    }



}