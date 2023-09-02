package com.geektrust.backend.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.geektrust.backend.common.CommonFunctions;
import com.geektrust.backend.entities.Ride;

public class CalculateBillService implements ICalculateBillService {
    private final int BASE_FARE = 50; 
    private final double ONE_KILOMETER_CHARGE = 6.5;
    private final double ONE_MINUTE_CHARGE = 2;
    private final double SERVICE_TAX_PERCENT = 0.2;
    private final  int DECIMAL_PLACES = 2; // Number of decimal places to round off to

    @Override
    public Double calculateRideBill(Ride ride) {

        //  A base fare of ₹50 is charged for every ride.
        
        
        //  An additional ₹6.5 is charged for every kilometer traveled. 
        // double one_kilometer_charge = 6.5;
        // double distanceTravelled = CommonFunctions.calculateDistance(ride.getStartCoordinates(), ride.getEndCoordinates());
        // //String distanceTravelledFormattedValue = decimalFormat.format(distanceTravelled);
        // distanceTravelled = roundOff(distanceTravelled);
        // double billForEveryKilometer = one_kilometer_charge * distanceTravelled;
        // billForEveryKilometer = roundOff(billForEveryKilometer);
        double billForEveryKilometer = billForEveryKilometer(ride);

        //  An additional ₹2 is charged for every minute spent in the ride. 
        // double one_minute_charge = 2;
        // double minutesTravelled = ride.getRideDuration();
        // double billForEveryMinute = one_minute_charge * minutesTravelled;
        double billForEveryMinute = billForEveryMinute(ride);

        //final amount(bill before tax)
        double finalAmount = BASE_FARE + billForEveryKilometer + billForEveryMinute;

        //  A service tax of 20% is added to the final amount.
        // double serviceTaxPercent = 0.2;
        // double serviceTaxAmount = serviceTaxPercent * finalAmount;
        // serviceTaxAmount = roundOff(serviceTaxAmount);
        double serviceTaxAmount = serviceTaxAmount(finalAmount);

        double billAfterTax = finalAmount + serviceTaxAmount;
        billAfterTax = roundOff(billAfterTax);
        return billAfterTax;
    }

    private double billForEveryKilometer(Ride ride) {
        double distanceTravelled = CommonFunctions.calculateDistance(ride.getStartCoordinates(), ride.getEndCoordinates());

        distanceTravelled = roundOff(distanceTravelled);
        double billForEveryKilometer = ONE_KILOMETER_CHARGE * distanceTravelled;
        billForEveryKilometer = roundOff(billForEveryKilometer);
        return billForEveryKilometer;
    }

    private double billForEveryMinute(Ride ride) {
        
        double minutesTravelled = ride.getRideDuration();
        double billForEveryMinute = ONE_MINUTE_CHARGE * minutesTravelled;

        return billForEveryMinute;
    }

    private double serviceTaxAmount(double finalAmount) {
        double serviceTaxAmount = SERVICE_TAX_PERCENT * finalAmount;
        serviceTaxAmount = roundOff(serviceTaxAmount);

        return serviceTaxAmount;
    }

    private double roundOff(double value) {
        BigDecimal originalBigDecimal = new BigDecimal(value);
        BigDecimal roundedValue = originalBigDecimal.setScale(DECIMAL_PLACES, RoundingMode.HALF_UP);
        return Double.valueOf(roundedValue.toString());
    }
}
