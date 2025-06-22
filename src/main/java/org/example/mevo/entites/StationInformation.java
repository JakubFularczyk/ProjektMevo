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
    @Column(name = "station_id")
    private Integer stationId;

    private Integer mevoStationId;

    private String name;

    private String address;

    private double lat;

    private double lon;

    private int capacity;

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
    private List<Coordinate> coordinates;

    @OneToOne(mappedBy = "station", cascade = CascadeType.ALL)
    private StationStatus status;

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
    private List<HistoryStationInformation> history;
}
