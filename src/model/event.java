/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author OUSSAMA
 */
public class event {
    //var
    private int id_event ;
    private String titre_event;
    private String date_debut;
    private String date_fin;
    private String image;
    private String description;
    private int capacite;
    private String type;

    public event() {
    }

    public event(String titre_event, String date_debut, String date_fin, String image, String description, int capacite, String type) {
        this.titre_event = titre_event;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.image = image;
        this.description = description;
        this.capacite = capacite;
        this.type = type;
    }

    public event(int id_event, String titre_event, String date_debut, String date_fin, String image, String description, int capacite, String type) {
        this.id_event = id_event;
        this.titre_event = titre_event;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.image = image;
        this.description = description;
        this.capacite = capacite;
        this.type = type;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getTitre_event() {
        return titre_event;
    }

    public void setTitre_event(String titre_event) {
        this.titre_event = titre_event;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "event{" + "id_event=" + id_event + ", titre_event=" + titre_event + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", image=" + image + ", description=" + description + ", capacite=" + capacite + '}';
    }
    
}
