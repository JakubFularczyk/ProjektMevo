package org.example.mevo.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;
import java.util.List;

@Data
@Entity
public class BikeInformation {

    @Id
    private Integer bikeId;

    private double lat;

    private double lon;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BikeStatus bikeStatus;

    private boolean isEbike;

    private Timestamp lastReported;

    private Integer currentRangeMeters;

    @OneToMany(mappedBy = "bikeInformation")
    private List<HistoryBikeStatus> bikeInformationHistory;

}
