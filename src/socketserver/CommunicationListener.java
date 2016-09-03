/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import decoder.PacketIdentificator;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author Nudista
 */
public class CommunicationListener implements Runnable {

    private int port;
    private String DCenterIPaddress;
    private Socket socket;
    private InputStream InStream;
    private boolean start;
    private byte[] data;
    private short[] dataCorrected;
    private final int DATALENGTH = 47;
    private PacketIdentificator decoder;    //has to be singleton

    public CommunicationListener() {
        port = 3002;
        DCenterIPaddress = "localhost";
        start = true;
        decoder = new PacketIdentificator();
    }

    public CommunicationListener(int port, String DCenterIPaddress) {
        this.port = port;
        this.DCenterIPaddress = DCenterIPaddress;
        start = true;
        decoder = new PacketIdentificator();
    }

    private void setListenSocket() {
        try {
            socket = new Socket(DCenterIPaddress, port);
        } catch (IOException ex) {
            System.err.println("Socket inicialization error");
        }
        try {
            InStream = socket.getInputStream();
        } catch (IOException ex) {
            System.err.println("Input Stream inicialization error");
        }
        data = new byte[DATALENGTH];
    }

    private void covertToShortArray() {
        dataCorrected = new short[DATALENGTH];
        int iterator = 0;
        for (byte b : data) {
            if (b < 0) {
                dataCorrected[iterator] = (short) ((short) b + 256);
            } else {
                dataCorrected[iterator] = b;
            }
            iterator++;
        }
    }

    private String toHexString(short[] decimalArray) {
        String result = "Server data: ";
        for (short b : decimalArray) {
            result = result + ", " + Integer.toHexString(b);
        }
        return result;

    }

    @Override
    public void run() {
        int count = -1;
        setListenSocket();
        while (start) {
            try {
                count = InStream.read(data);
            } catch (IOException ex) {
                System.err.println("Data reading error");
            }
            System.out.println("Server bytes count: " + count);
            covertToShortArray();
            System.out.println(toHexString(dataCorrected));
            System.out.println("Server data: " + Arrays.toString(dataCorrected));
            System.out.println(decoder.decode(dataCorrected));
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDCenterIPaddress() {
        return DCenterIPaddress;
    }

    public void setDCenterIPaddress(String DCenterIPaddress) {
        this.DCenterIPaddress = DCenterIPaddress;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

}
