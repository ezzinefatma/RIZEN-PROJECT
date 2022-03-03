/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ford_
 */
public class DashbordadminController implements Initializable {
private  Parent fxml;
    @FXML
    private Button ajou;
    @FXML
    private Button affichage;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

   

   

    @FXML
    private void ajouterf(MouseEvent event) {
        
        try{
    fxml= FXMLLoader.load(getClass().getResource("ajouteradmin.fxml"));
    root.getChildren().removeAll();
     root.getChildren().setAll(fxml);  
         }catch (IOException e){
    e.printStackTrace(); 
        
        
    }
    }

    @FXML
    private void affichage(MouseEvent event) {
         try{
    fxml= FXMLLoader.load(getClass().getResource("streamadmin.fxml"));
    root.getChildren().removeAll();
     root.getChildren().setAll(fxml);  
         }catch (IOException e){
    e.printStackTrace(); 
        
        
    }
    }
}
