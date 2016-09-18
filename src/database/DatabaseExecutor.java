/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import socketserver.Room;

/**
 *
 * @author Nudista
 */
public class DatabaseExecutor implements ConstantsSQL {

    public void createTable(Connection c) {
        try {
            Statement stmt = c.createStatement();
            stmt.executeUpdate(MAKEROOMTABLE);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertData(Connection c, Room r) {
        String sql = INSERT + r.getNumber() + "," + r.getTemperature() + "," + r.getTargetTemperature() + ",'" + r.getAcMode() + "','" + r.getFanSpeed() + "');";
        try {
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateData(Connection c, Room r) {
        System.out.println(r);
        String sql=UPDATE;
       // String sql = "UPDATE public.\"Rooms\"\n"
         //       + "   SET \"Temperature\"=" + r.getTemperature() + ", \"TargetTemperature\"=" + r.getTargetTemperature() + ", \"ACmode\"='" + r.getAcMode() + "', \n"
           //     + "       \"FanMode\"='" + r.getFanSpeed() + "'\n"
             //   + " WHERE \"Number\"=" + r.getNumber() + ";";
        try {

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, r.getNumber());
            ps.setDouble(2, r.getTemperature());
            ps.setDouble(3, r.getTargetTemperature());
            ps.setString(4, r.getAcMode().toString());
            ps.setString(5, r.getFanSpeed().toString());
            ps.setInt(6, r.getNumber());
            //Statement stmt = c.createStatement();
            System.out.println(ps);
            int rows = ps.executeUpdate(sql);
            System.out.println(rows);
     
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
