package com.SamHCoco.aircraft.api.model;

import javax.persistence.*;

@Entity
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String make;
    private String model;
    private String maximumRange; // units in miles
    private String maximumAltitude; //units in ft
    private String fuelCapacity; // units in litres
    private String maximumSpeed; // units in mph
    private String sector; // commercial, military or private

    public Aircraft(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaximumRange() {
        return maximumRange;
    }

    public void setMaximumRange(String maximumRange) {
        this.maximumRange = maximumRange;
    }

    public String getMaximumAltitude() {
        return maximumAltitude;
    }

    public void setMaximumAltitude(String maximumAltitude) {
        this.maximumAltitude = maximumAltitude;
    }

    public String getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(String maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public String getSector() { return sector; }

    public void setSector(String sector) { this.sector = sector; }

    @Override
    public String toString(){
        String rangeUnits = "km";
        String altitudeUnits = "ft";
        String fuelCapacityUnits = "litres";
        String speedUnits = "mph";

        return "ID: " + id + "\n" +
               "make: " + make + "\n" +
               "model: " + model + "\n" +
               "maximum range: " + maximumRange + " " + rangeUnits + "\n" +
               "maximum altitude: " + maximumAltitude + " " + altitudeUnits +  "\n" +
               "fuel capacity: " + fuelCapacity + " " + fuelCapacityUnits + "\n" +
               "maximum speed: " + maximumSpeed + " " + speedUnits + "\n" +
               "sector: " + sector + "\n";
    }

    /**
     * Tests whether the object's field values are all equal to the field values of another Aircraft object.
     * @param aircraft The aircraft object whose field values against which we wish to check for equality.
     * @return True all field values of both aircraft objects are equal, false otherwise.
     */
    public boolean equals(Aircraft aircraft){
        return (id == aircraft.getId()) &&
               (make.equals(aircraft.getMake())) &&
               (model.equals(aircraft.getModel())) &&
               (maximumRange.equals(aircraft.getMaximumRange())) &&
               (maximumAltitude.equals(aircraft.getMaximumAltitude()) &&
               (fuelCapacity.equals(aircraft.getFuelCapacity()))) &&
               (maximumSpeed.equals(aircraft.getMaximumSpeed())) &&
               (sector.equals(aircraft.getSector()));
    }

    /**
     * Updates the fields of the object with those of another aircraft object,
     * whenever the field value for this object differs from that of the aircraft
     * passed as an argument.
     * @param aircraft The aircraft whose differing field values we wish to
     * pass to the object.
     */
    public void updateFields(Aircraft aircraft){
        if(aircraft.getMaximumAltitude() != null){
            this.maximumAltitude = aircraft.getMaximumAltitude();
        }
        if(aircraft.getFuelCapacity() != null){
            this.fuelCapacity = aircraft.getFuelCapacity();
        }
        if(aircraft.getMake() != null){
            this.make = aircraft.getMake();
        }
        if(aircraft.getModel() != null){
            this.model = aircraft.getModel();
        }
        if(aircraft.getSector() != null){
            this.sector = aircraft.getSector();
        }
        if(aircraft.getMaximumRange() != null){
            this.maximumRange = aircraft.getMaximumRange();
        }
        if(aircraft.getMaximumSpeed() != null){
            this.maximumSpeed = aircraft.getMaximumSpeed();
        }
    }
}
