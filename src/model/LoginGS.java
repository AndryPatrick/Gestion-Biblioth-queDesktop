/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Thinot
 */
public class LoginGS {
    
    private String Login;
    private String Password;
    
    public String getLogin(){
        return Login;
    }
    
    public void setLogin(String Login){
        this.Login = Login;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String Password){
        this.Password = Password;
    }
    
    public LoginGS(String Login, String Password){
        this.Login = Login;
        this.Password = Password;
    }
    
    public LoginGS(){}
    
}
