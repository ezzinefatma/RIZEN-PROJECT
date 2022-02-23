/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author OUSSAMA
 */
public class news {
    private int id_news;
    private String titre_news;
    private String contenu_news;
    private Date date_news;

    public news(String titre_news, String contenu_news) {
        this.titre_news = titre_news;
        this.contenu_news = contenu_news;
    }

    public news(int id_news, String titre_news, String contenu_news) {
        this.id_news = id_news;
        this.titre_news = titre_news;
        this.contenu_news = contenu_news;
    }

    public news(int id_news, String titre_news, String contenu_news, Date date_news) {
        this.id_news = id_news;
        this.titre_news = titre_news;
        this.contenu_news = contenu_news;
        this.date_news = date_news;
    }
    

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    public String getTitre_news() {
        return titre_news;
    }

    public void setTitre_news(String titre_news) {
        this.titre_news = titre_news;
    }

    public String getContenu_news() {
        return contenu_news;
    }

    public void setContenu_news(String contenu_news) {
        this.contenu_news = contenu_news;
    }

    public Date getDate_news() {
        return date_news;
    }

    public void setDate_news(Date date_news) {
        this.date_news = date_news;
    }

    @Override
    public String toString() {
        return "news{" + "id_news=" + id_news + ", titre_news=" + titre_news + ", contenu_news=" + contenu_news + ", date_news=" + date_news + '}';
    }
    
    
}
