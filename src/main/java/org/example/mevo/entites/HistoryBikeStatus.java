package org.example.mevo.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class HistoryBikeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="history_bike_status_id")
    private UUID historyBikeStatusId;

    @ManyToOne
    @JoinColumn(name = "bike_id")
    private BikeInformation bikeInformation;

    private double lat;

    private double lon;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BikeStatus bikeStatus;

    private boolean isEbike;

    private Timestamp changeDatetime;

    private Integer rangeMeters;


}
