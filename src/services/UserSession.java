/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Fatma
 */
public final class UserSession {
    
    private static UserSession instance;
    private int user_id;
    private  String nom_user;
    private String prenom_user;
    private  int age;
    private int phone;
    private  String adress;
    private  String email;
    private  String password;

   
  
     private UserSession(int user_id,String nom_user,String prenom_user, int age , int phone, String adress, String email, String password) {
        this.user_id = user_id;
        this.nom_user=nom_user;
        this.prenom_user=prenom_user;
        this.age=age;
        this.phone=phone;
        this.adress=adress;
        this.email = email;
        this.password = password;
    }

   
     
        

    public static UserSession getInstace(int user_id,String nom_user,String prenom_user,int age , int phone, String adress, String email, String password) {
        if (instance == null) {
            instance = new UserSession(user_id,nom_user,prenom_user,age,phone,adress, email, password);
        }
        return instance;
    }

    public static UserSession getInstance() {
        return instance;
    }

    public static void setInstance(UserSession instance) {
        UserSession.instance = instance;
    }

    public int getUser_id() {
        return user_id;
    }

   

    public  String getNom_user() {
        return nom_user;
    }

  

    public String getPrenom_user() {
        return prenom_user;
    }

   

    public  int getAge() {
        return age;
    }

    

    public  int getPhone() {
        return phone;
    }

   
    public  String getAdress() {
        return adress;
    }


    
    public  String getEmail() {
        return email;
    }


    public  String getPassword() {
        return password;
    }

  
     public static void cleanUserSession() {
        instance=null;
    }

    
    
    
}
