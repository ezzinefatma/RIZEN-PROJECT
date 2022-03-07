/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PostController implements Initializable {

    @FXML
    private ImageView imgProfile;
    @FXML
    private Label username;
    @FXML
    private ImageView imgVerified;
    @FXML
    private Label date;
    @FXML
    private ImageView audience;
    @FXML
    private Label caption;
    @FXML
    private ImageView imgPost;
    @FXML
    private Label nbReactions;
    @FXML
    private Label nbComments;
    @FXML
    private HBox reactionsContainer;
    @FXML
    private ImageView imgLike;
    @FXML
    private ImageView imgDislike;
    @FXML
    private Label likeContainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onLikeContainerMouseReleased(MouseEvent event) {
    }

    @FXML
    private void onLikeContainerPressed(MouseEvent event) {
    }
    
}
