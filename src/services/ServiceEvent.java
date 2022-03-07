/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.maConnexion;
import interfaces.Ievent;
import java.util.Date;
import model.event;

/**
 *
 * @author OUSSAMA
 */
public class ServiceEvent implements Ievent{
    
   Connection cnx = maConnexion.getInstance().getCnx();
   
   @Override
   public List<event> afficherEvent() {
   List<event> event = new ArrayList<>();
   String query = "SELECT * FROM event";
   try {
   Statement st = cnx.createStatement();
   ResultSet rs = st.executeQuery(query);
   while (rs.next()){
   event.add(new event (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
   }
   }
   catch(SQLException ex){
   ex.printStackTrace();
   }
   return event;
   }
   @Override
   public void ajouterEvent(event e) {
       
       String Req = "INSERT INTO `event`(`titre_event`, `date_debut`, `date_fin`, `image_event`, `description_event`, `capacite`, `type_event`) VALUES (?,?,?,?,?,?,?)";
       try {
       PreparedStatement ps = cnx.prepareStatement(Req);
       ps.setString(1, e.getTitre_event());
       ps.setString(2, e.getDate_debut());
       ps.setString(3, e.getDate_fin());
       ps.setString(4, e.getImage());
       ps.setString(5, e.getDescription());
       ps.setInt(6, e.getCapacite());
       ps.setString(7, e.getType());
       ps.execute();
           System.out.println("2 : Event ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   }

    /**
     *
     * @param id
     */
    @Override
   public void supprimerEvent(int id){
      try {
          String query ="DELETE FROM `event` WHERE id_event="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Event bien supprimer");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}
   }

    /**
     *
     * @param e
     */
    @Override
   public void modifierEvent(event e)
   {
       try {
       String query ="UPDATE `event` SET `titre_event`='"+e.getTitre_event()
               +"',`date_debut`='"+e.getDate_debut()
               +"',`date_fin`='"+e.getDate_fin()
               +"',`image_event`='"+e.getImage() 
               +"',`description_event`='"+e.getDescription()
               +"',`capacite`='"+e.getCapacite()
               +"',`type_event`='"+e.getType()
            +"' WHERE id_event="+e.getId_event();    
       Statement st = cnx.createStatement();
       st.executeUpdate(query);
       System.out.println("event bien modifier");
   }catch(SQLException ex){
        System.out.println(ex.getMessage());
}
   }
}
