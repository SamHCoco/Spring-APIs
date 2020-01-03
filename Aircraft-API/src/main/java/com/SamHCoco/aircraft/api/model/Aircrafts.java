package com.SamHCoco.aircraft.api.model;

import java.util.List;

/**
 * Object wrapper for aircraft lists request body response.
 */
public class Aircrafts {

    private List<Aircraft> aircrafts;

    public Aircrafts(List<Aircraft> aircrafts){
        this.aircrafts = aircrafts;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }
}
