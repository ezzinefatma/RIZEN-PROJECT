/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import interfaces.Inews;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.news;
import services.ServiceNews;

/**
 * FXML Controller class
 *
 * @author OUSSAMA
 */
public class NewsFXMLController implements Initializable {
// var
    Inews sn = new ServiceNews();
    @FXML
    private TextField titre_newsTF;
    @FXML
    private TextField contenu_newsTF;
    @FXML
    private Label viewNews;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterNews(ActionEvent event) {
        sn.ajouterNews(new news(titre_newsTF.getText(),contenu_newsTF.getText()));
    }

    @FXML
    private void AficherNews(ActionEvent event) {
        
        viewNews.setText(sn.afficherNews().toString());
    }
    
}
