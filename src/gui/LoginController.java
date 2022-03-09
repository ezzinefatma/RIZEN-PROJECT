/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import interfaces.Iadmin;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import model.User;
import services.ServiceAdmin;
import services.UserSession;
import util.SendMail;

/**
 * FXML Controller class
 *
 * @author Fatma
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField emailTF;
    @FXML
    private JFXPasswordField passwordPF;
    @FXML
    private JFXButton signUpButton;
    @FXML
    private JFXButton loginButton;
    
      @FXML
    private JFXButton forgotPwdButton;
      
    public static String password;
    
    public static String email;
    
    public static int  codem;
    
    /**
     * Initializes the controller class.
     */
    
        public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();} 
        catch (AddressException ex) {
            result = false;
        }
        return result;
    }
 
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("NewPassword.fxml"));
        NewPasswordController ircc = loader.getController();
        String s="a";
        if (!ircc.mailUpdate.equals(s)){
            emailTF.setText(ircc.mailUpdate);
        }
    }    

    @FXML
    private void signup(ActionEvent event) throws IOException {
        
                FXMLLoader loader = new FXMLLoader();
                signUpButton.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("SignUp.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void login(ActionEvent event) throws Exception {
        
        User u=new User();
      
       email = emailTF.getText();
        password = passwordPF.getText();
        
        ServiceAdmin sa= new ServiceAdmin();
        
     
        if (emailTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("fill missing infos");
            alert.showAndWait();
        }
        else if (passwordPF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("fill missing infos");
            alert.showAndWait();
        }
        else if(isValidEmailAddress(emailTF.getText())==false)
        {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Email invalid");
            alert.showAndWait();  
        }
       
        else if (sa.login(email, password)) {
            
                 u=sa.getByEmail(email);
                UserSession.getInstace(u.getId_user(), u.getNom_user(), u.getPrenom_user(), u.getAge(), u.getNumero_tel(),u.getAdresse(), u.getEmail(), u.getPassword());
                 FXMLLoader loader = new FXMLLoader();
                loginButton.getScene().getWindow().hide();  
                Stage prStage = new Stage();
                loader.setLocation(getClass().getResource("MenuFXML.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
               
                
    
        }
        else {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Password or Email is incorrect");
            alert.showAndWait();
        } 
        
        
        
    }

    @FXML
    private void forgotpassword(ActionEvent event) throws IOException {
        
               FXMLLoader loader = new FXMLLoader();
                forgotPwdButton.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("ForgotPassword.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void logingoogle(ActionEvent event) {
    }

    @FXML
    private void loginfacebook(ActionEvent event) {
    }
    
}
