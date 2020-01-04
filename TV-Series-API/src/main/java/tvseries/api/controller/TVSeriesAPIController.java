package tvseries.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tvseries.api.model.TVSeries;
import tvseries.api.service.TVSeriesService;

import java.util.List;

@RestController
public class TVSeriesAPIController {

    @Autowired
    private TVSeriesService tvSeriesService;

    /**
     * Handles GET requests for all TV series in the database, or all TV series
     * filtered by optional "genre" or release "year" query parameters.
     * @param genre The desired genre of TV series.
     * @param year The desired release year for TV series.
     * @return HTTP status code 200 and response body containing queried
     * TV series if resource found, or HTTP code 404 response if not.
     */
    @GetMapping("api/tv-series")
    public ResponseEntity<List<TVSeries>> getAllTVSeries(@RequestParam(required = false) String genre,
                                                         @RequestParam(required = false) Integer year){
        List<TVSeries> tvSeries = tvSeriesService.getAllTVSeries(genre, year);
        if(tvSeries.size() > 0){
            return new ResponseEntity<>(tvSeries, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Handles GET request for single TV series resource, whose ID is specified by
     * path variable provided.
     * @param id The ID of the TV show resource
     * @return JSON response containing requested TV show along with HTTP status
     * code 200 if the TV series was found, or just an HTTP 404 if it was not.
     */
    @GetMapping("api/tv-series/{id}")
    public ResponseEntity<TVSeries> getTVSeries(@PathVariable int id){
        TVSeries tvShow = tvSeriesService.getTVSeries(id);
        if(tvShow != null){
            return new ResponseEntity<>(tvShow, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Handles PUT requests to add a single new TV series to the TV Series database.
     * @param tvSeries The TV Series to be added defined in JSON format, specified by
     * id, title, genre, description and year.
     * @return HTTP status code 201 if TV show successfully added to database,
     * or status code 400 otherwise.
     */
    @PostMapping("api/tv-series")
    public ResponseEntity addTVSeries(@RequestBody TVSeries tvSeries){
        boolean created = tvSeriesService.addTVSeries(tvSeries);
        if(created){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    /**
     * Handles a PUT request to update a single new TV series in the database.
     * @param id The ID of the TV Series in the database to be updated.
     * @param tvSeries The TVSeries object containing the update values.
     * @return HTTP status 200 if the TV Series was successfully updated, or
     * HTTP status 404 if the TV series was not found.
     */
    public ResponseEntity updateTVSeries(@PathVariable int id, @RequestBody TVSeries tvSeries){
        boolean updated = tvSeriesService.updateTVSeries(id, tvSeries);
        if(updated){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    /**
     * Handles DELETE request for a single TV series in database.
     * @param id The ID of the TV series to be deleted from database.
     * @return HTTP status code 200 if the TV show was successfully deleted,
     * status code 404 if the TV series could not be found in the database and deleted.
     */
    @DeleteMapping("api/tv-series/{id}")
    public ResponseEntity deleteTVSeries(@PathVariable int id){
        boolean deleted = tvSeriesService.deleteTVSeries(id);
        if(deleted){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
