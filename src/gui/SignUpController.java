/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import interfaces.Iuser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import model.User;
import services.ServiceUser;
import util.SendMail;

/**
 * FXML Controller class
 *
 * @author Fatma
 */
public class SignUpController implements Initializable {

    @FXML
    private JFXTextField firstnameTF;
    @FXML
    private JFXTextField lastnameFT;
    @FXML
    private JFXTextField ageFT;
    @FXML
    private JFXTextField phoneFT;
    @FXML
    private JFXTextField adressFT;
    private JFXTextField emailFT;
    private JFXPasswordField passwordFT;
    private JFXPasswordField confirmpasswordFT;
    @FXML
    private JFXButton backButton;

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
       
            Iuser Ia = new ServiceUser();
            if (Ia.getIdbyMail(emailFT.getText())!=Ia.getId()){
                email=emailFT.getText();
                return true;
    }
            return false;
         
    }
       
        public boolean ControleFirstName() {
		String str =firstnameTF.getText().toLowerCase();
		char[] charArray = str.toCharArray();
                
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
				return false;
			}
		}
		return true;
	}
        
         public boolean ControleLastName() {
		String str =lastnameFT.getText().toLowerCase();
		char[] charArray = str.toCharArray();
                
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
				return false;
			}
		}
		return true;
	}
 
      
	public boolean ControleAge() {
       if (ageFT.getText().matches("[0-9]{2}")) {
			return true;
		}
		return false;
	}
        
    
	public boolean ControlePhone() {
		// regex expression to verify if the phone inserted contains only 8 numbers
          int length = (int)(Math.log10(Integer.parseInt(phoneFT.getText()))+1);  
          if (length==8) 
              return true;
              return false;
	}
        
            public boolean ControlePassword() {
		if(passwordFT.getText().length()>=8)
              return true;
              return false;
	}
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void signup(ActionEvent event) throws SQLException, IOException, MessagingException {
        
        
        if(firstnameTF.getText().isEmpty()) { 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" First Name Field empty");
        alert.showAndWait();}
        else if(ControleFirstName()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("First Name is not valid");
        alert.showAndWait();     
        }
        /************************************************/
        
        else if (lastnameFT.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Last Name Field empty");
        alert.showAndWait();}
        else if(ControleLastName()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("First Name is not valid");
        alert.showAndWait();     
        }
        
        /************************************************/
        
        else if (ageFT.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Age Field empty");
        alert.showAndWait();}
        else if(ControleAge()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Age is not valid");
        alert.showAndWait();     
        }
        
        /************************************************/
        
        else if (phoneFT.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Phone Field empty");
        alert.showAndWait();}
         else if(ControlePhone()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("phone format is not valid");
        alert.showAndWait();     
        }
         
          
        /************************************************/
        
        else if (adressFT.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Adress Field empty");
        alert.showAndWait();}
        
         
        /************************************************/
        
        else if (emailFT.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Email Field empty");
        alert.showAndWait();}
         else if(isValidEmailAddress(emailFT.getText())==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Email is not valid");
        alert.showAndWait();     
        }
         
        else if(UserExists(emailFT.getText())==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("email already exists");
        alert.showAndWait();     
        }
        
         
        /************************************************/
        
         else if (passwordFT.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Password Field empty");
        alert.showAndWait();
        }
         else if(ControlePassword()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("password must contain at least 8 characters");
        alert.showAndWait();     
        }
          else if (!confirmpasswordFT.getText().equals(passwordFT.getText()))
        { 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Password confirmation does not match password");
        alert.showAndWait();
        }
        else
        { 
        User u = new User();
        u.setNom_user(lastnameFT.getText());
        u.setPrenom_user(firstnameTF.getText());
        u.setAge(Integer.parseInt(ageFT.getText()));
        u.setNumero_tel(Integer.parseInt(phoneFT.getText()));
        u.setAdresse(adressFT.getText());
        u.setEmail(emailFT.getText());
        u.setPassword(passwordFT.getText());
        ServiceUser us = new  ServiceUser();
        us.addUser(u);
        SendMail.sendSignUp(emailFT.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Account created successfully ");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader();
        firstnameTF.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
        }

    }

    @FXML
    private void back(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                backButton.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("Login.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    
    
}
