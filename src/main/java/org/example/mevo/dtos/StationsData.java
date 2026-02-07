package org.example.mevo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StationsData {

    @JsonProperty("stations")
    public Station[] stations;
}
