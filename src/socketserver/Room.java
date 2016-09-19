/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import constants.ACmode;
import constants.FanSpeed;

/**
 *
 * @author Nudista
 */
public class Room {
   private final int number;
   private double temperature;
   private double targetTemperature;
   private ACmode acMode;
   private FanSpeed fanSpeed;

    public Room(int number) {
        this.number = number;
    }

    public Room(int number, double temperature, double targetTemperature, ACmode acMode, FanSpeed fanSpeed) {
        this.number = number;
        this.temperature = temperature;
        this.targetTemperature = targetTemperature;
        this.acMode = acMode;
        this.fanSpeed = fanSpeed;
    }

    

    public ACmode getAcMode() {
        return acMode;
    }

    public void setAcMode(ACmode acMode) {
        this.acMode = acMode;
    }

    public FanSpeed getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(FanSpeed fanSpeed) {
        this.fanSpeed = fanSpeed;
    }
    
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public int getNumber() {
        return number;
    }
    
    private double FarenheitToCelcius(double temp){
        long number = Math.round((double) ((temp-32)*5/9) * 100);
        return (double) number/100;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.number;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        double tempC = FarenheitToCelcius(temperature);
        double targTempC = FarenheitToCelcius(targetTemperature);
        return "Room: " + number + "<br/>Temp.: " + temperature + "&degF ("+ tempC+ "&degC)<br/>Target: " + targetTemperature + "&degF (" +targTempC + "&degC)<br/>AC mode: " + acMode + "<br/>Fan speed: " + fanSpeed;
    }

    
   
   
}
