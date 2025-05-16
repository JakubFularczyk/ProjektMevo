package org.example.mevo.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Coordinate {

    @Id
    private Integer coordinateId;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private StationInformation station;

    private double lat;

    private double lon;
}
