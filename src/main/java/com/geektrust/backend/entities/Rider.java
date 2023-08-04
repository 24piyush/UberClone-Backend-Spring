package com.geektrust.backend.entities;

import java.util.List;

public class Rider extends BaseEntity  {

    private Coordinates rider_cooridnates;
    List<String> matchedDriversList;
    String ride_id;

    public Rider (String id, Coordinates coordinates) {
        this.id = id;
        this.rider_cooridnates = coordinates;
    }

    public String getId () {
        return this.id;
    }

    public Coordinates getRiderCoordinates() {
        return this.rider_cooridnates;
    }

    public String toString() {
        return "Rider: " + this.id + " " + this.rider_cooridnates;
    }


    public String getRideId() {
        return this.ride_id;
    }

    public void setRideId(String ride_id) {
        this.ride_id = ride_id;
    }

    public List<String> getMatchedDriversList() {
        return this.matchedDriversList;
    }

    public void setMatchedDriversList(List<String> matchedDriversList) {
        this.matchedDriversList = matchedDriversList;
    }
}
