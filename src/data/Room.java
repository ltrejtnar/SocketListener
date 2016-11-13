/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
    private FanSpeed fanSpeedMan;
    private FanSpeed fanSpeedProposed;
//    0=false, 1=true, 2=unknown
    private int rented;
    private int privacy;
    private int occupacy;
    private int window;
    private int heating;
    private int cooling;
    private int dnd;
    private int mur;

    public Room(int number) {
        this.number = number;
    }

    public Room(int number, double temperature, double targetTemperature, ACmode acMode, FanSpeed fanSpeedMan, FanSpeed fanSpeedProposed) {
        this.number = number;
        this.temperature = temperature;
        this.targetTemperature = targetTemperature;
        this.acMode = acMode;
        this.fanSpeedMan = fanSpeedMan;
        this.fanSpeedProposed = fanSpeedProposed;
    }

    public Room(int number, double temperature, double targetTemperature, ACmode acMode, FanSpeed fanSpeedMan, FanSpeed fanSpeedProposed, int rented, int privacy, int occupacy, int window, int heating, int cooling) {
        this.number = number;
        this.temperature = temperature;
        this.targetTemperature = targetTemperature;
        this.acMode = acMode;
        this.fanSpeedMan = fanSpeedMan;
        this.fanSpeedProposed = fanSpeedProposed;
        this.rented = rented;
        this.privacy = privacy;
        this.occupacy = occupacy;
        this.window = window;
        this.heating = heating;
        this.cooling = cooling;
        this.dnd = 2;
        this.mur = 2;
    }

    public int isHeating() {
        return heating;
    }

    public void setHeating(int heating) {
        this.heating = heating;
    }

    public int isCooling() {
        return cooling;
    }

    public void setCooling(int cooling) {
        this.cooling = cooling;
    }

    

    public int isRented() {
        return rented;
    }

    public void setRented(int rented) {
        this.rented = rented;
    }

    public int isPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public int isOccupacy() {
        return occupacy;
    }

    public void setOccupacy(int occupacy) {
        this.occupacy = occupacy;
    }

    public int isWindow() {
        return window;
    }

    public void setWindow(int window) {
        this.window = window;
    }

    public ACmode getAcMode() {
        return acMode;
    }

    public void setAcMode(ACmode acMode) {
        this.acMode = acMode;
    }

    public FanSpeed getFanSpeedMan() {
        return fanSpeedMan;
    }

    public void setFanSpeedMan(FanSpeed fanSpeedMan) {
        this.fanSpeedMan = fanSpeedMan;
    }

    public FanSpeed getFanSpeedProposed() {
        return fanSpeedProposed;
    }

    public void setFanSpeedProposed(FanSpeed fanSpeedProposed) {
        this.fanSpeedProposed = fanSpeedProposed;
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

    public int getDnd() {
        return dnd;
    }

    public void setDnd(int dnd) {
        this.dnd = dnd;
    }

    public int getMur() {
        return mur;
    }

    public void setMur(int mur) {
        this.mur = mur;
    }

    public int getNumber() {
        return number;
    }

    public int getRented() {
        return rented;
    }

    public int getPrivacy() {
        return privacy;
    }

    public int getOccupacy() {
        return occupacy;
    }

    public int getWindow() {
        return window;
    }

    public int getHeating() {
        return heating;
    }

    public int getCooling() {
        return cooling;
    }
    
    

    private double FarenheitToCelcius(double temp) {
        long value = Math.round((double) ((temp - 32) * 5 / 9) * 100);
        return (double) value / 100;
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
  
        return "{\"ro\":\"" + number + "\", \"tm\":\"" + temperature +  "\", \"tt\":\"" + targetTemperature + "\", \"ac\":\"" + acMode + "\", \"fa\":\"" + fanSpeedProposed + "\", \"re\":\"" + (rented) + "\", \"oc\":\"" + (occupacy) + "\", \"wi\":\"" + (window) + "\", \"pr\":\"" + (privacy) +"\", \"co\":\"" + (cooling) +"\", \"he\":\"" + (heating) +"\"}";


 // return "{\"ro\":\"" + number + "\", \"tm\":\"" + temperature +  "\", \"tt\":\"" + targetTemperature + "\", \"ac\":\"" + acMode + "\", \"fa\":\"" + fanSpeedProposed + "\", \"re\":\"" + (rented) + "\", \"oc\":\"" + (occupacy) + "\", \"wi\":\"" + (window) + "\", \"pr\":\"" + (privacy) +"\", \"co\":\"" + (cooling) +"\", \"he\":\"" + (heating) +"\", \"dn\":\"" + (dnd) +"\", \"mu\":\"" + (mur) +"\"}";
    }

}
