package org.example.mevo.entites;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coordinateId;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private StationInformation station;

    private double lat;

    private double lon;
}
