/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Timestamp;

/**
 *
 * @author HUNTER
 */
public class Coins_history {
    
    private int id_h;
    private int id_user;
    private int montant_achat;
    private int transaction;
    private int reçu_money;
    private Timestamp date_hystory;



    
    public Coins_history( int id_user, int montant_achat, int transaction, int reçu_money) {
        
        this.id_user = id_user;
        this.montant_achat = montant_achat;
        this.transaction = transaction;
        this.reçu_money = reçu_money;
    }

    public Coins_history(int id_user, int montant_achat, int transaction) {
        this.id_user = id_user;
        this.montant_achat = montant_achat;
        this.transaction = transaction;
    }

    public Coins_history(int id_user, int reçu_money) {
        this.id_user = id_user;
        this.reçu_money = reçu_money;
    }

    public Coins_history() {
    }

    public Coins_history(int id_h, int id_user, int montant_achat, int transaction, int reçu_money, Timestamp date_hystory) {
        
        this.id_h = id_h;
        this.id_user = id_user;
        this.montant_achat = montant_achat;
        this.transaction = transaction;
        this.reçu_money = reçu_money;
        this.date_hystory = date_hystory;
    }





    public int getId_h() {
        return id_h;
    }

    public void setId_h(int id_h) {
        this.id_h = id_h;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getMontant_achat() {
        return montant_achat;
    }

    public void setMontant_achat(int montant_achat) {
        this.montant_achat = montant_achat;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    public int getReçu_money() {
        return reçu_money;
    }

    public void setReçu_money(int reçu_money) {
        this.reçu_money = reçu_money;
    }

    public Timestamp getDate_hystory() {
        return date_hystory;
    }

    public void setDate_hystory(Timestamp date_hystory) {
        this.date_hystory = date_hystory;
    }

    @Override
    public String toString() {
        return "Coins_history{" + "id_h=" + id_h + ", id_user=" + id_user + ", montant_achat=" + montant_achat + ", transaction=" + transaction + ", reçu__money=" + reçu_money + ", date_hystory=" + date_hystory + '}'+"\n";
    }

   
    
    
    
    
    
}
