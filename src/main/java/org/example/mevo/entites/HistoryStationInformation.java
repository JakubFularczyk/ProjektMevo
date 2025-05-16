package org.example.mevo.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HistoryStationInformation {

    @Id
    private Integer HistorystationId;

    private Integer stationID; //TODO KLUCZ

    private String address;

    private double lat;

    private double lon;

    private boolean isVirtualStation;

    private int capacity;
}
