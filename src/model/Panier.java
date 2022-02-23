/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MSI
 */
public class Panier {
     private int id_prod;
     
    private int id_user;
     private int quantite;

    public Panier() {
    }

    public Panier(int id_prod, int id_user, int quantite) {
        this.id_prod = id_prod;
        this.id_user = id_user;
        this.quantite = quantite;
    }

    public Panier(int id_user, int quantite) {
        this.id_user = id_user;
        this.quantite = quantite;
    }

    public Panier(int quantite) {
        this.quantite = quantite;
    }

   

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_prod=" + id_prod + ", id_user=" + id_user + ", quantite=" + quantite + '}';
    }
     
     
     
     
}
