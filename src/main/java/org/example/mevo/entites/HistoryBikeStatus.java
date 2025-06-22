package org.example.mevo.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class HistoryBikeStatus {

    @Id
    private Integer historyBikeStatusId;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private BikeInformation bikeInformation;

    private double lat;

    private double lot;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BikeStatus bikeStatus;

    private boolean isEbike;

    private Timestamp changeDatetime;

    private Integer rangeMeters;


}
