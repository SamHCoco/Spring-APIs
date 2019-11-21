package tvseries.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
