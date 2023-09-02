package com.geektrust.backend.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.geektrust.backend.common.CommonFunctions;
import com.geektrust.backend.entities.Coordinates;
import com.geektrust.backend.entities.Driver;
import com.geektrust.backend.entities.Rider;
import com.geektrust.backend.exceptions.NoDriverFoundException;
import com.geektrust.backend.repositories.IDriverRepository;
import com.geektrust.backend.repositories.IRiderRepository;

public class RiderService implements IRiderService {

    private IRiderRepository riderRepository;
    private IDriverRepository driverRepository;

    public RiderService(IRiderRepository riderRepository,IDriverRepository driverRepository) {
        this.riderRepository = riderRepository;
        this.driverRepository = driverRepository;
    }
    @Override
    public Rider createRider(String rider_id, Coordinates rider_coordinates) {
        Rider rider = new Rider(rider_id,rider_coordinates);
        rider = riderRepository.save(rider);
        return rider;
    }
    @Override
    public List<String> matchRiderToDrivers(String rider_id) throws NoDriverFoundException{
        List<Driver> drivers = driverRepository.getAllDrivers();
        Rider rider = riderRepository.getRider(rider_id);
        List<String> matched_drivers = getNearestDrivers(rider, drivers);
        if(matched_drivers.isEmpty()) throw new NoDriverFoundException("NO_DRIVERS_AVAILABLE");
        rider.setMatchedDriversList(matched_drivers);
        return matched_drivers;
    }

    private List<String> getNearestDrivers(Rider rider, List<Driver> drivers) {
        Coordinates rider_coordinates = rider.getRiderCoordinates();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maximum_matches = 5;
        int maximum_distance = 5;
        
        for (Driver driver : drivers) {
            if(driver.getRideId() != null) continue;
            Coordinates driver_coordinates = driver.getDriverCoordinates();
            double distance = CommonFunctions.calculateDistance(rider_coordinates, driver_coordinates);
            if(distance > maximum_distance) continue;
            pq.add(new Pair(driver.getId(),distance));

            if(pq.size() > maximum_matches)
                pq.remove();
        }

        List<String> nearestDrivers = new ArrayList<>();
        while(!pq.isEmpty()) {
            nearestDrivers.add(pq.remove().driver_id);
        }
        Collections.reverse(nearestDrivers);
        return nearestDrivers;
    }

    private class Pair implements Comparable<Pair> {
        String driver_id;
        double distance;

        public Pair(String driver_id, double distance) {
            this.driver_id = driver_id;
            this.distance = distance;
        }

        public int compareTo(Pair other) {
            if(this.distance == other.distance) {
                return this.driver_id.compareTo(other.driver_id);
            }
            else {
                return Double.compare(this.distance, other.distance);
            }
        }
    }
    
}
