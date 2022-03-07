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
import model.news;
import util.maConnexion;

/**
 *
 * @author OUSSAMA
 */
public class ServiceNews implements Inews{
      Connection cnx = maConnexion.getInstance().getCnx();
      
    /**
     *
     * @return
     */
    public List<news> afficherNews() {
        List<news> news = new ArrayList<>();
   String query = "SELECT * FROM news";
   try {
   Statement st = cnx.createStatement();
   ResultSet rs = st.executeQuery(query);
   while (rs.next()){
   news.add(new news (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
   }
   }
   catch(SQLException ex){
   ex.printStackTrace();
   }
   return news;
    }

    /**
     *
     * @param n
     */
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
