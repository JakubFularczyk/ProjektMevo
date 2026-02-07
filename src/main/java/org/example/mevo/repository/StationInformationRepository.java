package org.example.mevo.repository;

import org.example.mevo.entites.StationInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StationInformationRepository extends JpaRepository<StationInformation, Integer> {

    @Query("select s from StationInformation s where s.address = ?1")
    StationInformation findByAddress(String address);

    @Query(value = "select * from station_information s where s.name = ?1 and s.address = ?2", nativeQuery = true)
    StationInformation findByNameAndAddress(String name, String address);

    Optional<StationInformation> findByMevoStationId(Integer mevoStationId);
}
