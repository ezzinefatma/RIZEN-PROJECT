/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Fatma
 */
public class Admin {
    
    private int admin_id ;	
    private String nom_admin ;	
    private String prenom_id ;
    private String email ;	
    private String password ;	
   
    public Admin() {
    }

    public Admin(int admin_id, String nom_admin, String prenom_id, String email, String password) {
        this.admin_id = admin_id;
        this.nom_admin = nom_admin;
        this.prenom_id = prenom_id;
        this.email = email;
        this.password = password;
    
    }
    
    

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getNom_admin() {
        return nom_admin;
    }

    public void setNom_admin(String nom_admin) {
        this.nom_admin = nom_admin;
    }

    public String getPrenom_id() {
        return prenom_id;
    }

    public void setPrenom_id(String prenom_id) {
        this.prenom_id = prenom_id;
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "admin_id=" + admin_id + ", nom_admin=" + nom_admin + ", prenom_id=" + prenom_id + ", email=" + email + ", password=" + password + '}';
    }

 
   

  
}
