/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Iuser_publication_history;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.publication;
import util.maConnexion;
/**
 *
 * @author ASUS
 */
/*
public class ServiceUser_publication_history implements Iuser_publication_history{

  
    @Override
    public void ajouterPublication(publication pub) {
        public void ajouterPublication (publication pub){
String Req = "INSERT INTO `publication`( `content_pub` ) VALUES (?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            
                       ps.setString(1, pub.getContent_pub());   
                      
            ps.execute();
            
                  System.out.println("done  : publication ajoutee avec succes");
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }

    @Override
    public void SupprimerParID(int id_pub) {
     try{
          String query="DELETE FROM `publication` WHERE id_pub="+id_pub;
          Statement st = cnx.createStatement();
             st.executeUpdate(query);
             
          System.out.println("Done. publication bien supprime ");
    }catch(SQLException e){
        
          System.out.println(e.getMessage());
    
    }
    
    
    }

    @Override
    public List<publication> RechercherParId(int id) {
      List<publication> id_pub = new ArrayList<>();
          String query = "SELECT publication.id_pub,publication.content_pub, publication.date_pub, publication.like_nbr, user.username FROM publication INNER JOIN user ON publication.id_user=user.id_user WHERE  id_pub="+id;
       
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
              // int  nbrRow = rs.getRow();
             
                  while (rs.next()) {   
                      
                id_pub.add(new publication(rs.getInt(1),rs.getString(2), rs.getTimestamp(3), rs.getInt(4), rs.getString(5) ));
            
                  }
                   
            }catch(SQLException ex) {
                
        }
         
              return id_pub;
     
  
              
                
}
    
}
*/

        
        /*

public void afficher_un_stream(int id) {
        
        
        String query = "SELECT * FROM stream WHERE id_stream="+id;
         
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
            System.out.println("titre de stream=" + rs.getString(2));
            System.out.println("categorie=" + rs.getString(3));
            System.out.println("nbr like =" + rs.getInt(4));
            System.out.println("report nbr =" + rs.getInt(5));
            System.out.println("url=" + rs.getString(6));
            System.out.println("user id=" + rs.getInt(7));
            
            
       
         }
            String Req = "INSERT INTO user_publication_history`(id_pub`, content_pub,like_nbr, streamer_id) SELECT id_user,`id_stream`,`id_user` from stream where id_stream="+id ;
                    PreparedStatement ps = cnx.prepareStatement(Req);
                    ps.execute();
           /* 
             ps.setInt(1,rs.);
            ps.setInt(2,rs.getInt(3));   
            ps.setInt(3, rs.getInt(4));
              */
        /*
            System.out.println("done  : historique ajoutee avec succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
   
       
        
        
    }
*/