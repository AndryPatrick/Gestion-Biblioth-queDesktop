/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application_validate;

import javafx.scene.control.*;

/**
 *
 * @author Thinot
 */
public class PageFormValidate {
    
    public static boolean TextFieldNotEmpty(TextField txt){
        boolean r = false;
        if(txt.getText() != null && !txt.getText().isEmpty()){
            r = true;
        }
      return r;
    }
    
    public static boolean TextFieldNotEmpty(TextField txt, Tooltip t, String sValidationText){
        boolean r = true;
        String c = null;
      
        if(!TextFieldNotEmpty(txt)){
            r = false;
            c = sValidationText;
          
        }
        t.setText(c);
        txt.setTooltip(t);
        return r;
    }
    
    public static boolean DatePickerNotEmpty(DatePicker dat){
        boolean r = false;
        if(dat.getValue() != null && !dat.getValue().toString().isEmpty()){
            r = true;
        }
      return r;
    }
    
    public static boolean DatePickerNotEmpty(DatePicker dat, Tooltip t, String sValidationText){
        boolean r = true;
        String c = null;
      
        if(!DatePickerNotEmpty(dat)){
            r = false;
            c = sValidationText;
          
        }
        t.setText(c);
        dat.setTooltip(t);
        return r;
    }
    
    public static boolean ComboBoxNotEmpty(ComboBox com){
        boolean r = false;
        if(com.getValue() != null && !com.getValue().toString().isEmpty()){
            r = true;
        }
      return r;
    }
    
    public static boolean ComboBoxNotEmpty(ComboBox com, Tooltip t, String sValidationText){
        boolean r = true;
        String c = null;
        if(!ComboBoxNotEmpty(com)){
            r = false;
            c = sValidationText;
        }
        t.setText(c);
        com.setTooltip(t);
        return r;
    }
    
}
