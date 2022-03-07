/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IWallet;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.wallet;
import services.ServiceWallet;

/**
 * FXML Controller class
 *
 * @author HUNTER
 */
public class WalletFXMLController implements Initializable {
    IWallet wallet = new ServiceWallet();
    wallet w = new wallet("4521 8526 8745 6944", 1562, "12/12", 1);
        private  Parent fxml;


    @FXML
    private Label CardNumber;
    @FXML
    private Label Solde;
    @FXML
    private Label Expire;
    @FXML
    private LineChart<?, ?> linechartWallet;
    @FXML
    private VBox root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       CardNumber.setText(w.getCard_number());
       Expire.setText(w.getExpire());
       XYChart.Series series = new XYChart.Series();
       series.setName("Ventes");
       
            series.getData().add(new XYChart.Data("Jan", 23));
            series.getData().add(new XYChart.Data("Feb", 14));
            series.getData().add(new XYChart.Data("Mars", 15));
            series.getData().add(new XYChart.Data("Avril", 24)); 
            series.getData().add(new XYChart.Data("Mai", 34));
            series.getData().add(new XYChart.Data("Juin", 36));
            series.getData().add(new XYChart.Data("Juillet", 22));
            series.getData().add(new XYChart.Data("Aug", 45));
            series.getData().add(new XYChart.Data("Sep", 43));
            series.getData().add(new XYChart.Data("Oct", 17));
            series.getData().add(new XYChart.Data("Nov", 29));
            series.getData().add(new XYChart.Data("Dec", 25));
            linechartWallet.getData().add(series);
    }    

   

    @FXML
    private void BuyCoins(MouseEvent event) {
         try{
    fxml= FXMLLoader.load(getClass().getResource("AchatFXML.fxml"));
    root.getChildren().removeAll();
     root.getChildren().setAll(fxml);  
         }catch (IOException e){
    e.printStackTrace(); 
        
        
    }
    }

    

    @FXML
    private void Transaction(ActionEvent event) {
         try{
    fxml= FXMLLoader.load(getClass().getResource("AchatFXML.fxml"));
    root.getChildren().removeAll();
     root.getChildren().setAll(fxml);  
         }catch (IOException e){
    e.printStackTrace(); 
        
        
    }
    }

    }
