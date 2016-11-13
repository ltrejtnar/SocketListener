/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import constants.ACmode;
import constants.FanSpeed;
import data.Room;

/**
 *
 * @author Nudista
 */
public class TemperatureDecoder extends RoomDecoder implements Decoder, Constants{

    private short[] packet;


    public TemperatureDecoder(short[] packet) {
        this.packet = packet;
    }

    public short[] getPacket() {
        return packet;
    }

    public void setPacket(short[] packet) {
        this.packet = packet;
    }
    
    @Override
    //    0=false, 1=true, 2=unknown
    public Room setDataToRoom() {
  
        return new Room(makeRoomNumber(packet), makeTemperature(), makeTarget(), makeAcMode(), makeFanSpeedMan(), makeFanSpeedProposed(), 2, 2, 2, 2, makeHeating(), makeCooling());
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
    
    //    0=false, 1=true, 2=unknown
    private int makeCooling() {
        String result = Integer.toBinaryString((int) packet[COOLSTART+1]);
        if(fillByte(result).charAt(COOLINGPOSITION) == '1') return 1;
        else return 0;
    
       
    }
    
    //    0=false, 1=true, 2=unknown
     private int makeHeating() {  
        String result = Integer.toBinaryString((int) packet[COOLSTART+1]);
         if(fillByte(result).charAt(HEATINGPOSITION) == '1') return 1;
        else return 0;
    }

    private boolean isFarenheit() {
        int farenheitPosition = 1;
        String result = Integer.toBinaryString((int) packet[TARGETSTART]);
        return result.charAt(farenheitPosition) == '0';
    }

  
   
}
