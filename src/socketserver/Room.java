/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

/**
 *
 * @author Nudista
 */
public class Room {
   private final int number;
   private double temperature;
   private double targetTemperature;

    public Room(int number) {
        this.number = number;
    }

    public Room(int number, double temperature, double targetTemperature) {
        this.number = number;
        this.temperature = temperature;
        this.targetTemperature = targetTemperature;
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
        return "Room{" + "number=" + number + ", temperature=" + temperature + ", targetTemperature=" + targetTemperature + '}';
    }
   
   
}
