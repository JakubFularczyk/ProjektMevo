package org.example.mevo.dtos.gbfs;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class StationStatusResponse {
    @JsonProperty("last_updated")
    public Long lastUpdated;

    public Data data;

    public static class Data {
        public List<StationStatusItem> stations;
    }

    public static class StationStatusItem {
        @JsonProperty("station_id")
        public String stationId;

        @JsonProperty("is_installed")
        public Boolean isInstalled;

        @JsonProperty("is_renting")
        public Boolean isRenting;

        @JsonProperty("is_returning")
        public Boolean isReturning;

        @JsonProperty("last_reported")
        public Long lastReported;

        @JsonProperty("num_bikes_available")
        public Integer numBikesAvailable;

        @JsonProperty("num_ebikes_available")
        public Integer numEbikesAvailable;

        @JsonProperty("num_docks_available")
        public Integer numDocksAvailable;
    }
}
