/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import constants.ACmode;
import constants.FanSpeed;
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
        return new Room(makeRoomNumber(), makeTemperature(), makeTarget(), makeAcMode(), makeFanSpeedMan(), makeFanSpeedProposed());
    }

    public void updateRoom(Room r) {

    }

    private int makeRoomNumber() {
        String firstByte = Integer.toBinaryString(packet[ROOMSTART]);
        return Integer.parseInt((firstByte + fillByte(Integer.toBinaryString(packet[ROOMSTART+1]))), 2);
    }

    private double makeTemperature() {
        String firstByte = fillByte(Integer.toBinaryString((int) packet[TEMPSTART])).substring(1);
        String secondByte = fillByte(Integer.toBinaryString((int) packet[TEMPSTART+1])).substring(4);
        return (double) Integer.parseInt(firstByte+secondByte, 2)/10;
        

    }

    private double makeTarget() {
        String result = fillByte(Integer.toBinaryString((int) packet[TARGETSTART]));
        if (isFarenheit()) {
            return (Integer.parseInt(result.substring(2), 2)) + 40;
        } else {
            return (Integer.parseInt(result.substring(2), 2) * 9 / 5 + 32);
        }
    }

    private FanSpeed makeFanSpeedMan() {
        String result = Integer.toBinaryString((int) packet[TARGETSTART+1]);
        int status = Integer.parseInt(fillByte(result).substring(4, 6), 2);
        switch (status) {
            case 0:
                return FanSpeed.OFF;
            case 1:
                return FanSpeed.LOW;
            case 2:
                return FanSpeed.MEDIUM;
            case 3:
                return FanSpeed.HIGH;
            default:
                return FanSpeed.UNKNOWN;
        }
    }

    private FanSpeed makeFanSpeedProposed() {
        String result = Integer.toBinaryString((int) packet[TEMPSTART+3]);
        int status = Integer.parseInt(fillByte(result).substring(6), 2);
        switch (status) {
            case 0:
                return FanSpeed.OFF;
            case 1:
                return FanSpeed.LOW;
            case 2:
                return FanSpeed.MEDIUM;
            case 3:
                return FanSpeed.HIGH;
            default:
                return FanSpeed.UNKNOWN;
        }
    }
    
    private ACmode makeAcMode() {
        String result = Integer.toBinaryString((int) packet[TARGETSTART+1]);
        int status = Integer.parseInt(fillByte(result).substring(6), 2);
        switch (status) {
            case 0:
                return ACmode.OFF;
            case 1:
                return ACmode.FAN_ONLY;
            case 2:
                return ACmode.FAN_FIXED;
            case 3:
                return ACmode.AUTO;
            default:
                return ACmode.UNKNOWN;
        }
    }

    private boolean isFarenheit() {
        int farenheitPosition = 1;
        String result = Integer.toBinaryString((int) packet[TARGETSTART]);
        return result.charAt(farenheitPosition) == '0';
    }

    private String fillByte(String data) {
        int l = 8 - data.length();
        String filled = String.join("", Collections.nCopies(l, String.valueOf("0")));
        return filled + data;
    }
}
