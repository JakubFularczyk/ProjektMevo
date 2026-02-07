package org.example.mevo.client;

import org.example.mevo.dtos.gbfs.StationInformationResponse;
import org.example.mevo.dtos.gbfs.StationStatusResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GbfsClient {

    private static final String BASE = "https://gbfs.urbansharing.com/rowermevo.pl/";
    private static final String STATION_INFORMATION_URL = BASE + "station_information.json";
    private static final String STATION_STATUS_URL = BASE + "station_status.json";

    private final RestTemplate restTemplate;

    public GbfsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public StationInformationResponse stationInformation() {
        return restTemplate.getForObject(STATION_INFORMATION_URL, StationInformationResponse.class);
    }

    public StationStatusResponse stationStatus() {
        return restTemplate.getForObject(STATION_STATUS_URL, StationStatusResponse.class);
    }
}
