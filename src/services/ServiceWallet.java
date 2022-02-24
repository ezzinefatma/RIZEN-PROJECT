/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import util.maConnexion;
import interfaces.IWallet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Coins_history;
import model.wallet;

/**
 *
 * @author HUNTER
 */
public class ServiceWallet implements IWallet{
    //connexion db
    Connection cnx = maConnexion.getInstance().getCnx();
 //CRUD   
    //create 
    @Override
    public void ajouterwallet(wallet x) {
        String req ="INSERT INTO `wallet`(`card_number`, `csc`, `expire`, `id_user`) VALUES (?,?,?,?)";
        try {
            PreparedStatement rs = cnx.prepareStatement(req);
            rs.setString(1, x.getCard_number());
            rs.setInt(2, x.getCsc());
            rs.setString(3, x.getExpire());
            rs.setInt(4, x.getId_user());
            rs.execute();
            System.out.println("walet ajouter avec succée...\nvous pouvez maintenant achetez 1 de nos paquet : ");
            System.out.println("10.000 DT = 100 Coin\n100.000 DT = 1000 Coin\n300.000 DT = 5000 Coin");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }     }
    //read 
    @Override
    public List<wallet> afficherwallet() {
        List<wallet> wallets = new ArrayList<>();
        
        String query = "SELECT * FROM wallet";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                wallets.add(new wallet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getInt(6)));
                
            }
            System.out.println(wallets);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return wallets;    }
    //update
    @Override
    public void modifier_wallet(wallet x) {
        String requtt ="UPDATE `wallet` SET `solde`='"+x.getSolde()+"',`card_number`='"+x.getCard_number()+"',`csc`='"+x.getCsc()+"',`expire`='"+x.getExpire()+"'  WHERE `id_user` = '"+x.getId_user()+"';";
        try {
        Statement st = cnx.createStatement();
        st.executeUpdate(requtt);
        System.out.println("wallet modifiée avec succée ........ ");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }    }
    //delete
    @Override
    public void supresionwallet(int x) {
       try (PreparedStatement psDel = cnx.prepareStatement("DELETE FROM `wallet` WHERE id_wallet = ?")
) {
    psDel.setInt(1, x);

    if (psDel.executeUpdate() > 0)
        System.out.println("wallet with id = "+x+" deleted successfully.");
    else
        System.out.println("wallet not found.");
}       catch (SQLException ex) {
          ex.printStackTrace();        
}
    }
     

// metier et services 
     //achat coins
     public int achatSolde(wallet x , int price )
     { 
       if (price == 10000){
           int old = x.getSolde();
             x.setSolde(old+100);
        try{
            String achat ="UPDATE `wallet` SET `solde`='"+x.getSolde()+"'WHERE `id_user` = '"+x.getId_user()+"'";
            Statement st = cnx.createStatement();
            st.executeUpdate(achat);
            System.out.println("achat du 100 Coins a été effectué avec succé...........\nVotre solde est :" +x.getSolde()); 
            /**********************************************************/
            String req ="INSERT INTO `historique_coins`( `id_user`, `montant_achat`) VALUES (?,?)";
            PreparedStatement rs = cnx.prepareStatement(req);
            rs.setInt(1, x.getId_user());
            rs.setInt(2, x.getSolde());
            rs.execute();
        }
        catch(SQLException ex) {
            ex.printStackTrace();}
        }
       
      else if (price == 100000){
           int old = x.getSolde();
            x.setSolde(old+1000);
        try{
            String achat ="UPDATE `wallet` SET `solde`='"+x.getSolde()+"'WHERE `id_user` = '"+x.getId_user()+"'";
            Statement st = cnx.createStatement();
            st.executeUpdate(achat);
            System.out.println("achat du 1000 Coins a été effectué avec succé...........\nVotre solde est :" +x.getSolde());
                    /**********************************************************/
            String req ="INSERT INTO `historique_coins`( `id_user`, `montant_achat`) VALUES (?,?)";
            PreparedStatement rs = cnx.prepareStatement(req);
            rs.setInt(1, x.getId_user());
            rs.setInt(2, x.getSolde());
            rs.execute();}
        catch(SQLException ex) {
            ex.printStackTrace();}
         }
       
      else if (price ==300000){
           int old = x.getSolde();
             x.setSolde(old+5000);
        try{
            String achat ="UPDATE `wallet` SET `solde`='"+x.getSolde()+"'WHERE `id_user` = '"+x.getId_user()+"'";
            Statement st = cnx.createStatement();
            st.executeUpdate(achat);
            System.out.println("achat du 5000 Coins a été effectué avec succé...........\nVotre solde est :" +x.getSolde());
                    /**********************************************************/
            String req ="INSERT INTO `historique_coins`( `id_user`, `montant_achat`) VALUES (?,?)";
            PreparedStatement rs = cnx.prepareStatement(req);
            rs.setInt(1, x.getId_user());
            rs.setInt(2, x.getSolde());
            rs.execute();}
        catch(SQLException ex) {
            ex.printStackTrace();}
         }
       
       else 
          System.out.println("plz check ur wallet..........."); 
       return x.getSolde(); }
 
     //affichage unitaire
         public List<wallet> afficher_wallet_User(wallet x) {
        List<wallet> wallets = new ArrayList<>();
        
        String query = "SELECT * FROM `wallet` where id_user = '"+x.getId_user()+"' ";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                wallets.add(new wallet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getInt(6)));
                System.out.println(wallets);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return wallets;    }
         
     //recherche
         public  void testID(int x){
        String queeery="SELECT * FROM `wallet` WHERE id_wallet ='"+x+"'"; 
        try{
           Statement st = cnx.createStatement();
            ResultSet rss = st.executeQuery(queeery);
            rss.last();
            int nbrRow = rss.getRow();
             if(nbrRow!=0){
               System.out.println("Produit trouve");
           }else{
                System.out.println("Produit non trouve");
               
           }
        }
        catch (SQLException ex) {
          ex.printStackTrace();        
}
        
    }
         
             public List<wallet> RechercherrWallet(int x) {
        List<wallet> wallets = new ArrayList<>();
        
        String query = "SELECT * FROM `wallet` WHERE id_wallet ='"+x+"'";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                wallets.add(new wallet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getInt(6)));
                
            }
            System.out.println(wallets);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return wallets;    }
    
}
