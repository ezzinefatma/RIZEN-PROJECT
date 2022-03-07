/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ford_
 */
public class stream {
    
       private    int       id_stream ;    
       private   String     titre_stream ;     
       private   String     categorie   ;
       private   int     nbr_like   ; 
       private   int     nbr_report;  
       private   String     url   ;
       private   int     id_user;
    
    //Constructor

    public stream() {
    }

    public stream(String titre_stream, String categorie, int nbr_like, int nbr_report, String url, int id_user) {
        this.titre_stream = titre_stream;
        this.categorie = categorie;
        this.nbr_like = nbr_like;
        this.nbr_report = nbr_report;
        this.url = url;
        this.id_user = id_user;
    }

    public stream(int id_stream, String titre_stream, String categorie, int nbr_like, int nbr_report, String url, int id_user) {
        this.id_stream = id_stream;
        this.titre_stream = titre_stream;
        this.categorie = categorie;
        this.nbr_like = nbr_like;
        this.nbr_report = nbr_report;
        this.url = url;
        this.id_user = id_user;
    }
    //Getters
    
    public int getId_stream() {
        return id_stream;
    }

    public String getTitre_stream() {
        return titre_stream;
    }

    public String getCategorie() {   
        return categorie;
    }

    /**
     *
     * @return
     */
    public int getNbr_like() {
        return nbr_like;
    }

    public int getNbr_report() {
        return nbr_report;
    }

    public String getUrl() {
        return url;
    }

    /**
     *
     * @return
     */
    public int getId_user() {
        return id_user;
    }

    // Setters

    public void setId_stream(int id_stream) {
        this.id_stream = id_stream;
    }

    /**
     *
     * @param titre_stream
     */
    public void setTitre_stream(String titre_stream) {
        this.titre_stream = titre_stream;
    }

    /**
     *
     * @param categorie
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     *
     * @param nbr_like
     */
    public void setNbr_like(int nbr_like) {
        this.nbr_like = nbr_like;
    }

    /**
     *
     * @param nbr_report
     */
    public void setNbr_report(int nbr_report) {
        this.nbr_report = nbr_report;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @param id_user
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    
    
    //Affichage
    @Override
    public String toString() {
        return "stream{"+ "id=" + id_stream + "\n"+", titre=" + titre_stream + "\n"+", categorie=" +categorie+ "\n"+", nbr_like =" +nbr_like+ "\n"+",nbr_report=" + nbr_report +"\n"+",url="+url+"\n"+",id_user="+id_user+ "\n"+"\n"+"*********************"+"\n"+'}';
    }
    
    
    
}
