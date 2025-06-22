package org.example.mevo.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class HistoryStationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID historyStationInformationId;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private StationInformation station;

    private String address;

    private double lat;

    private double lon;

    private boolean isVirtualStation;

    private int capacity;
}
