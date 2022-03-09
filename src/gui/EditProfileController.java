/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import interfaces.Iuser;
import java.awt.event.MouseEvent;
import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.User;
import services.ServiceUser;
import services.UserSession;

/**
 * FXML Controller class
 *
 * @author Fatma
 */
public class EditProfileController implements Initializable {

    @FXML
    private JFXTextField lastnameFT;
    @FXML
    private JFXTextField ageFT;
    @FXML
    private JFXTextField phoneFT;
    @FXML
    private JFXTextField adressFT;
    @FXML
    private JFXTextField firstnameTF;
    @FXML
    private JFXButton updateButton;
    @FXML
    private JFXButton backButton;
    @FXML
    private JFXButton uploadButton;
    @FXML
    private ImageView imageUser;
    
    
    File file;
    @FXML
    private Label url;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       lastnameFT.setText(UserSession.getInstance().getNom_user());
        firstnameTF.setText(UserSession.getInstance().getPrenom_user());
        ageFT.setText(Integer.toString(UserSession.getInstance().getAge()));
        phoneFT.setText(Integer.toString(UserSession.getInstance().getPhone()));
        adressFT.setText(UserSession.getInstance().getAdress());
       
        }

      
      

    @FXML
    private void update(ActionEvent event) {
        ServiceUser su = new ServiceUser();
        User u = new User();
        //sets
        u.setPrenom_user(firstnameTF.getText());
        u.setNom_user(lastnameFT.getText());
        u.setAge(Integer.parseInt(ageFT.getText()));
        u.setNumero_tel(Integer.parseInt(phoneFT.getText()));
        u.setAdresse(adressFT.getText());
      //  u.setPhoto(imageUser.getText());
        su. modifierUser(u);
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader();
                backButton.getScene().getWindow().hide();  
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("HomePage.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
    }

    @FXML
    private void uploadImage(ActionEvent event) {
        
        FileChooser fileChooserr = new FileChooser();
        fileChooserr.setTitle("Select picture");
        fileChooserr.setInitialDirectory(new File("/"));
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooserr.getExtensionFilters().add(imageFilter);
        file = fileChooserr.showOpenDialog(imageUser.getScene().getWindow());
        Image image = new Image(file.toURI().toString());
        imageUser.setImage(image);
       url.setText(file.getAbsolutePath());
}
    
}
