package org.example.mevo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Data
public class StationStatus {

    @Id
    private Integer stationId;

    @OneToOne
    @JoinColumn(name = "station_id")
    @JsonIgnore
    @ToString.Exclude
    @MapsId
    private StationInformation station;

    @Column(name="is_installed")
    private boolean isInstalled;

    @Column(name="is_renting")
    private boolean isRenting;

    @Column(name="is_returning")
    private boolean isReturning;

    @Column(name="last_reported")
    private Timestamp lastReported;

    @Column(name="num_bikes_available")
    private Integer numBikesAvailable;

    @Column(name="num_ebikes_available")
    private Integer numEbikesAvailable;

    @Column(name="num_docks_available")
    private Integer numDocksAvailable;
}
