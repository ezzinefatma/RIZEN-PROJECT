/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXListView;
import interfaces.Iuser;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.User;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Fatma
 */
public class UsersListBackController implements Initializable {

    @FXML
    private Label userName;
    @FXML
    private Label listUsers;
    @FXML
    private JFXListView<User> ListUsers;
    @FXML
    private AnchorPane acro;
    @FXML
    private HBox dashbord;
    @FXML
    private HBox users;
    @FXML
    private Button ban;
    @FXML
    private Button unban;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Iuser iu= new ServiceUser();
        List <User> users=new ArrayList<> ();
        ListUsers.getItems().addAll(iu.afficherUsers());
        ListUsers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observable, User oldValue, User newValue) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }    
   

    private void afficherUsers() {
        
    }

    @FXML
    private void banFunction(ActionEvent event) {
    }

    @FXML
    private void unbanFunction(ActionEvent event) {
    }
    
}
