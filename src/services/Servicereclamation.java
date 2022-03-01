/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import util.maConnexion;
import interfaces.Irec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.reclamation;
import model.ReqEnum;

/**
 *
 * @author HUNTER
 */
public class Servicereclamation implements Irec {
    
    //var 
        Connection cnx = maConnexion.getInstance().getCnx();


    @Override
    public void ajouterReclamation(reclamation r) {
     String req ="INSERT INTO `reclamation`( `type_rec`, `description_rec`, `id_user`) VALUES (?,?,?) ";
        try {
            PreparedStatement rs = cnx.prepareStatement(req);
            rs.setString(1, r.getType_rec());
            rs.setString(2, r.getDescription_rec());
            rs.setInt(3, r.getId_user());
            rs.execute();
            System.out.println("reclamation ajoutee avec succes");}
         catch (SQLException ex) 
        {ex.printStackTrace();}
        
    }

    @Override
    public List<reclamation> afficherReclamation() {
        List<reclamation> reclamation = new ArrayList<>();
        String query = "SELECT * FROM `reclamation`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())               
            {reclamation.add(new reclamation(rs.getInt(1), rs.getString(2), rs.getString(3),ReqEnum.valueOf(rs.getString(4)),rs.getTimestamp(5),rs.getInt(6)));}}
        catch (SQLException ex) 
        {ex.printStackTrace();}
            System.out.println(reclamation);
        return reclamation;    }

    @Override
    public void modifier_reclamation(reclamation r) {
        String requ ="UPDATE `reclamation` SET `type_rec`='"+r.getType_rec()+"',`description_rec`='"+r.getDescription_rec()+"',`statut_rec`= '"+r.getStatut_rec()+"' WHERE `id_user`='"+r.getId_user()+"'";
        try {
                Statement st = cnx.createStatement();
                st.executeUpdate(requ);
                System.out.println(" reclamation modifiée avec succée........ ");}
        catch (SQLException ex) 
        {ex.printStackTrace();}}
             
    @Override
    public void supresionReclamation(int r) {
    try (PreparedStatement psDel = cnx.prepareStatement("DELETE FROM `reclamation` WHERE `id_rec` = ?"))
   {psDel.setInt(1, r);
    if (psDel.executeUpdate() > 0)
        System.out.println("Record with id = "+r+" deleted successfully.");
    else
        System.out.println("Record not found.");}
    catch (SQLException ex) 
    {ex.printStackTrace();}}       
                                
    @Override
    public void modifier_admin_rec(reclamation r) {
            String requ ="UPDATE `reclamation` SET `statut_rec`= '"+r.getStatut_rec()+"' WHERE `id_user`='"+r.getId_user()+"'";
            try {
                Statement st = cnx.createStatement();
                st.executeUpdate(requ);
                System.out.println(" reclamation modifiée par l'admin avec succée........ ");}
            catch (SQLException ex) 
            {ex.printStackTrace();}}
        
    @Override
    public void modifier_user_rec(reclamation r) {
            String requ ="UPDATE `reclamation` SET `type_rec`='"+r.getType_rec()+"',`description_rec`='"+r.getDescription_rec()+"' WHERE `id_user`='"+r.getId_user()+"'";
             try {
                Statement st = cnx.createStatement();
                st.executeUpdate(requ);
                System.out.println(" reclamation modifiée par l'admin avec succée........ ");}
                catch (SQLException ex) 
                {ex.printStackTrace();}}
           
    @Override
    public void RechercherStat(ReqEnum x) {
      String queeery="SELECT * FROM `reclamation` WHERE statut_rec ='"+x+"'"; 
        List<reclamation> reclamation = new ArrayList<>();
        try {
            Statement stt = cnx.createStatement();
            ResultSet rs = stt.executeQuery(queeery);
                while (rs.next()) {                
                reclamation.add(new reclamation(rs.getInt(1), rs.getString(2), rs.getString(3),ReqEnum.valueOf(rs.getString(4)),rs.getTimestamp(5),rs.getInt(6)));}
                System.out.println(reclamation);}
        catch (SQLException ex) 
         {ex.printStackTrace();}}   

     
             
}
