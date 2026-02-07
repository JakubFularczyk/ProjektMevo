package org.example.mevo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {

    @JsonProperty("station_id")
    private Integer stationId;

    @JsonProperty("name")
    private String name;
}
