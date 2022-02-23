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
import model.publication;
import util.maConnexion;

/**
 *
 * @author ASUS
 */
public  class servicepublication implements Ipublication{


//var
   //var
    Connection cnx = maConnexion.getInstance().getCnx();

    public List<publication> afficherPublication() {
        List<publication> publications = new ArrayList<>();
        
        String query = "SELECT * FROM publication";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                publications.add(new publication(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5) ));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return publications;
    }
    

    public void ajouterPublication (publication pub){
String Req = "INSERT INTO `publication`( `content_pub`,`date_pub` ,`like_nbr`, `id_user`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            
            ps.setString(1, pub.getContent_pub());   
            ps.setString(2, pub.getDate_pub());
            ps.setInt(3, pub.getLike_nbr());
            ps.setInt(4, pub.getId_user());
             ps.execute();
            System.out.println("done  : publication ajoutee avec succes");
        } catch (SQLException ex) {
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
        public void modifierpublication (publication pub){
        try{
        
       String query="UPDATE `publication` SET `content_pub`='"+pub.getContent_pub()
               +"',`date_pub`='"+pub.getDate_pub()
               +"',`like_nbr`='"+pub.getLike_nbr()
               +"',`id_user`='"+pub.getId_user()
               +"' WHERE id_pub="+pub.getId_pub();
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done. publication bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
        }


}





