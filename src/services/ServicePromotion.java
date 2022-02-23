/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ipromotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Promotion;
import util.maConnexion;

/**
 *
 * @author MSI
 */
public class ServicePromotion  implements Ipromotion {
Connection cnx = maConnexion.getInstance().getCnx();

    @Override
    public void ajouterpromotion(Promotion p) {
       String req = "insert into promotion(id_prom,id_prod,date_debut_prom,date_fin_prom,taux_reduction) values(?,?,?,?,?)";

          try {
            PreparedStatement ps = cnx.prepareStatement(req);         
    
    
            ps.setInt(1, p.getId_prom());
             ps.setInt(2, p.getId_prod());
            ps.setString(3, p.getDate_debut_prom());
            ps.setString(4,p.getDate_fin_prom());
            ps.setInt(5, p.getTaux_reduction());
             

            ps.execute();
            System.out.println("2 : produit ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
  }

    @Override
    public List<Promotion> afficherpromotion() {
        List<Promotion> prom = new ArrayList<>();
        
        String req = "SELECT * FROM promotion";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                prom.add(new Promotion(rs.getInt("id_prom"),rs.getInt("id_prod"), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return prom; }
    @Override
    public void modifierpromotion(Promotion p) {
         try{
        String req = "UPDATE promotion SET   `id_prod`='" +p.getId_prod()
                                             + "',`date_debut_prom`='" +p.getDate_debut_prom()
                                              + "',`date_fin_prom`='" + p.getDate_fin_prom()
                                            + "',`taux_reduction`='" +  +p.getTaux_reduction()
                                               
                                                   + "' where id_prom=" + p.getId_prom() ;  
          Statement ps = cnx.createStatement();
    ps.executeUpdate(req);
        System.out.println("Done. promotion bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }       }

    @Override
    public void supppromotion(Promotion p) {
        try (PreparedStatement ps = cnx.prepareStatement("DELETE FROM promotion WHERE  id_prom = ?")
) {
    ps.setInt(1,p.getId_prom());

    if (ps.executeUpdate() > 0)
        System.out.println("promotion with id_prom = "+p+" deleted successfully.");
    else
        System.out.println("Record not found.");
}       catch (SQLException ex) {
          ex.printStackTrace();        }   

}}