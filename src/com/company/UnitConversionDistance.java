package com.company;

public class UnitConversionDistance {

    public boolean isValidDistance(double distance){

        boolean result = false;

        if(distance > 0){
            result = true;
        }
        return result;
    }

    public double calculateMetersToCentimeters(double distance){
        return distance*100;
    }

    public double calculateKilometersToMeters(double distance){
        return distance*1000;
    }
}
