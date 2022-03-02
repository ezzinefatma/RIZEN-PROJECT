/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Icommentaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.commentaire;
import util.MaConnexion;

/**
 *
 * @author ASUS
 */
public class servicecommentaire implements Icommentaire {
 //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    //afficher

    public List<commentaire> afficherCommentaire() {
        List<commentaire> commentaires = new ArrayList<>();
        
        String query = "SELECT * FROM commentaire";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                commentaires.add(new commentaire(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return commentaires;
    }    
public void ajouterCommentaire(commentaire com) {
String request = "INSERT INTO `commentaire`(`content_com`, `date_com`, `id_user`) VALUES ('"+com.getContent_com()+"',"+com.getDate_com()+",'"+com.getId_user()+"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("commentaire ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

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

        public void modifiercommentaire (commentaire com ){
        try{
        
       String query="UPDATE `commentaire` SET `content_com`='"+com.getContent_com()
               +"',`date_com`='"+com.getDate_com()
               +"',`id_user`='"+com.getId_user()
               +"' WHERE id_com="+com.getId_com();
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done. commentaire bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
        }






}
