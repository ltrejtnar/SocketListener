/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import constants.ACmode;
import constants.FanSpeed;
import data.Room;
import java.util.Arrays;

/**
 *
 * @author Ladislav Trejtnar CVUT FEL
 */
public class WindowDecoder extends RoomDecoder implements Decoder, Constants {

    private short[] packet;
    //0=rented, 1 = privacy, 2=occunpacy
    private int[] result = {2, 2, 2};

    WindowDecoder(short[] packet) {
        this.packet = packet; //To change body of generated methods, choose Tools | Templates.
    }

    public short[] getPacket() {
        return packet;
    }

    public void setPacket(short[] packet) {
        this.packet = packet;
    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }

    //    0=false, 1=true, 2=unknown
    @Override
    public Room setDataToRoom() {
        int[] badarray = {2, 2, 2};
        makestatus();
        if (Arrays.equals(result, badarray)) {
      // if(result[0]==2){
            return null;
        } else {
            return new Room(makeRoomNumber(packet), 0, 0, ACmode.UNKNOWN, FanSpeed.UNKNOWN, FanSpeed.UNKNOWN, 2, 2, 2, result[0], 2, 2);
        }
    }

//0=window, 1 = mur, 2=dnd
//0=false, 1=true, 2=unknown
    private void makestatus() {
        switch (packet[WINDOWIDENTIFICATION]) {
            case WINDOW:
                result[0] = setValue(packet[WINDOWVALUE]);
                break;
            case DND:
                result[2] = setValue(packet[WINDOWVALUE]);
                break;
            case MUR:
                result[1] = setValue(packet[WINDOWVALUE]);
                break;
            default:
                break;
        }
    }

    private int setValue(int value) {
        switch (value) {
            case 1:
                return 1;
            case 0:
                return 0;
            default:
                return 2;
        }
    }
}
