/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import application_main.*;
import java.sql.*;
import javafx.stage.Stage;

/**
 *
 * @author Thinot
 */

public class LoginQuery {
    
    Stage primaryStage = new Stage();
    
    public void SessionStart(LoginGS login) throws Exception{
        String sql = "select Login,Password from user where Login = '"+ login.getLogin() +"' and Password = '"+ login.getPassword() +"'";
        ResultSet rs = ExecuteFetchQuery(sql);
        try{
            if(rs.next()){
                PageMain page = new PageMain();
                page.start(primaryStage);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public ResultSet ExecuteFetchQuery(String sql) {
        ResultSet rs = null;
        try{
            ConnectDB con = new ConnectDB();
            rs = con.Connect().createStatement().executeQuery(sql);
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
       return rs;
    }
    
}
