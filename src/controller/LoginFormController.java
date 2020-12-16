/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application_validate.LoginFormValidate;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.*;

/**
 * FXML Controller class
 *
 * @author Thinot
 */
public class LoginFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //Define Label
    @FXML
    Label lblLogin = new Label();
    @FXML
    Label lblPassword = new Label();

    //Define TextField
    @FXML
    TextField txtLogin = new TextField();
    @FXML
    PasswordField txtPassword = new PasswordField();

    //Define Tooltip 
    @FXML
    Tooltip Login = new Tooltip();
    @FXML
    Tooltip Password = new Tooltip();

    //Define Button
    @FXML
    Button btnConnecter = new Button();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //ActionEvent Connecter
    public void btnConnecter() throws Exception {
        if (LoginOnKeyReleased()) {
            LoginGS entry = new LoginGS(txtLogin.getText(), txtPassword.getText());
            Effacer();
            LoginQuery log = new LoginQuery();
            log.SessionStart(entry);
        }

    }

    //ActionEvent OnKeyReleased
    public boolean LoginOnKeyReleased() {
        //Form Validation
        boolean login = LoginFormValidate.textFieldNotEmpty(txtLogin, Login, "Login is required");
        boolean password = LoginFormValidate.textFieldNotEmpty(txtPassword, Password, "Password is required");
        boolean r = false;
        if (login && password) {
            r = true;
        }
        return r;
    }

    //ActionEvent clear
    public void Effacer() {
        txtLogin.clear();
        txtPassword.clear();
    }

}
