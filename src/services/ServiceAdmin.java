/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Iadmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import util.maConnexion;

/**
 *
 * @author Fatma
 */
public class ServiceAdmin implements Iadmin {
    
     Connection cnx = maConnexion.getInstance().getCnx();

    @Override
    public boolean Banned(User u) {
         if(u.getStatut()==1) {
             System.out.println("User Banned");
             return true;
         }
         else {
        System.out.println("User not Banned");
        return false;
         }
    }
 @Override
    public void ajouterUser(User u) {
            String Req = "INSERT INTO `user`(`nom_user`, `prenom_user`, `age`, `numero_tel`, `email`, `adresse`, `photo`)"
                    + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1,u.getNom_user());
            ps.setString(2, u.getPrenom_user());
            ps.setInt(3, u.getAge());
            ps.setInt(4, u.getNumero_tel());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getAdresse());
            ps.setString(7, u.getPhoto());
            ps.execute();
            System.out.println("Utlisateur ajouté avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<User> afficherUsers() {
         List<User> users = new ArrayList<>();
        
        String query = "SELECT * FROM user";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
                rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return users;
    }

    @Override
    public void modifierUser(User u) {
       try {
            if (u.getNom_user()!= null) {
              String  query="UPDATE user SET `nom_user`=?,`prenom_user`=?,`age`=? ,`numero_tel`=?,`email`=?,`adresse`=?,`photo`=? WHERE `id_user`=?";
                PreparedStatement pstm = cnx.prepareStatement(query);
                pstm.setInt(8,u.getId_user());
                pstm.setString(1,u.getNom_user());
                pstm.setString(2, u.getPrenom_user());
                pstm.setInt(3, u.getAge());
                pstm.setInt(4, u.getNumero_tel());
                pstm.setString(5, u.getEmail());
                pstm.setString(6, u.getAdresse());
                pstm.setString(7, u.getPhoto());
                int i = pstm.executeUpdate();
                System.out.println(i + " User Updated Successfully");
            }}
            
            catch (SQLException ex) {
                        System.out.println(ex.getMessage());
            }
    }
    
    
}
