package org.example.mevo.repository;

import org.example.mevo.entites.StationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationStatusRepository extends JpaRepository<StationStatus, Integer> {

}
