/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import data.DataSet;
import configLoader.Loader;
import logs.Logger;

/**
 *
 * @author Nudista
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Loader config = new Loader("config/SSconfig.properties");

        int INNCOMport = Integer.parseInt(config.getProp().getProperty("inncom.port", "3002"));
        int WEBport = Integer.parseInt(config.getProp().getProperty("web.port", "22348"));
        String INNCOMaddress = config.getProp().getProperty("inncom.address", "localhost");
        boolean innServisLog = Boolean.valueOf(config.getProp().getProperty("web.logs", "false"));
        boolean innComLog = Boolean.valueOf(config.getProp().getProperty("inncom.logs", "false"));
        
        Logger log = new Logger(innServisLog, innComLog);
        DataSet hotelData = new DataSet();
        CommunicationListener cl = new CommunicationListener(INNCOMport, INNCOMaddress, hotelData, WEBport);
        Thread listener = new Thread(cl);
        listener.start();
    }

}
