package org.example.mevo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Data
public class StationStatus {

    @Id
    @OneToOne
    @JoinColumn(name = "station_id")
    @JsonIgnore
    @ToString.Exclude
    private StationInformation station;

    private boolean isInstalled;

    private boolean isRenting;

    private boolean isReturning;

    private Timestamp lastReported;

    private Integer numBikesAvailable;

    private Integer numEbikesAvailable;

    private Integer numDocksAvailable;
}
