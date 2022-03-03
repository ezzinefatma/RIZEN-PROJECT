/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import interfaces.Ichat;
import interfaces.Istreaming;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.chat;
import services.ServiceChat;
import java.lang.Object;
import javafx.collections.FXCollections;
import model.react_stream;
import model.status_stream;
import model.stream;
import model.stream_category;
import services.ServiceStream;
/**
 * FXML Controller class
 *
 * @author ford_
 */
public class StremFXMLController implements Initializable {
    Ichat sc = new ServiceChat();
    Istreaming ss = new ServiceStream();
    @FXML
    private TextField id_userTF;
    @FXML
    private TextField id_streamTF;
    @FXML
    private TextField reportTF;
    @FXML
    private TextField ContentTF;
    @FXML
    private Label list_comment;
    @FXML
    private ComboBox  cat;
    @FXML
    private TextField titre;
    @FXML
    private TextField url;
    @FXML
    private TextField background;
    @FXML
    private ComboBox status;
    @FXML
    private ComboBox react;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("Action" ,"Adventure","Role_Playing","FPS","Strategy","Racing","E_sport");
        cat.setItems(list);
        
        
        ObservableList<String> list1= FXCollections.observableArrayList("online" ,"offline");
        status.setItems(list1);
        
        ObservableList<String> list2 = FXCollections.observableArrayList("like" ,"dislikee");
        react.setItems(list2);
        
    }    

    @FXML
    private void ajouter_chat(ActionEvent event) {
        
        
        list_comment.setText(sc.afficher_msg().toString());

    }

    @FXML
    private void add_stream(ActionEvent event) {
        
      String c = cat.getSelectionModel().getSelectedItem().toString();
      stream_category category = stream_category.valueOf(c);
      
      
      String s = status.getSelectionModel().getSelectedItem().toString();
      
      status_stream stat = status_stream.valueOf(s);
      
      
      String r = react.getSelectionModel().getSelectedItem().toString();
      
        react_stream reac = react_stream.valueOf(r);
      
      
      
      
      
        ss.ajouterstream(new stream(titre.getText(),category,25,25,url.getText(),2,stat,background.getText(),reac));
        
    }
   
}
