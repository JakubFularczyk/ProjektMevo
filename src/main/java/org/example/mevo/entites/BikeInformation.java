package org.example.mevo.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public class BikeInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bikeInformationSequenceGenerator")
    @SequenceGenerator(
            name = "bikeInformationSequenceGenerator",
            sequenceName = "bike_information_id_seq",
            allocationSize = 1
    )
    private Integer bikeId;

    @Column(name = "mevo_bike_id")
    private String mevoBikeId;

    private double lat;

    private double lon;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BikeStatus bikeStatus;

    private boolean isEbike;

    private Timestamp lastReported;

    private Integer currentRangeMeters;

    @OneToMany(mappedBy = "bikeInformation", cascade = CascadeType.ALL)
    private List<HistoryBikeStatus> bikeInformationHistory;

}
