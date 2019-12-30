package com.SamHCoco.aircraft.api.controller;

import com.SamHCoco.aircraft.api.model.Aircraft;
import com.SamHCoco.aircraft.api.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/aircrafts")
public class AircraftAPIController {

    @Autowired
    private AircraftService aircraftService;

    /**
     * Returns all aircrafts in the database. Maps a client's GET request to the
     * 'api/aircraft' end-point to the method in AircraftService for returning all
     * aircrafts in the database.
     * @return All aircrafts in database, and HTTP status 200.
     */
    @GetMapping("")
    public ResponseEntity<List<Aircraft>> getAllAircrafts(){
        List<Aircraft> allAircrafts = aircraftService.getAllAircrafts();
        return new ResponseEntity<>(allAircrafts, HttpStatus.OK);
    }

    /**
     * Returns all aircrafts in the database filtered by the specified sector they operate in.
     * Maps a client's GET request to the 'api/aircrafts/{sector}' end-point to
     * the method in AircraftService for returning aircrafts filtered by sector.
     * @param sector The sector the aircraft operates in: commercial, military or private.
     * @return All aircraft in the database which operate in the specified sector and a HTTP status 200,
     * or HTTP status 404 if none could be found.
     */
    @GetMapping("/{sector}")
    public ResponseEntity<List<Aircraft>> getAllAircraftsBySector(@PathVariable String sector){
        Optional<List<Aircraft>> aircrafts = aircraftService.getAllAircraftBySector(sector);
        if(aircrafts.isPresent()){
            return new ResponseEntity<>(aircrafts.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Adds aircraft(s) to the database. Maps the client's POST request to the 'api/aircrafts'
     * end-point to the method in AircraftService for adding new aircrafts to the database.
     * @param aircrafts The aircraft(s) to be added to the database.
     * @return HTTP status 201 if the aircraft(s) were/was successfully added, or
     * HTTP status 400 otherwise.
     */
    @PostMapping("")
    public ResponseEntity addAircrafts(@RequestBody List<Aircraft> aircrafts){
        boolean added = aircraftService.addAircrafts(aircrafts);
        if(added){
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Updates a single aircraft in the database. Maps the client's PUT request to the'api/aircrafts/{id}'
     * end-point to the method in AircraftService for updating a single aircraft in the database.
     * @param id The ID of the aircraft to be updated.
     * @param aircraft The aircraft containing all the update values.
     * @return HTTP status 200 if the aircraft was successfully updated, or
     * HTTP status 404 if the aircraft to update could not be found in the database.
     */
    @PutMapping("/{id}")
    public ResponseEntity updateAircraft(@PathVariable int id, @RequestBody Aircraft aircraft){
        boolean updated = aircraftService.updateAircraft(id, aircraft);
        if(updated){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes a single aircraft from the database. This method maps the client's DELETE request to the
     * 'api/aircraft' end-point to the method in AircraftService for deleting a single aircraft
     * from the database.
     * @param id The ID of the aircraft to be deleted from the database.
     * @return HTTP status 200 if the aircraft was successfully deleted, or
     * HTTP status 404 if the aircraft to be deleted could not be found in the database.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAircraft(@PathVariable int id){
        boolean deleted = aircraftService.deleteAircraft(id);
        if(deleted){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
