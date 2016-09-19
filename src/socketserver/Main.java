/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nudista
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       DataSet hotelData = new DataSet();
        Server server = null;
        server = new Server(22348, hotelData);
        Thread serverThread = new Thread(server);
        serverThread.start();
       CommunicationListener cl = new CommunicationListener(hotelData);
        Thread listener = new Thread(cl);
        listener.start();
    }

}
