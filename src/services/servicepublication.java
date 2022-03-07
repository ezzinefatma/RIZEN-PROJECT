/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Ipublication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import model.User;
import model.publication;
import util.maConnexion;

/**
 *
 * @author Nassef
 */
public  class servicepublication implements Ipublication{


//var
   //var
    Connection cnx = maConnexion.getInstance().getCnx();

    
    
    
    @Override
    public List<publication> afficherPublication() {
     List<publication> publications = new ArrayList<>();
        
        String query = "SELECT  publication.content_pub, publication.date_pub, publication.like_nbr, user.username FROM publication INNER JOIN user ON publication.id_user=user.id_user";
             //String query = " SELECT * FROM stream ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {    
                
              publications.add(new publication( rs.getString(1), rs.getTimestamp(2) , rs.getInt(3) , rs.getString(4)));
              
              
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    return publications;
    }
    
    

    @Override
    public void ajouterPublication (publication pub){
String Req = "INSERT INTO `publication`( `content_pub`,Like_nbr,id_user) VALUES (?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
    
            ps.setString(1, pub.getContent_pub());   
            //ps.setString(2, pub.getDate_pub());
            ps.setInt(2, pub.getLike_nbr());
            ps.setInt(3, pub.getId_user());
            ps.execute();
            
                  System.out.println("done  : publication ajoutee avec succes");
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    @Override
    public void SupprimerParID(int id_pub){
    try{
          String query="DELETE FROM `publication` WHERE id_pub="+id_pub;
          Statement st = cnx.createStatement();
             st.executeUpdate(query);
             
          System.out.println("Done. publication bien supprime ");
    }catch(SQLException e){
        
          System.out.println(e.getMessage());
    
    }
    
    
    };
    @Override
        public void modifierpublication (publication pub,int id){
        try{
        
       String query="UPDATE `publication` SET `content_pub`='"+pub.getContent_pub()
              // +"',`date_pub`='"+pub.getDate_pub()
             //  +"',`like_nbr`='"+pub.getLike_nbr()
              // +"',`id_user`='"+pub.getId_user()
               +"' WHERE id_pub="+id;
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done. publication bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
        }


     


    @Override
      public List<publication> PublicationSuperieur() {
        List<publication> publications = new ArrayList<>();
       String query = "SELECT  publication.content_pub, publication.date_pub , publication.like_nbr ,user.username FROM publication INNER JOIN user ON publication.id_user=user.id_user GROUP BY like_nbr ORDER BY like_nbr DESC  limit 5";
       
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                publications.add(new publication( rs.getString(1), rs.getTimestamp(2) , rs.getInt(3), rs.getString(4) ));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       
        return publications;
    }
    
  

    @Override
    public List<publication> RechercherParId(int id) {
       
          
          List<publication> id_pub = new ArrayList<>();
          String query = "SELECT publication.id_pub,publication.content_pub, publication.date_pub, publication.like_nbr, user.username FROM publication INNER JOIN user ON publication.id_user=user.id_user WHERE  id_pub="+id;
        //SELECT  publication.content_pub, publication.date_pub, publication.like_nbr, user.username FROM publication INNER JOIN user ON publication.id_user=user.id_user";
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

    @Override
    public List<publication> RechercherParcontent(String content_pub) {
  List<publication> publications = new ArrayList<>();
          String query = "SELECT publication.id_pub,publication.content_pub, publication.date_pub, publication.like_nbr, user.username FROM publication INNER JOIN user ON publication.id_user=user.id_user WHERE content_pub like'%"+ content_pub +"%'";
        
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
              // int  nbrRow = rs.getRow();
             
                  while (rs.next()) {   
                      
                publications.add(new publication(rs.getInt(1),rs.getString(2), rs.getTimestamp(3), rs.getInt(4), rs.getString(5)));
            
                  }
                         
            }catch(SQLException ex) {
        }
         
              return publications;        }

   
    
      
}



