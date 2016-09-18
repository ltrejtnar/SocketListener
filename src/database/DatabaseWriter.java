/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nudista
 */
public class DatabaseWriter {

    private final String dbDriver = "com.mysql.jdbc.Driver";
    private String dbURL;
    private String user;
    private String password;

    public DatabaseWriter(String user, String password) {
        this.user = user;
        this.password = password;
        this.dbURL = "jdbc:mysql://localhost/";
    }

    public DatabaseWriter(String dbURL, String user, String password) {
        this.dbURL = dbURL;
        this.user = user;
        this.password = password;
    }

    private final boolean connectDB() {
        Connection conn = null;
        boolean result = true;
        try {
            //Register JDBC driver
            Class.forName(dbDriver);
            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(dbDriver, user, password);
        } catch (ClassNotFoundException ex) {
            result = false;
            Logger.getLogger(DatabaseWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            result = false;
            Logger.getLogger(DatabaseWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
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

}
