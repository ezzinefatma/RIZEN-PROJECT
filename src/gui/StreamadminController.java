/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import model.stream;
import util.maConnexion;
import interfaces.Istreaming;
import interfaces.Ichat;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;






import services.ServiceStream;

/**
 * FXML Controller class
 *
 * @author ford_
 */
public class StreamadminController implements Initializable {
    
    Istreaming ss = new ServiceStream(); 

    @FXML
    private AnchorPane root;
    @FXML
    private TableColumn<stream, Integer> id_s;
    @FXML
    private TableColumn<stream, String> titre_s;
    @FXML
    private TableColumn<stream, String> cat;
    @FXML
    private TableColumn<stream, Integer> nbr_lik;
    @FXML
    private TableColumn<stream, Integer> nbr_rep;
    @FXML
    private TableColumn<stream, String> url;
    @FXML
    private TableColumn<stream, Integer> id_us;
    @FXML
    private TableColumn<stream, String> statu;
    @FXML
    private TableColumn<stream, String> back_pic;
    @FXML
    private TableColumn<stream, String> react;
    @FXML
    private TableView<stream> lstream;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void afficher_stream_list(ActionEvent event) {
        
    
        ObservableList<stream> liststream = FXCollections.observableArrayList(ss.afficherstream());
        lstream.getItems().clear();
        //liststream = ss.afficherstream()
                
                
                
               // ObservableList<String> list1= FXCollections.observableArrayList("online" ,"offline");
        //status_s.setItems(list1);
        
         id_s.setCellValueFactory(new PropertyValueFactory<stream, Integer>("id_stream"));
        titre_s.setCellValueFactory(new PropertyValueFactory<stream, String>("titre_stream")); 
         cat.setCellValueFactory(new PropertyValueFactory<stream, String>("categorie")); 
            nbr_lik.setCellValueFactory(new PropertyValueFactory<stream, Integer>("nbr_like")); 
              nbr_rep.setCellValueFactory(new PropertyValueFactory<stream, Integer>("nbr_report")); 
                 url.setCellValueFactory(new PropertyValueFactory<stream, String>("url")); 
                 id_us.setCellValueFactory(new PropertyValueFactory<stream, Integer>("id_user")); 
                  statu.setCellValueFactory(new PropertyValueFactory<stream, String>("status")); 
                   back_pic.setCellValueFactory(new PropertyValueFactory<stream, String>("background_pic")); 
                   react.setCellValueFactory(new PropertyValueFactory<stream, String>("react"));
                         lstream.setItems(liststream);
    }
        
        
        
    }
    

