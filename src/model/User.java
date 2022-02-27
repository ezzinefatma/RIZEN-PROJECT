/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fatma
 */



public class User {
    
    //VAR
   
    private int id_user;
    private String nom_user;
    private String prenom_user;
    private int age;
    private int numero_tel;
    private String email;
    private String username;
    private String password;
    private String adresse;
    private String photo;
    private String role;
    private int statut_user;
    
    
    //CONSTRUCTEUR

    public User() {}

    public User(int id_user, String nom_user, String prenom_user, int age, int numero_tel, String email, String username , String password,String adresse, String photo, String role, int statut_user) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.age = age;
        this.numero_tel = numero_tel;
        this.email = email;
        this.username=username;
        this.password=password;
        this.adresse = adresse;
        this.photo = photo;
        this.role = role;
        this.statut_user = statut_user;
    }

  

    public User(String nom_user, String prenom_user, int age, int numero_tel, String email, String username , String password, String adresse, String photo , int statut_user) {
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.age = age;
        this.numero_tel = numero_tel;
        this.email = email;
        this.username=username;
        this.password=password;
        this.adresse = adresse;
        this.photo = photo;
        this.statut_user = statut_user;
    }

    public User(int id_user, String nom_user, String prenom_user, int age, int numero_tel, String email, String username , String password, String adresse, String photo) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.age = age;
        this.numero_tel = numero_tel;
        this.email = email;
        this.username=username;
        this.password=password;
        this.adresse = adresse;
        this.photo = photo;
    }

    public User(int id_user, String nom_user, String prenom_user, int age, int numero_tel, String email, String username, String password, String adresse, String photo, int statut_user) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.age = age;
        this.numero_tel = numero_tel;
        this.email = email;
        this.username = username;
        this.password = password;
        this.adresse = adresse;
        this.photo = photo;
        this.statut_user = statut_user;
    }
    
    
    
    //Getters & Setters 

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumero_tel() {
        return numero_tel;
    }

    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatut_user() {
        return statut_user;
    }

    public void setStatut_user(int statut_user) {
        this.statut_user = statut_user;
    }

    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatut() {
        return statut_user;
    }

    public void setStatut(int statut) {
        this.statut_user = statut;
    }
    
    
    
    //ToString

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", age=" + age + ", numero_tel=" + numero_tel + ", email=" + email + ", username=" + username + ", password=" + password + ", adresse=" + adresse + ", photo=" + photo + ", role=" + role + ", statut_user=" + statut_user + '}';
    }

 
    
    
     
    
    
}
