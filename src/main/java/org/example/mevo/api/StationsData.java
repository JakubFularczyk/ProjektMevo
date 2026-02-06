package org.example.mevo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StationsData {

    @JsonProperty("stations")
    public Station[] stations;
}
