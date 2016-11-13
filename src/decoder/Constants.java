/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder;

/**
 *
 * @author Ladislav Trejtnar CVUT FEL
 */
public interface Constants {

    final int ROOMSTART = 12;
    final int TEMPSTART = 20;
    final int TARGETSTART = 17;
    final int COOLSTART = 26;
    final int STATUSINDENTIFICATION = 16;
    final int STATUSVALUE = 18;
    final int WINDOWIDENTIFICATION = 16;
    final int WINDOWVALUE = 18;
    final int RENTED = 0;
    final int OCCUPANCY = 1;
    final int PRIVACY = 2;
    final int WINDOW = 236;
    final int DND= 8;
    final int MUR = 10;
    final int COOLINGPOSITION=4;
    final int HEATINGPOSITION = 3;
    final short[] HEADERTEMP = {255, 162, 0, 35};
    final short[] HEADERSTATUS = {255, 160, 0, 23};
    final short[] HEADERWINDOW = {255, 129, 0, 9};
}
