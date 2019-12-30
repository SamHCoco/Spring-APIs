package com.SamHCoco.aircraft.api.repository;

import com.SamHCoco.aircraft.api.model.Aircraft;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Integer> {
    Optional<List<Aircraft>> findByMake(String make);
    Optional<Aircraft> findByMakeAndModel(String make, String model);
    Optional<List<Aircraft>> findBySector(String sector);
}
