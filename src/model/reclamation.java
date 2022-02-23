/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Timestamp;

/**
 *
 * @author HUNTER
 */
public class reclamation {

        //var 
   private int id_rec;
   private String type_rec;
   private String description_rec;
   private String statut_rec;
   private Timestamp date_rec;
   private int id_user;

   
   
       //constructor 

    public reclamation(int id_rec, String type_rec, String description_rec, String statut_rec, Timestamp date_rec, int id_user) {
        this.id_rec = id_rec;
        this.type_rec = type_rec;
        this.description_rec = description_rec;
        this.statut_rec = statut_rec;
        this.date_rec = date_rec;
        this.id_user = id_user;
    }

    public reclamation(String type_rec, String description_rec, String statut_rec, int id_user) {
        this.type_rec = type_rec;
        this.description_rec = description_rec;
        this.statut_rec = statut_rec;
        this.id_user = id_user;
    }

    public reclamation(String type_rec, String description_rec, int id_user) {
        this.type_rec = type_rec;
        this.description_rec = description_rec;
        this.id_user = id_user;
    }

    public reclamation() {}

    

    
    //getter+setter

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getType_rec() {
        return type_rec;
    }

    public void setType_rec(String type_rec) {
        this.type_rec = type_rec;
    }

    public String getDescription_rec() {
        return description_rec;
    }

    public void setDescription_rec(String description_rec) {
        this.description_rec = description_rec;
    }

    public Timestamp getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(Timestamp date_rec) {
        this.date_rec = date_rec;
    }

    public String getStatut_rec() {
        return statut_rec;
    }

    public void setStatut_rec(String statut_rec) {
        this.statut_rec = statut_rec;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
   
    //affichage

    @Override
    public String toString() {
        return "reclamation{" + "id_rec=" + id_rec + ", type_rec=" + type_rec + ", description_rec=" + description_rec + ", date_rec=" + date_rec + ", statut_rec=" + statut_rec + ", id_user=" + id_user + '}';
    }
    
    


    
   
   

}
