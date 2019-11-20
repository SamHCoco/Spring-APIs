package tvseries.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TVSeriesAPIController {

    @RequestMapping("/tv-series")
    public String displayTVSeries(){
        return "TEST RESPONSE: Here are your TV series";
    }

}
