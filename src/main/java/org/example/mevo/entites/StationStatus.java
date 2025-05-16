package org.example.mevo.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class StationStatus {

    // TODO prawdopodobnie @MapsId
    @Id
    @OneToOne
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
