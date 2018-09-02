package com.company;

public class UnitConversionSpeed {

    public boolean isValidSpeed(double speed){

        boolean result = false;

        if(speed > 0){
            result = true;
        }
        return result;
    }

    public double calculateMeterSecondsToKilometersHour(double speed){
        return speed*3.6;
    }

    public double calculateKilometersHourToMeterSeconds(double speed){
        return speed/3.6;
    }


}
