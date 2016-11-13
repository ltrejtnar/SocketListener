/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import data.Room;
import java.util.Arrays;

/**
 *
 * @author Nudista
 */
public class PacketIdentificator implements Constants {

    private static PacketIdentificator instance = null;
    private TemperatureDecoder tempDec;
    private StatusDecoder statDec;
    private WindowDecoder winDec;

    private PacketIdentificator() {
    }

    public static PacketIdentificator getInstance() {
        if (instance == null) {
            instance = new PacketIdentificator();
        }
        return instance;
    }

    public Room decode(short[] packet) {
        if (checkPacketTemperature(packet)) {
            tempDec = new TemperatureDecoder(packet);
            return tempDec.setDataToRoom();
        } else if (checkPacketStatus(packet)) {
            statDec = new StatusDecoder(packet);
            return statDec.setDataToRoom();
        } else if (checkPacketWindow(packet)) {
            winDec = new WindowDecoder(packet);
            return winDec.setDataToRoom();
        } else {
            return null;
        }

    }

    private boolean checkPacketTemperature(short[] packet) {
        int i = 0;
        for (short s : HEADERTEMP) {
            if (s != packet[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean checkPacketStatus(short[] packet) {
        int i = 0;
        for (short s : HEADERSTATUS) {
            if (s != packet[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean checkPacketWindow(short[] packet) {
        int i = 0;
        for (short s : HEADERWINDOW) {
            if (s != packet[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

}
