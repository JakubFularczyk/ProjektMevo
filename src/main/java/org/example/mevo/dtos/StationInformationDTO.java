package org.example.mevo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class StationInformationDTO {

    @JsonProperty("last_updated")
    private Instant lastUpdated;

    @JsonProperty("data")
    private StationsData data;

    private List<Station> stations;
}
