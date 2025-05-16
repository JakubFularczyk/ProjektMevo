package org.example.mevo.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
//@Table(name = "station_information")
public class StationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stationId;

    private String name;

    private String address;

    private double lat;

    private double lon;

    private int capacity;

    @OneToMany(mappedBy = "station")
    private List<Coordinate> coordinates;

    @OneToOne(mappedBy = "station")
    private StationStatus status;
}
