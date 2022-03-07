/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IcoinGame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.CoinsGame;
import model.EnumCoins;
import static model.EnumCoins.coins;
import static model.EnumCoins.remise;
import model.wallet;
import util.maConnexion;

/**
 *
 * @author HUNTER
 */
public class ServiceGameCoins implements IcoinGame  {
    
     //connexion db
    Connection cnx = maConnexion.getInstance().getCnx();
    //ajout 
    
    @Override
        public void ajouter(CoinsGame x) {
        String req ="INSERT INTO `icoingame`(`id_user`, `winn`, `value_win`, `money_waste`) VALUES (?,?,?,?)";
        try {
            PreparedStatement rs = cnx.prepareStatement(req);
            rs.setInt(1, x.getId_user());
            rs.setString(2,x.getWinn().name());
            rs.setInt(3, x.getValue_win());
            rs.setInt(4, x.getMoney_waste());
            rs.execute();}
        catch (SQLException ex) 
        {ex.printStackTrace();}}
               
    //affichage
    @Override
        public List<CoinsGame> afficherRemise() {
        List<CoinsGame> history = new ArrayList<>();
            String query = "SELECT * FROM `icoingame` where winn = 'remise'";
            try {Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())                 
            {history.add(new CoinsGame(rs.getInt(1),rs.getInt(2), EnumCoins.valueOf(rs.getString(3)), rs.getInt(4), rs.getInt(5),rs.getTimestamp(6)));}
            System.out.println(history);}
            catch (SQLException ex) 
            {ex.printStackTrace();}
            return history;}
        
    @Override
        public List<CoinsGame> afficherLigne(int x) {
        List<CoinsGame> history = new ArrayList<>();
            String query = "SELECT * FROM `icoingame` where idGame ="+x;
            try {Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())                 
            {history.add(new CoinsGame(rs.getInt(1),rs.getInt(2), EnumCoins.valueOf(rs.getString(3)), rs.getInt(4), rs.getInt(5),rs.getTimestamp(6)));}
            System.out.println(history);}
            catch (SQLException ex) 
            {ex.printStackTrace();}
            return history;}
        
    @Override
        public List<CoinsGame> afficher() {
        List<CoinsGame> history = new ArrayList<>();
            String query = "SELECT user.id_user,user.username,user.email,user.numero_tel,icoingame.idGame,icoingame.winn,icoingame.value_win,icoingame.money_waste,icoingame.date_remise from `icoingame` join user on icoingame.id_user=user.id_user;";
    try {Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())                 
            {history.add(new CoinsGame(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),EnumCoins.valueOf(rs.getString(6)), rs.getInt(7), rs.getInt(8),rs.getTimestamp(9)));}           

            System.out.println(history);}
            catch (SQLException ex) 
            {ex.printStackTrace();}
            return history;}
    
    //suppresion
    @Override
        public void supresionParLigne(int x) {
        try (PreparedStatement psDel = cnx.prepareStatement("DELETE FROM `icoingame` WHERE idGame = ?"))
        { psDel.setInt(1, x);
        if (psDel.executeUpdate() > 0)
        System.out.println("La ligne numero "+x+" est supprimé avec sucsée.....");
        else
        System.out.println("ligne non trouvable");}
        catch (SQLException ex) 
        {ex.printStackTrace();}}        

    //modify
        
    @Override
        public void modifier_CG(CoinsGame x) {
        String requtt ="UPDATE `icoingame` SET `winn`='"+x.getWinn()+"',`value_win`='"+x.getValue_win()+"',`money_waste` ='"+x.getMoney_waste()+"' where idGame ='"+x.getIdGame()+"'";
        try {Statement st = cnx.createStatement();
        st.executeUpdate(requtt);
        System.out.println(" modification effectuée avec succée ........ ");}
        catch (SQLException ex) 
        {ex.printStackTrace();}}
            
    //game lines
   @Override
     public void Rolette(wallet x,int z) throws SQLException
     {if (x.getSolde() > 0 && x.getSolde()>=z)
        {
         x.setSolde(x.getSolde()-z);
         String cost ="UPDATE `wallet` SET `solde`='"+x.getSolde()+"'WHERE `id_user` = '"+x.getId_user()+"'";
         Statement st = cnx.createStatement();
         st.executeUpdate(cost);
         st.executeUpdate(cost);
         Random  rand = new Random();
         int marge = 11;
         int winner = rand.nextInt(marge); 
         System.out.println("La roulette tourne... ... et s'arrête sur le numéro "+winner);

        /*******************************winning********************************/
        
        if (winner == z && z>0 )
          {
                      Random  randwin = new Random();
                      int margewin = 3;
                      int randwinn = randwin.nextInt(margewin); 
        /**********************************************************************/
                           if (randwinn == 0)
                              { int somm = x.getSolde()+(winner*z);
                                x.setSolde(somm);
                                String win ="UPDATE `wallet` SET `solde`='"+somm+"'WHERE `id_user` = '"+x.getId_user()+"'";
                                Statement winn = cnx.createStatement();
                                st.executeUpdate(win);
                                st.executeUpdate(win);
                                System.out.println("Félicitation.... vous aver ganier : "+(winner*z)+" Coins");
                                String req ="INSERT INTO `icoingame`(`id_user`, `winn`, `value_win`, `money_waste`) VALUES (?,?,?,?)";
                                PreparedStatement rs = cnx.prepareStatement(req);
                                rs.setInt(1, x.getId_user());
                                rs.setString(2,"coins");
                                rs.setInt(3, (winner*z));
                                rs.setInt(4,z);
                                rs.execute();  }
        
        /**********************************************************************/
        
                           else if (randwinn == 1 )
               
                              {System.out.println("Félicitation.... vous avez gagnier une reduction de "+15+"% sur votre premier achat!!!!........ ");/***********************************************************/
                               String cab ="INSERT INTO `icoingame`( `id_user`, `winn`,`value_win`,`money_waste`) VALUES (?,?,?,?)";
                               PreparedStatement cb = cnx.prepareStatement(cab);
                               cb.setInt(1, x.getId_user());
                               cb.setString(2,"remise");
                               cb.setInt(3, 15);
                               cb.setInt(4,z);
                               cb.execute(); } 
       
        
        /**********************************************************************/
                          else 
           
                             {System.out.println("Félicitation.... vous avez gagnier une reduction de "+30+"% sur votre premier achat!!!!........ ");/***********************************************************/
                              String gga ="INSERT INTO `icoingame`( `id_user`, `winn`,`value_win`,`money_waste`) VALUES (?,?,?,?)";
                              PreparedStatement ga = cnx.prepareStatement(gga);
                              ga.setInt(1, x.getId_user());
                              ga.setString(2,"remise");
                              ga.setInt(3, 30);
                              ga.setInt(4,z);
                              ga.execute();}}         
        
        /**********************************************************************/
        
        else if (winner == z && winner == 0)
                    
                   {int a=x.getSolde()+100;
                    x.setSolde(a);
                    String wiinn ="UPDATE `wallet` SET `solde`='"+a+"'WHERE `id_user` = '"+x.getId_user()+"'";
                    Statement winn = cnx.createStatement();
                    st.executeUpdate(wiinn);
                    winn.executeUpdate(wiinn);
                    System.out.println("Félicitation.... vous avez gagnier la plus grande prime ****** 100 COINS*****........ ");/********************************************************************/
                    String red ="INSERT INTO `icoingame`( `id_user`, `winn`,`value_win`,`money_waste`) VALUES (?,?,?,?)";
                    PreparedStatement str = cnx.prepareStatement(red);
                    str.setInt(1, x.getId_user());
                    str.setString(2,"coins");
                    str.setInt(3, 100);
                    str.setInt(4,z);
                    str.execute();}
        
        /**********************************************************************/
       else if(winner != z && z == 0) 
            {
                   x.setSolde(x.getSolde()-15);
                   String loser ="UPDATE `wallet` SET `solde`='"+x.getSolde()+"'WHERE `id_user` = '"+x.getId_user()+"'";
                   Statement los = cnx.createStatement();
                   st.executeUpdate(loser);
                   los.executeUpdate(loser);
                   System.out.println("Quel mal chance !!!! Réessayer de nouveau.......");
                   String rap ="INSERT INTO `icoingame`( `id_user`,`money_waste`) VALUES (?,?)";
                   PreparedStatement pp = cnx.prepareStatement(rap);
                   pp.setInt(1, x.getId_user());
                   pp.setInt(2,5);
                   pp.execute();
               
            }
       
        /**********************************************************************/
     else{
                 System.out.println("Quel mal chance !!!! Réessayer de nouveau.......");
                   String rap ="INSERT INTO `icoingame`( `id_user`,`money_waste`) VALUES (?,?)";
                   PreparedStatement pp = cnx.prepareStatement(rap);
                   pp.setInt(1, x.getId_user());
                   pp.setInt(2,5);
                   pp.execute(); }}
         /*********************************************************************/
     else 
             System.out.println("Recharger votre solde et revient pour jouer.....");}
     
 /****************************************************************manipulation et stat*****************************************************************************************************************/
     
    @Override
    public int wasteOfmoney() throws SQLException{
      String somme ="SELECT sum(money_waste) FROM icoingame";
      Statement st = cnx.createStatement();
      ResultSet rs = st.executeQuery(somme);
      int waste =0;
        while (rs.next()){waste=rs.getInt(1);}
      System.out.println("le montant que les clients payent : "+waste);
                  String ome ="SELECT value_win FROM `icoingame` where `winn` = '"+coins+"'";
            Statement stt = cnx.createStatement();
            ResultSet rss = stt.executeQuery(ome);
            int winning =0;
            while (rss.next()){winning=rss.getInt(1);}
            System.out.println("le montant que les clients gagnent : "+winning);
   
        System.out.println("la difference (payer-gain) : "+(waste-winning));
        
    return waste-winning;}
    
    
    
    


     
 

    
}

