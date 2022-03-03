/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import interfaces.Ichat;
import interfaces.Istreaming;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.react_stream;
import model.status_stream;
import model.stream;
import model.stream_category;
import services.ServiceChat;
import services.ServiceStream;

/**
 * FXML Controller class
 *
 * @author ford_
 */
public class AjouteradminController implements Initializable {
Ichat sc = new ServiceChat();
    Istreaming ss = new ServiceStream();
    @FXML
    private AnchorPane root;
    @FXML
    private TextField titre_s;
    @FXML
    private TextField url;
    @FXML
    private TextField backpic;
    @FXML
    private ComboBox cat_s;
    @FXML
    private ComboBox status_s;
    @FXML
    private ComboBox react_s;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("Action" ,"Adventure","Role_Playing","FPS","Strategy","Racing","E_sport");
        cat_s.setItems(list);
        
        
        ObservableList<String> list1= FXCollections.observableArrayList("online" ,"offline");
        status_s.setItems(list1);
        
        ObservableList<String> list2 = FXCollections.observableArrayList("like" ,"dislike");
        react_s.setItems(list2);
    }    

    @FXML
    private void ajouter(MouseEvent event) {
        
        String c = cat_s.getSelectionModel().getSelectedItem().toString();
        
      stream_category category = stream_category.valueOf(c);
      
      
      String s = status_s.getSelectionModel().getSelectedItem().toString();
      
      status_stream stat = status_stream.valueOf(s);
      
      
      String r = react_s.getSelectionModel().getSelectedItem().toString();
      
        react_stream reac = react_stream.valueOf(r);
      
      
       ss.ajouterstream(new stream(titre_s.getText(),category,25,25,url.getText(),2,stat,backpic.getText(),reac)); 
        
        
    }
    
}
