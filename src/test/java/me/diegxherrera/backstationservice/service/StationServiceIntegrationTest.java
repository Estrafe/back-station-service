package me.diegxherrera.backstationservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.diegxherrera.backstationservice.dto.request.CreateStationRequest;
import me.diegxherrera.backstationservice.dto.request.UpdateStationRequest;
import me.diegxherrera.backstationservice.model.StationEntity;
import me.diegxherrera.backstationservice.repository.StationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StationServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StationRepository stationRepository;

    private UUID stationId;

    @BeforeEach
    public void setUp() {
        // Create a mock city object or use a real one if necessary
        UUID cityId = UUID.randomUUID();  // Replace with actual City ID if needed

        // Create and save the station
        StationEntity station = new StationEntity();
        station.setStationName("Main Station");
        station.setCityId(cityId);  // Set a valid city ID
        station.setInternational(true);
        station = stationRepository.save(station);
        stationId = station.getId();
    }

    @Test
    public void testCreateStation() throws Exception {
        CreateStationRequest request = CreateStationRequest.builder()
                .stationName("New Station")
                .cityId(UUID.randomUUID())
                .international(false)
                .build();

        mockMvc.perform(post("/stations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.stationName", is("New Station")));
    }

    @Test
    public void testGetStationById() throws Exception {
        mockMvc.perform(get("/stations/{id}", stationId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stationName", is("Main Station")));
    }

    @Test
    public void testUpdateStation() throws Exception {
        UpdateStationRequest updateRequest = UpdateStationRequest.builder()
                .stationName("Updated Station")
                .build();

        mockMvc.perform(put("/stations/{id}", stationId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stationName", is("Updated Station")));
    }

    @Test
    public void testDeleteStation() throws Exception {
        mockMvc.perform(delete("/stations/{id}", stationId))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/stations/{id}", stationId))
                .andExpect(status().isNotFound());
    }
}