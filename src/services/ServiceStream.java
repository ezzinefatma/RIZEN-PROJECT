/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Istreaming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.stream;
import util.maConnexion;

/**
 *
 * @author ford_
 */
public class ServiceStream implements Istreaming{
    
    //var
    Connection cnx = maConnexion.getInstance().getCnx();

    @Override
    public void ajouterstream(stream s) {
        String request = "INSERT INTO `stream`(`titre_stream`, `categorie`, `nbr_like`, `nbr_report`, `url`, `id_user`)"
                + " VALUES ('"+s.getTitre_stream()
                +"','"+s.getCategorie()
                +"','"+s.getNbr_like()
                +"','"+s.getNbr_report()
                +"','"+s.getUrl()
                +"','"+s.getId_user()
                +"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Done !!! stream ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    @Override
  public List<stream> afficherstream() {
        List<stream> streams = new ArrayList<>();
        
        String query = "SELECT * FROM stream";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                streams.add(new stream(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5) , rs.getString(6), rs.getInt(7)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    return streams;
    }

    @Override
  public void ajouterstream1(stream s) {
String Req = "INSERT INTO `stream`(`titre_stream`, `categorie`, `nbr_like`, `nbr_report`, `url`, `id_user`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, s.getTitre_stream());
            ps.setString(2, s.getCategorie());   
            ps.setInt(3, s.getNbr_like());
            ps.setInt(4, s.getNbr_report());
            ps.setString(5, s.getUrl());
            ps.setInt(6, s.getId_user());
             ps.execute();
            System.out.println("done  : stream ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
  
  
  
  
  
  
  
  
}
  
    @Override
    public void SupprimerParID(int id_stream){
    try{
    String query="DELETE FROM `stream` WHERE id_stream="+id_stream;
    Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done!! stream bien supprime ");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }
    
    /**
     *
     * @param s
     */
    @Override
            public void ModifierStream (stream s){
        try{
        
       String query="UPDATE `stream` SET `titre_stream`='"+s.getTitre_stream()
               +"',`categorie`='"+s.getCategorie()
               +"',`nbr_like`='"+s.getNbr_like()
               +"',`nbr_report`='"+s.getNbr_report()
               +"',`url`='"+s.getUrl()
               +"',`id_user`='"+s.getId_user()
               +"' WHERE id_stream="+s.getId_stream();
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done. stream bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
        }
    
    }
