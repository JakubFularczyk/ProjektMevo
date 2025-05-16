package org.example.mevo.controller;

import org.example.mevo.entites.StationInformation;
import org.example.mevo.entites.StationStatus;
import org.example.mevo.repository.StationInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private StationInformationRepository stationInformationRepository;

    @GetMapping
    public List<StationInformation> getAll() {
        return stationInformationRepository.findAll();
    }

    @PostMapping
    public StationInformation save() {
        // rozwiazanie tymczasowe, obiekt na sztywno
        StationInformation entity = new StationInformation();
        entity.setAddress("testowy adres");
        entity.setName("testowa");
        entity.setLon(12.34);
        entity.setLat(12.34567);
        entity.setCapacity(3);

        StationStatus status = new StationStatus();
        status.setInstalled(true);
        status.setNumBikesAvailable(12);
        status.setLastReported(Timestamp.from(Instant.now()));
        status.setStation(entity);

        entity.setStatus(status);

        return stationInformationRepository.save(entity);
    }

    @Autowired
    public void setStationInformationRepository(StationInformationRepository stationInformationRepository) {
        this.stationInformationRepository = stationInformationRepository;
    }
}
