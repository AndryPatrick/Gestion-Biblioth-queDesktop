/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application_main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Thinot
 */
public class LoginMain extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(LoginMain.class, (java.lang.String[]) null);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {      
     try {
          AnchorPane login =(AnchorPane) FXMLLoader.load(LoginMain.class.getResource("/view/LoginForm.fxml"));
          Scene scene = new Scene(login);
          scene.getStylesheets().add(getClass().getResource("/application_style/loginform.css").toExternalForm());
          primaryStage.setScene(scene);
          primaryStage.setTitle("Formulaire Login");
          primaryStage.show();
      } catch(IOException ex) {
          Logger.getLogger(LoginMain.class.getName()).log(Level.SEVERE, null, ex);
      }        
    }   
}
