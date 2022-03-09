/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Inews;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import model.User;
import model.news;
import util.maConnexion;
import javafx.collections.ObservableList;

/**
 *
 * @author OUSSAMA
 */
public class ServiceNews implements Inews{
      Connection cnx = maConnexion.getInstance().getCnx();
      public String recuperationEvent(User u){
             String x = null;
       String Req = "select id_event from inscription_event WHERE id_usr="+u.getId_user();   
          try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(Req);
              while (rs.next()){
         int nbr = rs.getInt(1); 
         String Req1 = "select titre_event from event where id_event ="+nbr;
           try {
               Statement stt = cnx.createStatement();
               ResultSet rss = stt.executeQuery(Req1);
           
               while (rss.next()){
                  x=rss.getString(1);                }
           }catch(SQLException ex){
   ex.printStackTrace();
   }
   }
          }catch(SQLException ex){
   ex.printStackTrace();
   }
         return x;
          
      }
      public String recuperationStream(User u){
             String x = null;
       String Req = "select stream_id from user_stream_history WHERE id_user="+u.getId_user();   
          try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(Req);
              while (rs.next()){
         int nbr = rs.getInt(1); 
         String Req1 = "select titre_stream from stream where id_stream ="+nbr;
           try {
               Statement stt = cnx.createStatement();
               ResultSet rss = stt.executeQuery(Req1);
           
               while (rss.next()){
                  x=rss.getString(1);                }
           }catch(SQLException ex){
   ex.printStackTrace();
   }
   }
          }catch(SQLException ex){
   ex.printStackTrace();
   }
         return x;
          
      }
      
      @Override
      public List<news> RechercherParTitre (String titre , String stream) 
      {  
          
          List<news> newss = new ArrayList<>();
          String query = "SELECT `titre_news`, `contenu_news`, `date_news` FROM `news` WHERE titre_news like'%"+ titre +"%'or titre_news like'%"+ stream +"%'or contenu_news like '%"+ titre +"%'or contenu_news like '%"+ stream +"%' ";
       
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
              // int  nbrRow = rs.getRow();
             
                  while (rs.next()) {   
                      
                newss.add(new news(rs.getString(1),rs.getString(2),rs.getTimestamp(3)));
            
                  }
                         
            }catch(SQLException ex) {
        }
         
              return newss;     
         }


      @Override
    public ObservableList<news> afficherNews() {
        List<news> news = new ArrayList<>();
        
        String Req = "select id_event from inscription_event WHERE id_usr=";
   String query = "SELECT * FROM news";
   try {
   Statement st = cnx.createStatement();
   ResultSet rs = st.executeQuery(query);
   
   while (rs.next()){
   news.add(new news (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4)));
   }
   }
   catch(SQLException ex){
   ex.printStackTrace();
   }
   return FXCollections.observableArrayList(news);
  
    }

      @Override
    public void ajouterNews(news n) {
       String Req = "INSERT INTO `news`(`titre_news`,`contenu_news`) VALUES (?,?)";
       try {
           PreparedStatement ps = cnx.prepareStatement(Req);
           ps.setString(1, n.getTitre_news());
           ps.setString(2, n.getContenu_news());
           ps.execute();
           System.out.println("news bien ajouter");
       } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void supprimerNews(int id) {
        try {
            String query ="DELETE FROM `news` WHERE id_news="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("news bien supprimer");
        }catch(SQLException e){
        System.out.println(e.getMessage());}
    }
      @Override
    public void modifierNews(news n){
        try {
       String query ="UPDATE `news` SET `titre_news`='"+n.getTitre_news()+"',`contenu_news`='"+n.getContenu_news()+"' WHERE id_news="+n.getId_news();
       Statement st = cnx.createStatement();
       st.executeUpdate(query);
       System.out.println("news bien modifier");
   }catch(SQLException ex){
        System.out.println(ex.getMessage());
}
    }
}
