/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.user_history;
import util.maConnexion;

/**
 *
 * @author ford_
 */
public class ServiceUserHistory {
    //var
    Connection cnx = maConnexion.getInstance().getCnx();
          

    public List<user_history> afficherhistory() {
List<user_history> history= new ArrayList<>();
        
        String query = "SELECT * FROM `user_stream_history` ";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
               history.add(new user_history(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getInt(4)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    return history;

    }

  public void Supprimer_his_ParID(int history_id) {
try{
    String query="DELETE FROM `user_stream_history` WHERE history_id="+history_id;
    Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done!! historique bien supprime ");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }    }
  
  public void Supprimer_tous() {
try{
    String query="TRUNCATE TABLE `user_stream_history`";
    Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done!! historique bien supprime ");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }    }
  
  
    
    
}
