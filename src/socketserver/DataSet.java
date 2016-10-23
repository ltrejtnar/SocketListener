/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

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
        System.out.println("Inserted " + r);
    }

    public void updateRoom(Room r) {
        if (hm.containsKey(r.getNumber())) {
            hm.replace(r.getNumber(), r);
            System.out.println("Updated " + r);
        } else {
            insertRoom(r);
        }
    }

    public Room getRoom(String roomNumber) {
        if(roomNumber==null || "".equals(roomNumber)) return new Room(0, 0, 0, ACmode.UNKNOWN, FanSpeed.UNKNOWN, FanSpeed.UNKNOWN);
        int number = Integer.parseInt(roomNumber);
        if (hm.containsKey(number)) {
            return hm.get(number);
        } else {
            return new Room(number, 0, 0, ACmode.UNKNOWN, FanSpeed.UNKNOWN, FanSpeed.UNKNOWN);
        }
    }

}
