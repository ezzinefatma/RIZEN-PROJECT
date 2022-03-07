/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Icommentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.commentaire;
import util.maConnexion;
import model.User;
/**
 *
 * @author ASUS
 */
public class servicecommentaire implements Icommentaire {
 //var
    Connection cnx = maConnexion.getInstance().getCnx();

    //afficher

    /**
     *
     * @return
     */

    public List<commentaire> afficherCommentaire() {
        List<commentaire> commentaires = new ArrayList<>();
        
        String query = "SELECT commentaire.content_com, commentaire.date_com , user.username FROM commentaire INNER JOIN user ON commentaire.id_user=user.id_user";
 //"SELECT  publication.content_pub, publication.date_pub , publication.like_nbr ,user.username FROM publication INNER JOIN user ON publication.id_user=user.id_user GROUP BY like_nbr ORDER BY like_nbr DESC  limit 5";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                commentaires.add(new commentaire( rs.getString(1), rs.getTimestamp(2), rs.getString(3)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return commentaires;
    }    
public void ajouterCommentaire(commentaire com) {
String Req = "INSERT INTO `commentaire`( `content_com`, id_user ) VALUES (?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            
                       ps.setString(1, com.getContent_com());   
                      ps.setInt(2, com.getId_user());
            ps.execute();
            
                  System.out.println("done  : commentaire ajoutee avec succes");
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }

public void SupprimerParID(int id_com){
    try{
    String query="DELETE FROM `commentaire` WHERE id_com="+id_com;
    Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done. commentaire bien supprime ");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }
}

    /**
     *
     * @param com
     */
    @Override
    public void modifiercommentaire (commentaire com ){
        try{
        
       String query="UPDATE `commentaire` SET `content_com`='"+com.getContent_com()
              // +"',`date_com`='"+com.getDate_com()
               //+"',`id_user`='"+com.getId_user()
               +"' WHERE id_com="+com.getId_com();
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done. commentaire bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
        }






}
