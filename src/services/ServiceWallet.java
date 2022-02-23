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
import model.wallet;

/**
 *
 * @author HUNTER
 */
public class ServiceWallet implements IWallet{

    Connection cnx = maConnexion.getInstance().getCnx();

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
            System.out.println(" walet ajouter avec succée...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }     }

    @Override
    public List<wallet> afficherwallet() {
        List<wallet> wallets = new ArrayList<>();
        
        String query = "SELECT * FROM `wallet`";
        
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

    @Override
    public void supresionwallet(int x) {
       try (PreparedStatement psDel = cnx.prepareStatement("DELETE FROM `wallet` WHERE id_wallet = ?")
) {
    psDel.setInt(1, x);

    if (psDel.executeUpdate() > 0)
        System.out.println("wallet with id = "+x+" deleted successfully.");
    else
        System.out.println("Record not found.");
}       catch (SQLException ex) {
          ex.printStackTrace();        
}
    }
    
}
