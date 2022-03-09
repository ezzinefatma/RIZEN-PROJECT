/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import interfaces.Iuser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.ServiceUser;
import util.SendMail;

/**
 * FXML Controller class
 *
 * @author Fatma
 */
public class ForgotPasswordController implements Initializable {

    @FXML
    private JFXTextField emailTF;
    @FXML
    private JFXButton back;
    @FXML
    private JFXButton tryagain;
    @FXML
    private JFXButton mail;
    
     static String email;

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
 
        public boolean UserExists (String email) throws SQLException {
          Iuser Iu = new ServiceUser();
            if (Iu.getIdbyMail(emailTF.getText())!=0){
                email=emailTF.getText();
                return true;
    }
            return false;
    }
     
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
                back.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("Login.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void tryagain(ActionEvent event) throws MessagingException, IOException, SQLException{
          Iuser Iu = new ServiceUser();
        Random r = new Random ();
        int codem =r.nextInt(9999-1000+1);
        System.out.println(codem);
        if(isValidEmailAddress(emailTF.getText())==false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("Email address not valid");
            alert.showAndWait();
        }
         else if (UserExists(emailTF.getText())==false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("You are not user please create an account");
            alert.showAndWait(); 
        }
         else 
         {
        SendMail.send(emailTF.getText(),codem);
        FXMLLoader loader = new FXMLLoader();
       emailTF.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("ResetPassword.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
                }
         
    }
    

    @FXML
    private void mail(ActionEvent event) throws MessagingException, IOException, SQLException {
        
        Iuser Iu = new ServiceUser();
        Random r = new Random ();
        int codem =r.nextInt(9999-1000+1);
        System.out.println(codem);
        if(isValidEmailAddress(emailTF.getText())==false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("Email address not valid");
            alert.showAndWait();
        }
         else if (UserExists(emailTF.getText())==false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("You are not user please create an account");
            alert.showAndWait(); 
        }
         else 
         {
        SendMail.send(emailTF.getText(),codem);
        FXMLLoader loader = new FXMLLoader();
       emailTF.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("ResetPassword.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
                }
         
    }
    
}
