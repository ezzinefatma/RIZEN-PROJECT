/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Ichat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.chat;
import util.MaConnexion;

/**
 *
 * @author ford_
 */
public class ServiceChat implements Ichat{
     //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public void ajouterchat(chat c) {
        String request = "INSERT INTO `chat`(`content`, `id_user`, `id_stream`, `report_nbr`)"
                + " VALUES ('"+c.getContent()
                +"','"+c.getId_user()
                +"','"+c.getId_stream()
                +"','"+c.getReport_nbr()
                +"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Done !!! chat ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }

    @Override
    public void ajouterchat1(chat c) {
          String Req = "INSERT INTO `chat`(`content`, `id_user`, `id_stream`, `report_nbr`) VALUES (?,?,?,?)";
        try {
            PreparedStatement pc = cnx.prepareStatement(Req);
            pc.setString(1,c.getContent());
            pc.setInt(2,c.getId_user());   
            pc.setInt(3,c.getId_stream());
            pc.setInt(4,c.getReport_nbr());
             pc.execute();
            System.out.println("done  : chat ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<chat> afficherchat() {
List<chat> chats = new ArrayList<>();
        
        String query = "SELECT * FROM chat";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                chats.add(new chat(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    return chats;

    }

    @Override
    public void SupprimerParID_chat(int id) {
try{
    String query="DELETE FROM `chat` WHERE id_comment="+id;
    Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done!! comment bien supprime ");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }    }

    @Override
    public void Modifierchat(chat c) {
try{
        
       String query="UPDATE `chat` SET `content`='"+c.getContent()          
               +"',`id_user`='"+c.getId_user()
               +"',`id_stream`='"+c.getId_stream()
               +"',`report_nbr`='"+c.getReport_nbr()
               +"' WHERE id_comment="+c.getId_comment();
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done. chat bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
        }
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
