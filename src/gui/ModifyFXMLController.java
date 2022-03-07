/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Irec;
import java.net.URL;
import java.sql.*;
import java.util.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.*;
import model.ReqEnum;
import model.reclamation;
import services.Servicereclamation;
import util.maConnexion;

/**
 * FXML Controller class
 *
 * @author HUNTER
 */
public class ModifyFXMLController implements Initializable {
    Irec sp= new Servicereclamation();
    Connection cnx = maConnexion.getInstance().getCnx();
     
    @FXML
    private TableView<reclamation> tabrec;
    @FXML
    private TableColumn<reclamation, Integer> idRec;
    @FXML
    private TableColumn<reclamation, String> typerec;
    @FXML
    private TableColumn<reclamation, String> descRec;
    @FXML
    private TableColumn<reclamation, String> StatRec;
    @FXML
    private TableColumn<reclamation, String> Daterec;
    @FXML
    private TableColumn<reclamation, Integer> Iduser;
    @FXML
    private TextField IDRECSEARCH;
    @FXML
    private TextArea DESCAFFREC;
    @FXML
    private TextField STTSEARCHREC;
    @FXML
    private TextField SearchREC;
    @FXML
    private TextField TypeSEARCH;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    ObservableList<reclamation> listprod = FXCollections.observableArrayList();
  
    @FXML
    private void afichier() {
    tabrec.getItems().clear();
     String req = "SELECT * FROM reclamation";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next())                 
            {listprod.add(new reclamation(rs.getInt(1), rs.getString(2), rs.getString(3),ReqEnum.valueOf(rs.getString(4)),rs.getTimestamp(5),rs.getInt(6)));}}
             catch (SQLException ex) 
             {ex.printStackTrace();}
            idRec.setCellValueFactory(new PropertyValueFactory<reclamation, Integer>("id_rec"));
            typerec.setCellValueFactory(new PropertyValueFactory<reclamation, String>("type_rec"));
            descRec.setCellValueFactory(new PropertyValueFactory<reclamation, String>("description_rec"));
            StatRec.setCellValueFactory(new PropertyValueFactory<reclamation, String>("statut_rec"));
            Daterec.setCellValueFactory(new PropertyValueFactory<reclamation,String>("date_rec"));
            Iduser.setCellValueFactory(new PropertyValueFactory<reclamation, Integer>("id_user"));
            tabrec.setItems( listprod);

    }

    @FXML
    private void UPDATE(ActionEvent event) {
        String catt=DESCAFFREC.getText();
        String libb=STTSEARCHREC.getText();
        String marc=TypeSEARCH.getText();
        String pri=IDRECSEARCH.getText();
       
         if (!catt.equals("")&&!libb.equals("")&&!marc.equals("")&&!pri.equals("")) {
             
             sp.modifierUser_rec(new reclamation(marc, catt,Integer.parseInt(pri)));
                     
            DESCAFFREC.setText("");
            STTSEARCHREC.setText("");
            TypeSEARCH.setText("");
            IDRECSEARCH.setText("");
           Alert alert = new Alert(AlertType.CONFIRMATION," Reclamation Updated successfully", javafx.scene.control.ButtonType.OK);
          alert.showAndWait();
            afichier();
        } else {
           Alert alert = new Alert(AlertType.ERROR ,"Update failed........"+ javafx.scene.control.ButtonType.OK);
          alert.showAndWait();
        }
    }

    @FXML
    private void DELETE(ActionEvent event) {
        
        String catt=DESCAFFREC.getText();
        String libb=STTSEARCHREC.getText();
        String marc=TypeSEARCH.getText();
        String pri=IDRECSEARCH.getText();
             
         if (!catt.equals("")&&!libb.equals("")&&!marc.equals("")&&!pri.equals("")) 
           {sp.supresionReclamation(Integer.parseInt(IDRECSEARCH.getText()));
            DESCAFFREC.setText("");
            STTSEARCHREC.setText("");
            TypeSEARCH.setText("");
            IDRECSEARCH.setText("");
            Alert alert = new Alert(AlertType.CONFIRMATION," Reclamation deleted successfully", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();
            afichier();}
         else {
           Alert alert = new Alert(AlertType.ERROR ,"Delete failed ..... "+ javafx.scene.control.ButtonType.OK);
          alert.showAndWait();
        }
    }

    @FXML
    private void SEARCH(ActionEvent event) {
       Connection cnx = maConnexion.getInstance().getCnx();
       String req = "SELECT * FROM reclamation where  id_rec ='"+SearchREC.getText()+"'";
       int m=0;
       try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {                
            DESCAFFREC.setText(rs.getString("description_rec"));
             STTSEARCHREC.setText(rs.getString("statut_rec"));
              TypeSEARCH.setText(rs.getString("type_rec"));
               IDRECSEARCH.setText(rs.getString("id_rec"));
                  m=1;}
        if (m == 0) 
       {Alert alert = new Alert(AlertType.ERROR ,"Aucune reclamation avec id ="+SearchREC.getText()+"", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();}}
         catch (SQLException ex) 
        {ex.printStackTrace();}  
    }
  








}
      
    

