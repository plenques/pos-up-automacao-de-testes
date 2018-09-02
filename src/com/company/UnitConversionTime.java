package com.company;

public class UnitConversionTime {

    public boolean isValidTime(double time){

        boolean result = false;

        if(time > 0){
            result = true;
        }
        return result;
    }

    public double calcSecondsToMinutes(double time){
        return (time / 60);
    }

    public double calcSecondsToHours(double time){
        return this.calcSecondsToMinutes(time)/60;
    }

    public double calcMinutesToHours(double time){
        return (time /60);
    }

    public double calcMinutesToSeconds(double time){
        return (time * 60);
    }

    public double calcHoursToMinutes(double time){
        return (time * 60);
    }

    public double calcHoursToSeconds(double time){
        return (this.calcHoursToMinutes(time))*60;
    }
}
