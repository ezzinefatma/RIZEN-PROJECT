/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Irec;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.ReqEnum;
import model.reclamation;
import services.Servicereclamation;

/**
 * FXML Controller class
 *
 * @author HUNTER
 */
public class ADDRECFXMLController implements Initializable {
    Irec  rec =new Servicereclamation();
    @FXML
    private TextArea DescRecTF;
    @FXML
    private TextField TypeRecTF;
    @FXML
    private TextField DispRecTF;
    @FXML
    private TextField idset;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SubAction(ActionEvent event) {
        rec.ajouterReclamation(new reclamation(DescRecTF.getText(), TypeRecTF.getText(), Integer.parseInt(idset.getText())));
        DispRecTF.setText(rec.afficherRecUser(1).toString());
    }
    
}
