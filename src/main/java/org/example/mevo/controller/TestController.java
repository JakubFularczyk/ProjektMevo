package org.example.mevo.controller;

import org.example.mevo.api.StationInformationDTO;
import org.example.mevo.entites.BikeInformation;
import org.example.mevo.entites.StationInformation;
import org.example.mevo.entites.StationStatus;
import org.example.mevo.repository.BikeInformationRepository;
import org.example.mevo.repository.StationInformationRepository;
import org.example.mevo.service.TestService;
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
    private BikeInformationRepository bikeInformationRepository;
    private TestService testService;

    @GetMapping
    public List<StationInformation> getAll() {
        return stationInformationRepository.findAll();
    }

    @GetMapping("station-information")
    public StationInformationDTO getStationInformation() {
        return testService.getDataFromAPI();
    }

    @GetMapping("station-information-mapper")
    public StationInformationDTO getStationInformationWithMapper() {
        return testService.getDataFromAPIWithMapper();
    }

    @PostMapping
    public StationInformation save() {
        // rozwiazanie tymczasowe, obiekt na sztywno
        StationInformation entity = new StationInformation();
        entity.setMevoStationId(1234);
        entity.setAddress("testowy adres");
        entity.setName("testow");
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

    @PostMapping("/bike")
    public BikeInformation saveBike() {
        BikeInformation bike = new BikeInformation();
        bike.setEbike(true);
        bike.setMevoBikeId("1234");

        return bikeInformationRepository.save(bike);
    }

    @Autowired
    public void setStationInformationRepository(StationInformationRepository stationInformationRepository) {
        this.stationInformationRepository = stationInformationRepository;
    }

    @Autowired
    public void setBikeInformationRepository(BikeInformationRepository bikeInformationRepository) {
        this.bikeInformationRepository = bikeInformationRepository;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
