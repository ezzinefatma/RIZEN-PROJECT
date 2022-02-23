/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author MSI
 */
public class Promotion {
    
    
    
   private int  id_prom ;
   private int  id_prod;
  private String  date_debut_prom;
  private String  date_fin_prom;
  private int  taux_reduction;

    public Promotion() {
    }

    public Promotion(int id_prom, int id_prod, String date_debut_prom, String date_fin_prom, int taux_reduction) {
        this.id_prom = id_prom;
        this.id_prod = id_prod;
        this.date_debut_prom = date_debut_prom;
        this.date_fin_prom = date_fin_prom;
        this.taux_reduction = taux_reduction;
    }

    public Promotion(int id_prod, String date_debut_prom, String date_fin_prom, int taux_reduction) {
        this.id_prod = id_prod;
        this.date_debut_prom = date_debut_prom;
        this.date_fin_prom = date_fin_prom;
        this.taux_reduction = taux_reduction;
    }

    public int getId_prom() {
        return id_prom;
    }

    public void setId_prom(int id_prom) {
        this.id_prom = id_prom;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getDate_debut_prom() {
        return date_debut_prom;
    }

    public void setDate_debut_prom(String date_debut_prom) {
        this.date_debut_prom = date_debut_prom;
    }

    public String getDate_fin_prom() {
        return date_fin_prom;
    }

    public void setDate_fin_prom(String date_fin_prom) {
        this.date_fin_prom = date_fin_prom;
    }

    public int getTaux_reduction() {
        return taux_reduction;
    }

    public void setTaux_reduction(int taux_reduction) {
        this.taux_reduction = taux_reduction;
    }

    
    @Override
    public String toString() {
        return "Promotion{" + "id_prom=" + id_prom + ", id_prod=" + id_prod + ", date_debut_prom=" + date_debut_prom + ", date_fin_prom=" + date_fin_prom + ", taux_reduction=" + taux_reduction + '}';
    }
    

    
}
