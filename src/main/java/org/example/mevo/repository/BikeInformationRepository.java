package org.example.mevo.repository;

import org.example.mevo.entites.BikeInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeInformationRepository extends JpaRepository<BikeInformation, Integer> {
}
