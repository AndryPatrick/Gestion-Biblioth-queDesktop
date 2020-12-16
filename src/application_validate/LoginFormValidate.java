/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application_validate;

import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 *
 * @author Thinot
 */
public class LoginFormValidate {
    
    //TextField LoginForm Validation
    public static boolean textFieldNotEmpty(TextField i){
        boolean r = false;
        if(i.getText() != null && !i.getText().isEmpty()) {
            r = true;
        }
       return r;
    }
    
    //Validation LoginForm with TextField,Tooltip and Text
    public static boolean textFieldNotEmpty(TextField i, Tooltip l, String sValidationText){
        boolean r = true;
        String c = null;
        if(!textFieldNotEmpty(i)){
            r = false;
            c=sValidationText;
            
        }
       l.setText(c);
       i.setTooltip(l);
       return r;
    }
    
}
