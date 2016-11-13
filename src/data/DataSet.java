/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import constants.ACmode;
import constants.FanSpeed;
import java.util.HashMap;

/**
 *
 * @author Nudista
 */
public class DataSet {

    private static HashMap<Integer, Room> hm;

    public DataSet() {
        hm = new HashMap<>();
    }

    private void insertRoom(Room r) {
        hm.put(r.getNumber(), r);
        // System.out.println("Inserted " + r);
    }

    public void updateRoom(Room r) {
        if (hm.containsKey(r.getNumber())) {
            if (r.getAcMode() == ACmode.UNKNOWN && r.getWindow() == 2) {
                updateStatus(r);
            }
            if (r.getAcMode() == ACmode.UNKNOWN && r.getRented() == 2 && r.getPrivacy() == 2 && r.getOccupacy() == 2) {
                updateWindow(r);
            }
            if (r.getWindow() == 2 && r.getRented() == 2 && r.getPrivacy() == 2 && r.getOccupacy() == 2) {
                updateHVAC(r);
            }
        } else {
            insertRoom(r);
        }
    }

    public Room getRoom(String roomNumber) {
        if (roomNumber == null || "".equals(roomNumber) || (roomNumber.length() > 6)) {
            return new Room(-1);
        }
        int number = Integer.parseInt(roomNumber);
        if (hm.containsKey(number)) {
            return hm.get(number);
        } else {
            return new Room(-1);
        }
    }

    private void updateHVAC(Room r) {
        Room old = hm.get(r.getNumber());
        old.setAcMode(r.getAcMode());
        old.setCooling(r.getCooling());
        old.setFanSpeedProposed(r.getFanSpeedProposed());
        old.setHeating(r.getHeating());
        old.setTargetTemperature(r.getTargetTemperature());
        old.setTemperature(r.getTemperature());
        hm.replace(r.getNumber(), old);
        //System.out.println("Updated HVAC " + old);
    }

    private void updateWindow(Room r) {
        Room old = hm.get(r.getNumber());
        old.setWindow(r.getWindow());
        hm.replace(r.getNumber(), old);
       // System.out.println("Updated window" + old);
    }

    private void updateStatus(Room r) {
        Room old = hm.get(r.getNumber());
        if (r.getRented() != 2) {
            old.setRented(r.getRented());
        }
        if (r.getPrivacy() != 2) {
            old.setPrivacy(r.getPrivacy());
        }
        if (r.getOccupacy() != 2) {
            old.setOccupacy(r.getOccupacy());
        }
        hm.replace(r.getNumber(), old);
        //System.out.println("Updated status " + hm.get(old.getNumber()));
    }

}
