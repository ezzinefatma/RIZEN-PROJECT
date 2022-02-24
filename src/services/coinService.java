/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Coins_history;
import model.User;
import model.wallet;
import util.maConnexion;

/**
 *
 * @author HUNTER
 */
public class coinService {
    

    //connexion db
    Connection cnx = maConnexion.getInstance().getCnx();
 //CRUD 
    
      public void affichehystory() {
        List<Coins_history> coins = new ArrayList<>();
        
        String query = "SELECT * FROM historique_coins";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                coins.add(new Coins_history(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getInt(5),rs.getTimestamp(6)));
                
            }
            System.out.println(coins);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        }  
        public void supresionHystory(int x) {
       try (PreparedStatement psDel = cnx.prepareStatement("DELETE FROM `historique_coins` WHERE id_user =?")
) {
    psDel.setInt(1, x);

    if (psDel.executeUpdate() > 0)
        System.out.println("Historique du l'ID = "+x+" est supprimé avec succée............");
    else
        System.out.println("Utilisateur n'existe pas.............");
}       catch (SQLException ex) {
          ex.printStackTrace();        
}
    }
        
              public void filterhystory(int x) {
        List<Coins_history> coins = new ArrayList<>();
        
        String query = "SELECT * FROM historique_coins where id_user ='"+x+"'";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                coins.add(new Coins_history(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getInt(5),rs.getTimestamp(6)));
                
            }
            System.out.println(coins);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        } 
}