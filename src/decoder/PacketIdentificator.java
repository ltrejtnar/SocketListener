/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import socketserver.Room;

/**
 *
 * @author Nudista
 */
public class PacketIdentificator {
    private static PacketIdentificator instance = null;
    private final short[] HEADER = {255, 162, 0, 35};
    private TemperatureDecoder tempDec;

    private PacketIdentificator() {
    }
    
    public static PacketIdentificator getInstance() {
      if(instance == null) {
         instance = new PacketIdentificator();
      }
      return instance;
   }
    
    public Room decode(short[] packet){
        if(checkPacketTemperature(packet)){
            tempDec = new TemperatureDecoder(packet);
            return tempDec.setDataToRoom();
        }else{
            return null;
        }
        
    }
    
    
    private boolean checkPacketTemperature(short[] packet) {
        int i = 0;
        for (short s : HEADER) {
            if (s != packet[i]) {
                return false;
            }
            i++;
        }
        return true;
    }
    
    
}
