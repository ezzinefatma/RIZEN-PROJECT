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
        
        //String query = "SELECT user_stream_history.id_user, user_stream_history.stream_id, user_stream_history.date, user.username, stream.titre_stream, stream.url FROM user_stream_history INNER JOIN user ON user_stream_history.id_user=user.id_user inner JOIN stream ON user_stream_history.stream_id=stream.id_stream; ";
        String query ="SELECT   user.username,stream.titre_stream,stream.url,user_stream_history.date FROM user_stream_history INNER JOIN user ON user_stream_history.id_user=user.id_user inner JOIN stream ON user_stream_history.stream_id=stream.id_stream";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
               history.add(new user_history(rs.getString(1), rs.getString(1),rs.getString(1),rs.getTimestamp(4)));
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
