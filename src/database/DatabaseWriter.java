/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import socketserver.Room;

/**
 *
 * @author Nudista
 */
public class DatabaseWriter implements Runnable, ConstantsSQL {

    private final String dbDriver = "org.postgresql.Driver";
    private String database;
    private int port;
    private String IP;
    private String user;
    private String password;
    private final DatabaseExecutor executor;
    private boolean request;
    private Room room;
    

    public DatabaseWriter() {
        this.user = "postgres";
        this.password = "password";
        this.database = "postgres";
        this.port = 5432;
        this.IP = "localhost";
        executor = new DatabaseExecutor();
        request = false;
    }

    public DatabaseWriter(String database, int port, String IP, String user, String password) {
        this.database = database;
        this.port = port;
        this.IP = IP;
        this.user = user;
        this.password = password;
        executor = new DatabaseExecutor();
        request = false;
    }

    private String getPostgresURL() {
        return "jdbc:postgresql://" + IP + ":" + port + "/" + database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public boolean isRequest() {
        return request;
    }

    public void setRequest(boolean request) {
        this.request = request;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void run() {
       
        Connection conn = null;
        try {
            Class.forName(dbDriver);        //Register JDBC driver
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver not found");
            Logger.getLogger(DatabaseWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connecting to database...");
        try {
            conn = DriverManager.getConnection(getPostgresURL(), user, password); //Open a connection
        } catch (SQLException ex) {
            System.err.println("Connection failed");
            Logger.getLogger(DatabaseWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conn != null) {
            System.out.println("You made it, take control your database now!");
            if (!tableExist("Rooms", conn)) {
                executor.createTable(conn);
            }
            while (true) {
                if (request) {
                   executor.updateData(conn, room);
                    request = false;
                }else {
                    try {
                        Thread.sleep(30L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DatabaseWriter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } else {
            System.out.println("Failed to make connection!");
        }

    }

    private boolean tableExist(String table, Connection c) {
        try {
            DatabaseMetaData dbm = c.getMetaData();
            ResultSet tables = dbm.getTables(null, null, table, null);
            if (tables.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseWriter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
