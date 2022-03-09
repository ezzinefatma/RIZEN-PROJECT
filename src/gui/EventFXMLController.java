/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.sun.javafx.property.adapter.PropertyDescriptor;
import interfaces.Ievent;
import interfaces.Iinscription;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javax.xml.bind.Marshaller.Listener;
import model.User;
import model.event;
import services.ServiceEvent;
import services.serviceInscription;

/**
 * FXML Controller class
 *
 * @author OUSSAMA
 */
public class EventFXMLController implements Initializable {
    Ievent Ie = new ServiceEvent();
    Iinscription Ii = new serviceInscription();
    User u2 = new User(2,"Sebai", "Oussema", 23, 22587418,"oussamaesprit1@gmail.com","rue jasmin tunis","photo oussema");
    @FXML
    private VBox root;
    @FXML
    private ListView<event> myListe;
    private event CurrentEvents;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myListe.getItems().addAll(Ie.afficherEvent());
        myListe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<event>() {
            @Override
            public void changed(ObservableValue<? extends event> observable, event oldValue, event newValue) {
                
             CurrentEvents=myListe.getSelectionModel().getSelectedItem();
                
            }
        });
        // TODO
    }    

    @FXML
    private void subscribe(ActionEvent event) {
        Ii.ajouterInscription(CurrentEvents, u2);
        
    }
    
}
