/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author HUNTER
 */
public class MenuFXMLController implements Initializable {
private  Parent fxml;

    @FXML
    private VBox root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void wall(MouseEvent event) {
try{
    fxml= FXMLLoader.load(getClass().getResource("WalletFXML.fxml"));
    root.getChildren().removeAll();
     root.getChildren().setAll(fxml);  
         }catch (IOException e){
    e.printStackTrace(); 
        
        
    }
    }
    
}
