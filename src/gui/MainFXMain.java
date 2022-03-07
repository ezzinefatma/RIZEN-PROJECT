/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



/**
 *
 * @author HUNTER
 */
public class MainFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MenuFXML.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Rizen");
        primaryStage.setScene(scene);
        primaryStage.show();
        Image img = new Image ("/icns/logo+.jpg");
        primaryStage.getIcons().add(img);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
