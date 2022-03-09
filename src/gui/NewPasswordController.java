/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import interfaces.Iuser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import services.ServiceUser;


/**
 * FXML Controller class
 *
 * @author Fatma
 */
public class NewPasswordController implements Initializable {

    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXPasswordField confirmpassword;
    @FXML
    private JFXButton resetpassword;
    
    public static String mailUpdate="a";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void resetPassword(ActionEvent event) throws IOException, Exception {
        if(
            password.getText().isEmpty())
        {   Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter your new Password");
            alert.showAndWait();
        }
         else if (!confirmpassword.getText().equals(password.getText()))
        { 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Password confirmation does not match password");
        alert.showAndWait();
        }
        else
        { 
        String newPassword = password.getText();
        Iuser Iu = new ServiceUser();
        mailUpdate=ForgotPasswordController.email;
        Iu.UpdatePassword(mailUpdate, newPassword);
        FXMLLoader loader = new FXMLLoader();
        password.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
        }
    }
    
}
