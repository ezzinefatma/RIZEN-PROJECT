/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class commentaire {
//var
    private int id_com;
    private String content_com	;
    private String date_com;
   
    private int id_user;
    
    //Constructor

    public commentaire() {
    }

    public commentaire(String content_com, String date_com, int id_user) {
        this.content_com = content_com;
        this.date_com = date_com;
        this.id_user = id_user;
    }

    public commentaire(int id_com, String content_com, String date_com, int id_user) {
        this.id_com = id_com;
        this.content_com = content_com;
        this.date_com = date_com;
        this.id_user = id_user;
    }

    public int getId_com() {
        return id_com;
    }

    public String getContent_com() {
        return content_com;
    }

    public String getDate_com() {
        return date_com;
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

    public void setDate_com(String date_com) {
        this.date_com = date_com;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

 public String toString() {
        return "commentaire{" + "id=" + id_com + ", content=" + content_com + ", date_pub=" + date_com +  ", id_user=" + id_user + '}';
    }









    
}
