/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.User;
import services.UserSession;

/**
 * FXML Controller class
 *
 * @author Fatma
 */
public class MenuAdminFXMLController implements Initializable {

    @FXML
    private Label userName;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userName.setText(UserSession.getInstance().getPrenom_user()+ " " + UserSession.getInstance().getNom_user());
        
    }    
    
}
