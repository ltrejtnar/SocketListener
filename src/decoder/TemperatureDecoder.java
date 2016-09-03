/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import java.util.Arrays;
import socketserver.Room;

/**
 *
 * @author Nudista
 */
public class TemperatureDecoder {

    private short[] packet;
    private final short[] HEADER = {255, 162, 0, 35};
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
        String result = "";
        for (short s : packet) {
            result = result + Integer.toBinaryString((int) s);
        }
        return Integer.parseInt(result, 2);
    }
     private int makeTemperature(short[] packet) {
     // String result = Integer.toBinaryString((int) packet[3]);
      //   System.out.println(Arrays.toString(packet));
       // return Integer.parseInt(result.substring(2), 2);
      return 1;
    }
      private int makeTarget(short[] packet) {
        String result = Integer.toBinaryString((int) packet[0]);
        return (Integer.parseInt(result.substring(2), 2))+40;

    }
      
      
}
