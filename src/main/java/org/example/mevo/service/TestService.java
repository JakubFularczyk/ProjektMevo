package org.example.mevo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.mevo.dtos.Station;
import org.example.mevo.dtos.StationInformationDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private static final String STATION_INFORMATION_URL = "https://gbfs.urbansharing.com/rowermevo.pl/station_information.json";

    private final RestTemplate restTemplate =  new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();


    public StationInformationDTO getDataFromAPI() {

        return restTemplate.getForObject(STATION_INFORMATION_URL, StationInformationDTO.class);
    }

    public StationInformationDTO getDataFromAPIWithMapper() {

        String json = restTemplate.getForObject(STATION_INFORMATION_URL, String.class);
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode stationsNode = jsonNode.path("data").path("stations");

            List<Station> stations = new ArrayList<>();
            for(JsonNode stationNode : stationsNode) {
                Station s = objectMapper.treeToValue(stationNode, Station.class);
                stations.add(s);
            }
            StationInformationDTO stationInformationDTO = new StationInformationDTO();
            stationInformationDTO.setStations(stations);
            return stationInformationDTO;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
