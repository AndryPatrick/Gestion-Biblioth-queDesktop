/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.*;

/**
 *
 * @author Thinot
 */
public class ConnectDB {
    String Pilote = "com.mysql.jdbc.Driver";
    String URLBase = "jdbc:mysql://localhost:3306/gestion_bibliotheque";
    Connection connect;
    public ConnectDB() {
        try{
            Class.forName(Pilote);
        }catch(ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
        try{
            connect = (Connection)DriverManager.getConnection(URLBase,"root","");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    public Connection Connect(){
        return connect;
    }
}
