/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ipanier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Panier;
import util.MaConnexion;

/**
 *
 * @author MSI
 */
public class ServicePanier implements Ipanier{
Connection cnx = MaConnexion.getInstance().getCnx();
    @Override
    public void ajouterpanier(Panier s) {
        String req = "insert into panier(id_prod,id_user,quantite) values(?,?,?)";

          try {
            PreparedStatement ps = cnx.prepareStatement(req);         
    
    
            ps.setInt(1, s.getId_prod());
           
            ps.setInt(2, s.getId_user());
            ps.setInt(3, s.getQuantite());

            ps.execute();
            System.out.println("2 : produit ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
  
    @Override
    public void modifierpanier(Panier s) {
     try{
        String req = "UPDATE panier SET            `id_user`='" +  +s.getId_user()
                                               
                                                   + "',`quantite`='" + s.getQuantite()
                                                   + "' where id_prod=" + s.getId_prod() ;  
          Statement ps = cnx.createStatement();
    ps.executeUpdate(req);
        System.out.println("Done. panier bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }       } 
    
    
    
    
    

    @Override
    public void supppanier(Panier s) {
     
     try (PreparedStatement ps = cnx.prepareStatement("DELETE FROM panier WHERE  id_prod = ?")
) {
    ps.setInt(1,s.getId_prod());

    if (ps.executeUpdate() > 0)
        System.out.println("stock with id_prod = "+s+" deleted successfully.");
    else
        System.out.println("Record not found.");
}       catch (SQLException ex) {
          ex.printStackTrace();        }   

    
    
    
    }

    @Override
    public List<Panier> afficherpanier() {
    List<Panier> pan = new ArrayList<>();
        
        String req = "SELECT * FROM panier";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                pan.add(new Panier(rs.getInt("id_prod"), rs.getInt(2), rs.getInt(3)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return pan; }
    
}

  
