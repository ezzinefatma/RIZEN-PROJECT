/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;


import java.net.URL;
import model.stream;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ford_
 */
public class Stream_ModelController implements Initializable {

    @FXML
    private WebView video_url;

    @FXML
    private Label userName;

    @FXML
    private Label title;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
}
public void setData(stream s){

      
        video_url.getEngine().load(s.getUrl());
        userName.setText(s.getUsername());
        title.setText(s.getTitre_stream());


    }



        // TODO
       
    
}
