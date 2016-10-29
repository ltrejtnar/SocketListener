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
    private FanSpeed fanSpeedMan;
    private FanSpeed fanSpeedProposed;
    private boolean rented;
    private boolean privacy;
    private boolean occupacy;
    private boolean window;
    private boolean heating;
    private boolean cooling;

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

    public Room(int number, double temperature, double targetTemperature, ACmode acMode, FanSpeed fanSpeedMan, FanSpeed fanSpeedProposed, boolean rented, boolean privacy, boolean occupacy, boolean window, boolean heating, boolean cooling) {
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
    }

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public boolean isCooling() {
        return cooling;
    }

    public void setCooling(boolean cooling) {
        this.cooling = cooling;
    }

    

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public boolean isOccupacy() {
        return occupacy;
    }

    public void setOccupacy(boolean occupacy) {
        this.occupacy = occupacy;
    }

    public boolean isWindow() {
        return window;
    }

    public void setWindow(boolean window) {
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

    public int getNumber() {
        return number;
    }

    private double FarenheitToCelcius(double temp) {
        long number = Math.round((double) ((temp - 32) * 5 / 9) * 100);
        return (double) number / 100;
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
    
    private int booleanToNumber(boolean b){
        if(b==true){
            return 1;
        }else{
            return 0;
        }
    } 

    @Override
    public String toString() {
      //  return "Room: " + number + "<br/>Temp.: " + temperature + "&degF (" + tempC + "&degC)<br/>Target: " + targetTemperature + "&degF (" + targTempC + "&degC)<br/>AC mode: " + acMode + "<br/>Fan speed: " + fanSpeed;
        return "{\"ro\":\"" + number + "\", \"tm\":\"" + temperature +  "\", \"tt\":\"" + targetTemperature + "\", \"ac\":\"" + acMode + "\", \"fa\":\"" + fanSpeedProposed + "\", \"re\":\"" + booleanToNumber(rented) + "\", \"oc\":\"" + booleanToNumber(occupacy) + "\", \"wi\":\"" + booleanToNumber(window) + "\", \"pr\":\"" + booleanToNumber(privacy) +"\", \"co\":\"" + booleanToNumber(cooling) +"\", \"he\":\"" + booleanToNumber(heating) +"\"}";
    //     return "{\"room\":\"" + number + "\", \"temp\":\"" + temperature +  "\", \"ttemp\":\"" + targetTemperature + "\", \"ac\":\"" + acMode + "\", \"fan\":\"" + fanSpeedProposed + "\", \"rented\":\"" + rented + "\", \"occup\":\"" + occupacy + "\", \"window\":\"" + window + "\", \"privat\":\"" + privacy +"\", \"cool\":\"" + cooling +"\", \"heat\":\"" + heating +"\"}";
 //  return "{\"ro\":\"" + number + "\", \"tm\":\"" + temperature +  "\", \"tt\":\"" + targetTemperature + "\", \"ac\":\"" + acMode + "\", \"fa\":\"" + fanSpeedProposed + "\", \"co\":\"" + booleanToNumber(cooling) +"\", \"he\":\"" + booleanToNumber(heating) +"\"}";
  
    }

}
