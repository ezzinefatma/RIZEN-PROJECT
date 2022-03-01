/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HUNTER
 */
public class wallet {
        //var 
   private int id_wallet;
   private int solde ;
   private String card_number;
   private int csc;
   private String expire;
   private int id_user;
   private User User;
    
   //constructor 

    public wallet(int id_wallet, int solde, String card_number, int csc, String expire, int id_user) {
        this.id_wallet = id_wallet;
        this.solde = solde;
        this.card_number = card_number;
        this.csc = csc;
        this.expire = expire;
        this.id_user = id_user;
    }

    public wallet(int solde, String card_number, int csc, String expire, int id_user) {
        this.solde = solde;
        this.card_number = card_number;
        this.csc = csc;
        this.expire = expire;
        this.id_user = id_user;
    }

    public wallet(String card_number, int csc, String expire, int id_user) {
        this.card_number = card_number;
        this.csc = csc;
        this.expire = expire;
        this.id_user = id_user;
    }
    

    public wallet() {
    }
   
   //getter+setter 

    public int getId_wallet() {
        return id_wallet;
    }

    public void setId_wallet(int id_wallet) {
        this.id_wallet = id_wallet;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public int getCsc() {
        return csc;
    }

    public void setCsc(int csc) {
        this.csc = csc;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }
    
    
    //affichage 

    @Override
    public String toString() {
        return "wallet{" + "id_wallet=" + id_wallet + ", solde=" + solde + ", card_number=" + card_number + ", csc=" + csc + ", expire=" + expire + ", id_user=" + id_user + '}'+"\n";
    }
    
    
    
}
