package org.example.mevo.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
public class HistoryStationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID historyStationStatusId;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private StationInformation station;

    private boolean isInstalled;

    private boolean isRenting;

    private boolean isReturning;

    private Timestamp lastReported;

    private Integer numBikesAvailable;

    private Integer numEbikesAvailable;

    private Integer numDocksAvailable;
}
