/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;
import model.User;
/**
 *
 * @author ASUS
 */
public class commentaire {
//var
    private int id_com;
    private String content_com	;
    private Timestamp date_com;
    private String user_name;
    private int id_user;

    public commentaire() {
    }

    public commentaire(String content_com, Timestamp date_com, String user_name, int id_user) {
        this.content_com = content_com;
        this.date_com = date_com;
        this.user_name = user_name;
        this.id_user = id_user;
    }

    public commentaire(int id_com, String content_com, Timestamp date_com, String user_name, int id_user) {
        this.id_com = id_com;
        this.content_com = content_com;
        this.date_com = date_com;
        this.user_name = user_name;
        this.id_user = id_user;
    }

    public commentaire(int id_com, String content_com, int id_user) {
        this.id_com = id_com;
        this.content_com = content_com;
        this.id_user = id_user;
    }

    public commentaire(int id_com, String content_com) {
        this.id_com = id_com;
        this.content_com = content_com;
    }

    public commentaire(String content_com, Timestamp date_com, String user_name) {
        this.content_com = content_com;
        this.date_com = date_com;
        this.user_name = user_name;
    }

    public commentaire(String content_com, int id_user) {
        this.content_com = content_com;
        this.id_user = id_user;
    }

    public int getId_com() {
        return id_com;
    }

    public String getContent_com() {
        return content_com;
    }

    public Timestamp getDate_com() {
        return date_com;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public void setContent_com(String content_com) {
        this.content_com = content_com;
    }

    public void setDate_com(Timestamp date_com) {
        this.date_com = date_com;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
       return "commentaire{"+ "id=" + id_com + "\n"+" content=" 
                        + content_com +  "\n"+" id_user =" 
                        +id_user+ "\n"+"user_name=" 
                        + user_name +"\n"
                        +"******************************"+"\n"+'}';
    }
    



    
}
