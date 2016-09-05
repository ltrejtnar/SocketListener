/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import java.util.Arrays;
import java.util.Collections;
import socketserver.Room;

/**
 *
 * @author Nudista
 */
public class TemperatureDecoder {

    private short[] packet;
    private final int ROOMSTART = 12;
    private final int TEMPSTART = 20;
    private final int TARGETSTART = 17;

    public TemperatureDecoder(short[] packet) {
        this.packet = packet;
    }

    public short[] getPacket() {
        return packet;
    }

    public void setPacket(short[] packet) {
        this.packet = packet;
    }

    public Room setDataToRoom() {
        int room;
        double temperature, target;
        room = makeRoomNumber(Arrays.copyOfRange(packet, ROOMSTART, ROOMSTART + 2));
        temperature = makeTemperature(Arrays.copyOfRange(packet, TEMPSTART, TEMPSTART + 6));
        target = makeTarget(Arrays.copyOfRange(packet, TARGETSTART, TARGETSTART + 2));
        return new Room(room, temperature, target);
    }

    private int makeRoomNumber(short[] packet) {
        String secondByte, firstByte = "";
        int l;
        secondByte = Integer.toBinaryString(packet[1]);
        l = 8 - secondByte.length();
        String filled = String.join("", Collections.nCopies(l, String.valueOf("0")));
        firstByte = Integer.toBinaryString(packet[0]);
        return Integer.parseInt((firstByte+filled+secondByte), 2);
    }

    private double makeTemperature(short[] packet) {
        String result = Integer.toBinaryString((int) packet[3]);
        System.out.println(result);
          /* if (isFarenheit(packet)) {
            return (Integer.parseInt(result.substring(2), 2)) + 40;
        } else {
            return (Integer.parseInt(result.substring(2), 2));
        }*/
          return 1;
      
    }

    private double makeTarget(short[] packet) {
        String result = Integer.toBinaryString((int) packet[0]);
        if (isFarenheit(packet)) {
            return (Integer.parseInt(result.substring(2), 2)) + 40;
        } else {
            return (Integer.parseInt(result.substring(2), 2) * 9 / 5 + 32);
        }
    }

    private boolean isFarenheit(short[] packet) {
        int farenheitPosition = 1;
        String result = Integer.toBinaryString((int) packet[0]);
        return result.charAt(farenheitPosition) == '0';
    }
}
