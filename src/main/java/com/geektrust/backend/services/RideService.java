package com.geektrust.backend.services;


import java.util.List;

import com.geektrust.backend.entities.Coordinates;
import com.geektrust.backend.entities.Driver;
import com.geektrust.backend.entities.Ride;
import com.geektrust.backend.entities.RideStatus;
import com.geektrust.backend.entities.Rider;
import com.geektrust.backend.repositories.IDriverRepository;
import com.geektrust.backend.repositories.IRideRepository;
import com.geektrust.backend.repositories.IRiderRepository;

public class RideService implements IRideService {

    private final String INVALID_RIDE = "INVALID_RIDE";
    private final String RIDE_STARTED = "RIDE_STARTED";
    private final String RIDE_STOPPED = "RIDE_STOPPED";
    private final String RIDE_NOT_COMPLETED = "RIDE_NOT_COMPLETED";
    private final String GENERATE_BILL_MESSAGE = "BILL";

    private IDriverRepository driverRepository;
    private IRiderRepository riderRepository;
    private IRideRepository rideRepository;

    public RideService(IRideRepository rideRepository, IRiderRepository riderRepository, IDriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
        this.riderRepository = riderRepository;
    }

    @Override
    public String startRide(String ride_id, int driver_number, String rider_id) {
        //If the match has fewer than N number of drivers, driver is not available, or <RIDE_ID> already exists
        if(validateRide(ride_id, driver_number, rider_id)) {
            Rider rider = riderRepository.getRider(rider_id);
            rider.setRideId(ride_id);

            Coordinates ride_starting_coordinates = rider.getRiderCoordinates();

            String driver_id = rider.getMatchedDriversList().get(driver_number-1);
            Driver driver = driverRepository.getDriverById(driver_id);
            driver.setRideId(ride_id);

            Ride ride = new Ride(ride_id, rider_id, driver_id, ride_starting_coordinates);
            rideRepository.saveRide(ride);
            return RIDE_STARTED + " " + ride_id;
        }
        else 
            return INVALID_RIDE;
    }

    @Override
    public String stopRide(String ride_id, Coordinates ride_end_coordinates, double ride_duration_in_minutes) {
        Ride ride = rideRepository.getRideById(ride_id);

        if(ride == null || (ride.getRideStatus() == RideStatus.ENDED))
            return INVALID_RIDE;
        
        ride.stopRide(ride_end_coordinates, ride_duration_in_minutes);

        String rider_id = ride.getRiderId();
        Rider rider = riderRepository.getRider(rider_id);
        rider.setRideId(null);

        String driver_id = ride.getDriverId();
        Driver driver = driverRepository.getDriverById(driver_id);
        driver.setRideId(null);

        return RIDE_STOPPED + " " + ride_id;
    }

    @Override
    public String generateRideBill(String ride_id) {
        Ride ride = rideRepository.getRideById(ride_id);

        if(ride == null) return INVALID_RIDE;
        if(ride.getRideStatus() == RideStatus.IN_PROGRESS) return RIDE_NOT_COMPLETED;

        String driverId = ride.getDriverId();
        ICalculateBillService calculateBillService = new CalculateBillService();
        Double rideBill = calculateBillService.calculateRideBill(ride);

        //BILL <RIDE_ID> <DRIVER_ID> <AMOUNT>
        String response = GENERATE_BILL_MESSAGE + " " + ride_id + " " + driverId + " " + String.format("%.2f",rideBill);
        return response;
    }

    
    private boolean validateRide(String ride_id, int driver_number, String rider_id) {

        //check if Ride Id already exists
        Ride previous_ride = rideRepository.getRideById(ride_id);
        if(previous_ride != null) return false;

        //check if requested driver number is not greater than number of matched drivers
        Rider rider = riderRepository.getRider(rider_id);
        List<String> matched_drivers = rider.getMatchedDriversList();
        if(matched_drivers == null) return false;
        if(driver_number > matched_drivers.size()) return false;

        //Check if requested driver is available or not
        String driver_id = matched_drivers.get(driver_number-1);
        Driver driver = driverRepository.getDriverById(driver_id);
        String driver_current_ride_id = driver.getRideId();
        if(driver_current_ride_id != null) return false;

        return true;
    }
    
}
