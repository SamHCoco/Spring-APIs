package tvseries.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tvseries.api.TVSeries;
import tvseries.api.TVSeriesService;

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
     * @return ResponseEntity with HTTP status code 200 and response body containing queried
     * TV series if resource found, or HTTP code 404 response if not.
     */
    @GetMapping("/tv-series")
    public ResponseEntity<List<TVSeries>> getAllTVSeries(@RequestParam(required = false) String genre,
                                                         @RequestParam(required = false) Integer year){
        List<TVSeries> tvSeries = tvSeriesService.getAllTVSeries(genre, year);
        if(tvSeries.size() > 0){
            return new ResponseEntity<>(tvSeries, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tv-series/{id}")
    public ResponseEntity<TVSeries> getTVSeries(@PathVariable int id){
        TVSeries tvShow = tvSeriesService.getTVSeries(id);
        if(tvShow != null){
            return new ResponseEntity<>(tvShow, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tv-series")
    public ResponseEntity addTVSeries(@RequestBody TVSeries tvSeries){
        tvSeriesService.addTVSeries(tvSeries);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/tv-series/{id}")
    public ResponseEntity deleteTVSeries(@PathVariable int id){
        boolean isDeleteSuccessful;
        isDeleteSuccessful = tvSeriesService.deleteTVSeries(id);
        if(isDeleteSuccessful){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
