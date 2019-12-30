package com.SamHCoco.aircraft.api.service;

import com.SamHCoco.aircraft.api.model.Aircraft;
import com.SamHCoco.aircraft.api.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    /**
     * Returns all aircrafts in the database.
     * @return All aircraft in the database.
     */
    public List<Aircraft> getAllAircrafts(){
        List<Aircraft> aircrafts = new ArrayList<>();
        aircraftRepository.findAll().forEach(aircrafts::add);
        return aircrafts;
    }

    /**
     * Returns the aircraft in the database with the specified ID.
     * @param id The ID of the aircraft.
     * @return An optional containing the aircraft, if it exists in the database.
     */
    public Optional<Aircraft> getAircraftByID(int id){
        return aircraftRepository.findById(id);
    }

    /**
     * Returns all aircraft in the specified sector (i.e. commercial, military, or private)
     * @param sector The sector the aircrafts are used in.
     * @return All aircraft which operate in the specified sector.
     */
    public Optional<List<Aircraft>> getAllAircraftBySector(String sector){
        return aircraftRepository.findBySector(sector);
    }

    /**
     * Returns all aircrafts of a particular make.
     * @param make The make of the aircraft.
     * @return All aircraft of the specified make.
     */
    public Optional<List<Aircraft>> getAllAircraftByMake(String make){
        return aircraftRepository.findByMake(make);
    }

    /**
     * Adds new aircrafts to the database.
     * @param newAircrafts The aircrafts to be added to the database.
     * @return True if the aircrafts were successfully added, false otherwise.
     */
    public boolean addAircrafts(List<Aircraft> newAircrafts){
        aircraftRepository.saveAll(newAircrafts);
        if(getAllAircrafts().containsAll(newAircrafts)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates a single aircraft in the database.
     * @param id The ID of the aircraft to be updated.
     * @param aircraft The aircraft containing updated values.
     * @return True if the update was successful, false otherwise.
     */
    public boolean updateAircraft(int id, Aircraft aircraft){
        if(aircraftRepository.findById(id).isPresent()){
            aircraft.setId(id);
            aircraftRepository.save(aircraft);
            if(aircraftRepository.findById(id).get().equals(aircraft)){
                return true;
            } else{
                return false;
            }
        }
        return false;
    }

    /**
     * Deletes an aircraft from the database.
     * @param id The ID of the aircraft to be deleted.
     * @return True if aircraft successfully deleted, false otherwise.
     */
    public boolean deleteAircraft(int id){
        if(aircraftRepository.findById(id).isPresent()){
            aircraftRepository.deleteById(id);
            if(!aircraftRepository.existsById(id)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
