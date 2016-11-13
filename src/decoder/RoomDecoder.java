/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

import static decoder.Constants.ROOMSTART;
import java.util.Collections;

/**
 *
 * @author Ladislav Trejtnar CVUT FEL
 */
public class RoomDecoder implements Constants {

    public int makeRoomNumber(short[] packet) {
        String firstByte = Integer.toBinaryString(packet[ROOMSTART]);
        return Integer.parseInt((firstByte + fillByte(Integer.toBinaryString(packet[ROOMSTART + 1]))), 2);
    }

    public String fillByte(String data) {
        int l = 8 - data.length();
        String filled = String.join("", Collections.nCopies(l, String.valueOf("0")));
        return filled + data;
    }
}
