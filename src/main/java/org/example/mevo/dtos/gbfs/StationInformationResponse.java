package org.example.mevo.dtos.gbfs;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class StationInformationResponse {
    @JsonProperty("last_updated")
    public Long lastUpdated;

    public Data data;

    public static class Data {
        public List<StationInfo> stations;
    }

    public static class StationInfo {
        @JsonProperty("station_id")
        public String stationId;

        public String name;
        public String address;
        public Double lat;
        public Double lon;
        public Integer capacity;
    }
}
