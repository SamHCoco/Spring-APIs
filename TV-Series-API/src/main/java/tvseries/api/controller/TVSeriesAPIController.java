package tvseries.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tvseries.api.TVSeries;
import tvseries.api.TVSeriesService;

import java.util.List;

@RestController
public class TVSeriesAPIController {

    @Autowired
    TVSeriesService tvSeriesService;

    @GetMapping("/tv-series")
    public List<TVSeries> getAllTVSeries(){
        return tvSeriesService.getAllTVSeries();
    }

    // todo - Add HTTP 404 Response if TV Series resource not found
    @GetMapping("/tv-series/{id}")
    public TVSeries getTVSeries(@PathVariable int id){
        return tvSeriesService.getTVSeries(id);
    }

    @PostMapping("/tv-series")
    public void addTVSeries(@RequestBody TVSeries tvSeries){
        tvSeriesService.addTVSeries(tvSeries);
    }

}
