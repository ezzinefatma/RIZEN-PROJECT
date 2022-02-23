/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class publication {


 //var
    private int id_pub;
    private String content_pub	;
    private String date_pub;
    private int like_nbr;
    private int id_user;

    public publication() {
    }

    public publication(String content_pub, String date_pub, int like_nbr, int id_user) {
        this.content_pub = content_pub;
        this.date_pub = date_pub;
        this.like_nbr = like_nbr;
        this.id_user = id_user;
    }

    public publication(int id_pub, String content_pub, String date_pub, int like_nbr, int id_user) {
        this.id_pub = id_pub;
        this.content_pub = content_pub;
        this.date_pub = date_pub;
        this.like_nbr = like_nbr;
        this.id_user = id_user;
    }

    public int getId_pub() {
        return id_pub;
    }

    public String getContent_pub() {
        return content_pub;
    }

    public String getDate_pub() {
        return date_pub;
    }

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

    public void setDate_pub(String date_pub) {
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
        return "publication{" + "id=" + id_pub + ", content=" + content_pub + ", date_pub=" + date_pub + ", likes=" + 	like_nbr + ", id_user=" + id_user + '}';
    }

    
}
