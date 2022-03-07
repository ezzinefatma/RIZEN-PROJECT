/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author HUNTER
 */
public class CoinsGame {


  
    
    private int id_user;
    private String username;    
    private String email;
    private String numero_tel;
    private int idGame;
    private  EnumCoins winn;
    private int value_win;
    private int money_waste;
    private Timestamp date_remise;



    public CoinsGame(int id_user, String username, String email, String numero_tel, int idGame, EnumCoins winn, int value_win, int money_waste, Timestamp date_remise) {
        this.id_user = id_user;
        this.username = username;
        this.email = email;
        this.numero_tel = numero_tel;
        this.idGame = idGame;
        this.winn = winn;
        this.value_win = value_win;
        this.money_waste = money_waste;
        this.date_remise = date_remise;
    }//affichage totatl

    public CoinsGame(int id_user, int idGame, EnumCoins winn, int value_win, int money_waste, Timestamp date_remise) {
        this.id_user = id_user;
        this.idGame = idGame;
        this.winn = winn;
        this.value_win = value_win;
        this.money_waste = money_waste;
        this.date_remise = date_remise;
    }//afiichage remise

    public CoinsGame(int id_user, EnumCoins winn, int value_win, int money_waste) {
        this.id_user = id_user;
        this.winn = winn;
        this.value_win = value_win;
        this.money_waste = money_waste;
    }//ajout

    
    
    public CoinsGame() {}
    
    
    
    







    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public EnumCoins getWinn() {
        return winn;
    }

    public void setWinn(EnumCoins winn) {
        this.winn = winn;
    }

    public int getMoney_waste() {
        return money_waste;
    }

    public int getValue_win() {
        return value_win;
    }

    public void setValue_win(int value_win) {
        this.value_win = value_win;
    }
    
   

    public void setMoney_waste(int money_waste) {
        this.money_waste = money_waste;
    }

    public Timestamp getDate_remise() {
        return date_remise;
    }

    public void setDate_remise(Timestamp date_remise) {
        this.date_remise = date_remise;
    }

    @Override
    public String toString() {
        return "CoinsGame{" + "id_user=" + id_user + ", username=" + username + ", email=" + email + ", numero_tel=" + numero_tel + ", idGame=" + idGame + ", winn=" + winn + ", value_win=" + value_win + ", money_waste=" + money_waste + ", date_remise=" + date_remise + '}'+"\n";
    }




    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
