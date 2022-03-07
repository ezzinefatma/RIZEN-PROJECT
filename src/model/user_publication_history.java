/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class user_publication_history {
    
    
    
    private int id_his;
    private int id_pub;
    private int id_user;
    private Timestamp his_date_pub;

    public user_publication_history() {
    }

    public user_publication_history(int id_pub, int id_user, Timestamp his_date_pub) {
        this.id_pub = id_pub;
        this.id_user = id_user;
        this.his_date_pub = his_date_pub;
    }

    public user_publication_history(int id_his, int id_pub, int id_user, Timestamp his_date_pub) {
        this.id_his = id_his;
        this.id_pub = id_pub;
        this.id_user = id_user;
        this.his_date_pub = his_date_pub;
    }

    public int getId_his() {
        return id_his;
    }

    public int getId_pub() {
        return id_pub;
    }

    public int getId_user() {
        return id_user;
    }

    public Timestamp getHis_date_pub() {
        return his_date_pub;
    }

    public void setId_his(int id_his) {
        this.id_his = id_his;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setHis_date_pub(Timestamp his_date_pub) {
        this.his_date_pub = his_date_pub;
    }

    @Override
    public String toString() {
        return "user_publication_history{"+ "id_his=" + id_his + "\n"+" id_pub=" 
                        + id_pub + "\n"+" id_user=" 
                        +id_user+ "\n"+" id_user =" 
                        +id_user+ "\n"+"date publication=" 
                        + his_date_pub +"\n"
                        +"******************************"+"\n"+'}';
    }
    
    
    
    

      
    
}


