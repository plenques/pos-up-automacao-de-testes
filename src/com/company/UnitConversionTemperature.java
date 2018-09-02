package com.company;

import java.util.Arrays;
import java.util.List;

public class UnitConversionTemperature {
    private double LOWEST_TEMPERATURE_CELSIUS = -273.15;
    private double LOWEST_TEMPERATURE_FAHRENHEIT = -459.67;
    private double LOWEST_TEMPERATURE_KELVIN = 0;

    public boolean isValidTemperature(double temperature, String initialUnit)
    {
        boolean result = false;

        switch (initialUnit){
            case "KELVIN":
                if(temperature >= LOWEST_TEMPERATURE_KELVIN)
                    result = true;
                break;
            case "CELSIUS":
                if(temperature >= LOWEST_TEMPERATURE_CELSIUS)
                    result = true;
                break;
            case "FAHRENHEIT":
                if(temperature >= LOWEST_TEMPERATURE_FAHRENHEIT){
                    result =  true;
                }
                break;
            default:
                result = false;
        }

        return result;
    }

    public boolean isValidUnits(String unit){
        String[] units = new String[]{"KELVIN","CELSIUS","FAHRENHEIT"};
        List<String> listUnits = Arrays.asList(units);

        boolean result = false;
        if(listUnits.contains(unit)){
            result = true;
        }
        return result;
    }

    public double calcTemp(double temperature, String initialUnit, String finalUnit)
    {

        double finalTemp = 0;

        if(initialUnit =="CELSIUS" && finalUnit == "KELVIN"){
            finalTemp =  temperature + 273.15;
        }

        if(initialUnit =="KELVIN" && finalUnit == "CELSIUS"){
            finalTemp = temperature - 273.15;
        }

        if(initialUnit =="CELSIUS" && finalUnit == "FAHRENHEIT"){
            finalTemp =  (1.8 * temperature + 32);
        }

        if(initialUnit =="FAHRENHEIT" && finalUnit == "CELSIUS"){
            finalTemp = (temperature - 32) / 1.8;
        }

        if(initialUnit =="FAHRENHEIT" && finalUnit == "KELVIN"){
            finalTemp = (temperature - 32)/ 1.8 + 273.15;
        }

        if(initialUnit =="KELVIN" && finalUnit == "FAHRENHEIT"){
            finalTemp = (1.8 * (temperature - 273.15) + 32);
        }

        return finalTemp;
    }

    public String showConvertResult(double temperature,String  initialUnit, String finalUnit)
    {
        String message = "";

        if(this.isValidUnits(initialUnit) && this.isValidUnits(finalUnit)){
            if (this.isValidTemperature(temperature,initialUnit)) {
                double result = this.calcTemp(temperature,initialUnit,finalUnit);
                message =  "Valor "+initialUnit+" ("+String.format("%.2f",temperature)+") para "+finalUnit+" ("+String.format("%.2f",result)+")";
            }else{
                message = "Nao foi possivel realizar a conversão, pois a temperatura inicial é inválida em "+initialUnit;
            }
        }else{
            message = "Unidades inválidas. Valores aceitáveis em maiúsculo [CELSIUS,KELVIN,FAHRENHEIT]!";
        }
        return message;
    }



}
