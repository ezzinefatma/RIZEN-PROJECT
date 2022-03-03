/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author ford_
 */
public class stream {
    
       private    int       id_stream ;    
       private   String     titre_stream ;     
       private   stream_category     categorie   ;
       private   int     nbr_like   ; 
       private   int     nbr_report;  
       private   String     url   ;
       private   int     id_user;
       private   status_stream status;
       private   String background_pic;
       private   react_stream react;
      
       
    //Constructor

    public stream() {
    }

    public stream(String titre_stream, stream_category categorie, String url, status_stream status, String background_pic, react_stream react) {
        this.titre_stream = titre_stream;
        this.categorie = categorie;
        this.url = url;
        this.status = status;
        this.background_pic = background_pic;
        this.react = react;
    }
    

    public stream(String titre_stream, stream_category categorie, int nbr_like, int nbr_report, String url, int id_user, status_stream status, String background_pic, react_stream react) {
        this.titre_stream = titre_stream;
        this.categorie = categorie;
        this.nbr_like = nbr_like;
        this.nbr_report = nbr_report;
        this.url = url;
        this.id_user = id_user;
        this.status = status;
        this.background_pic = background_pic;
        this.react = react;
       
    }

    public stream(int id_stream, String titre_stream, stream_category categorie, int nbr_like, int nbr_report, String url, int id_user, status_stream status, String background_pic, react_stream react) {
        this.id_stream = id_stream;
        this.titre_stream = titre_stream;
        this.categorie = categorie;
        this.nbr_like = nbr_like;
        this.nbr_report = nbr_report;
        this.url = url;
        this.id_user = id_user;
        this.status = status;
        this.background_pic = background_pic;
        this.react = react;
        
    }

  
    
    //Getters
    
    public int getId_stream() {
        return id_stream;
    }

    public String getTitre_stream() {
        return titre_stream;
    }

    public stream_category getCategorie() {
        return categorie;
    }


    public int getNbr_like() {
        return nbr_like;
    }

    public int getNbr_report() {
        return nbr_report;
    }

    public String getUrl() {
        return url;
    }

    
    public int getId_user() {
        return id_user;
    }

    public status_stream getStatus() {
        return status;
    }

    public String getBackground_pic() {
        return background_pic;
    }

    public react_stream getReact() {
        return react;
    }

    
    
    
    // Setters

    public void setId_stream(int id_stream) {
        this.id_stream = id_stream;
    }

    public void setTitre_stream(String titre_stream) {
        this.titre_stream = titre_stream;
    }

    public void setCategorie(stream_category categorie) {
        this.categorie = categorie;
    }

    

    public void setNbr_like(int nbr_like) {
        this.nbr_like = nbr_like;
    }

    public void setNbr_report(int nbr_report) {
        this.nbr_report = nbr_report;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setStatus(status_stream status) {
        this.status = status;
    }

    public void setBackground_pic(String background_pic) {
        this.background_pic = background_pic;
    }

    public void setReact(react_stream react) {
        this.react = react;
    }

    

    
    //Affichage
    @Override
    public String toString() {
        return "stream{"+ "id=" + id_stream + "\n"+", titre=" 
                        + titre_stream + "\n"+", categorie=" 
                        +categorie+ "\n"+", nbr_like =" 
                        +nbr_like+ "\n"+",nbr_report=" 
                        + nbr_report +"\n"+",url="
                        +url+"\n"+",id_user="
                        +id_user+"\n"+",status="
                        +status+"\n"+",background_pic="
                        +background_pic+ "\n"+",react="
                        +react+"\n"
                        +"*********************"+"\n"+'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_stream;
        hash = 97 * hash + Objects.hashCode(this.titre_stream);
        hash = 97 * hash + Objects.hashCode(this.categorie);
        hash = 97 * hash + this.nbr_like;
        hash = 97 * hash + this.nbr_report;
        hash = 97 * hash + Objects.hashCode(this.url);
        hash = 97 * hash + this.id_user;
        hash = 97 * hash + Objects.hashCode(this.status);
        hash = 97 * hash + Objects.hashCode(this.background_pic);
        hash = 97 * hash + Objects.hashCode(this.react);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final stream other = (stream) obj;
        if (this.id_stream != other.id_stream) {
            return false;
        }
        if (this.nbr_like != other.nbr_like) {
            return false;
        }
        if (this.nbr_report != other.nbr_report) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.titre_stream, other.titre_stream)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.background_pic, other.background_pic)) {
            return false;
        }
        if (this.categorie != other.categorie) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return this.react == other.react;
    }
     
    
}
