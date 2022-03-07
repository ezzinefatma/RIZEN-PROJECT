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
public class publication {


 //var
    private int id_pub;
    private String content_pub	;
    private Timestamp date_pub;
    private int like_nbr;
    private int id_user;
    private String  user_name;
   

    public publication() {
    }

    public publication(String content_pub) {
        this.content_pub = content_pub;
    }

    public publication(String content_pub, Timestamp date_pub, int like_nbr, String user_name) {
        this.content_pub = content_pub;
        this.date_pub = date_pub;
        this.like_nbr = like_nbr;
        this.user_name = user_name;
    }

    public publication(int id_pub, String content_pub, Timestamp date_pub, String user_name) {
        this.id_pub = id_pub;
        this.content_pub = content_pub;
        this.date_pub = date_pub;
        this.user_name = user_name;
    }

    public publication(String content_pub, Timestamp date_pub, int like_nbr) {
        this.content_pub = content_pub;
        this.date_pub = date_pub;
        this.like_nbr = like_nbr;
    }

    public publication(int id_pub, String content_pub, Timestamp date_pub, int like_nbr, int id_user, String user_name) {
        this.id_pub = id_pub;
        this.content_pub = content_pub;
        this.date_pub = date_pub;
        this.like_nbr = like_nbr;
        this.id_user = id_user;
        this.user_name = user_name;
    }

    public publication(int id_pub, String content_pub, int like_nbr, int id_user, String user_name) {
        this.id_pub = id_pub;
        this.content_pub = content_pub;
        this.like_nbr = like_nbr;
        this.id_user = id_user;
        this.user_name = user_name;
    }

    public publication(int id_pub, String content_pub, int like_nbr, int id_user) {
        this.id_pub = id_pub;
        this.content_pub = content_pub;
        this.like_nbr = like_nbr;
        this.id_user = id_user;
    }

    public publication(String content_pub, int id_user) {
        this.content_pub = content_pub;
        this.id_user = id_user;
    }

    public publication(String content_pub, int like_nbr, int id_user) {
        this.content_pub = content_pub;
        this.like_nbr = like_nbr;
        this.id_user = id_user;
    }

    public publication(int id_pub, String content_pub, Timestamp date_pub, int like_nbr, int id_user) {
        this.id_pub = id_pub;
        this.content_pub = content_pub;
        this.date_pub = date_pub;
        this.like_nbr = like_nbr;
        this.id_user = id_user;
    }

    public publication(int id_pub, String content_pub, Timestamp date_pub, int like_nbr, String user_name) {
        this.id_pub = id_pub;
        this.content_pub = content_pub;
        this.date_pub = date_pub;
        this.like_nbr = like_nbr;
        this.user_name = user_name;
    }

    

   
    public int getId_pub() {
        return id_pub;
    }

    public String getContent_pub() {
        return content_pub;
    }

    public Timestamp getDate_pub() {
        return date_pub;
    }

    /**
     *
     * @return
     */
    public int getLike_nbr() {
        return like_nbr;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public void setContent_pub(String content_pub) {
        this.content_pub = content_pub;
    }

    public void setDate_pub(Timestamp date_pub) {
        this.date_pub = date_pub;
    }

    public void setLike_nbr(int like_nbr) {
        this.like_nbr = like_nbr;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "publication{"+ "id=" + id_pub + "\n"+" content=" 
                        + content_pub + "\n"+" LIKES=" 
                        +like_nbr+ "\n"+" id_user =" 
                        +id_user+ "\n"+"user_name=" 
                        + user_name +"\n"
                        +"******************************"+"\n"+'}';
    }
   
    
}
