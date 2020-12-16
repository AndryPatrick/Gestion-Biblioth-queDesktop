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
public class PageMain extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(PageMain.class, (java.lang.String[]) null);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            AnchorPane page = (AnchorPane) FXMLLoader.load(PageMain.class.getResource("/view/PageForm.fxml"));
            Scene scene = new Scene(page);
            scene.getStylesheets().add(getClass().getResource("/application_style/pageform.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestion bibliotheque");
            primaryStage.show();
        } catch (IOException e) {
            Logger.getLogger(PageMain.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
