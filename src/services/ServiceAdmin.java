/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Iadmin;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Role;
import model.User;
import static util.Pwd.getSHA;
import static util.Pwd.toHexString;
import util.maConnexion;

/**
 *
 * @author Fatma
 */
public class ServiceAdmin implements Iadmin {
    
     Connection cnx = maConnexion.getInstance().getCnx();
     
   @Override
    public boolean login(String email, String password) throws Exception {
         if (!email.isEmpty() && !password.isEmpty() ) {
            String requete = "SELECT password FROM user WHERE email = '" + email +"'";
            Statement s = maConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = s.executeQuery(requete);
                    if (rs.next()){
                       if( toHexString(getSHA(password)).equals(rs.getString("password")) )
                                {
                            System.out.println("login success");
                            return true;
                        }
                    else {
                        System.out.println("Please enter correct Email or Password"); 
                        return false;
                    }   
                    }
                    else{
                        System.out.println("Please enter correct Email or Password");  
                        return false;
                    } 
        }
        else {
            System.out.println("fill missing infos!");
            return false;
           
        } 
    }
    

    
    @Override
    public boolean Banned(User u) {
         if(u.getStatut()==1) {
             //System.out.println("User Banned");
             return true;
         }
         else {
        //System.out.println("User not Banned");
        return false;
         }
    }
     @Override
    public void UpdatePassword(String email, String password) throws Exception{
       
       String  pw = toHexString(getSHA(password));
       
       String sql= "UPDATE user SET password='"+ pw +"'"+"WHERE email='"+ email+"'";
       PreparedStatement statement = cnx.prepareStatement(sql);
       int rowsUpdated = statement.executeUpdate(sql);
       if (rowsUpdated > 0) {
             System.out.println("password updated successfully!");
         }
    }    
   
    public User getByEmail(String email ) {
        
        User u =new User();
         String query = "SELECT * FROM user where `email`='"+email+"'";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                
                u=new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), 
                rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return u;
        
    }
   

     @Override
    public void addUser(User u) {
        
        try {
            
            String pw=toHexString(getSHA(u.getPassword()));
            String Req = "INSERT INTO `user`(`nom_user`, `prenom_user`, `age`, `numero_tel`, `adresse`,`email`,`password`)"
                    + "VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = cnx.prepareStatement(Req);
                ps.setString(1,u.getNom_user());
                ps.setString(2, u.getPrenom_user());
                ps.setInt(3, u.getAge());
                ps.setInt(4, u.getNumero_tel());
                ps.setString(5, u.getAdresse());
                ps.setString(6, u.getEmail());
                ps.setString(7, pw);
               
                ps.execute();
                System.out.println("Utlisateur ajouté avec succés");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
 

    @Override
    public ObservableList<User> afficherUsers() {
         List<User> users = new ArrayList<>();
        
        String query = "SELECT * FROM user";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                 users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), 
                rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return FXCollections.observableList(users);
    }

    @Override
    public void modifierUser(User u) {
        
       try {
           
           String pw=toHexString(getSHA(u.getPassword()));
           try {
               if (u.getNom_user()!= null) {
                   String  query="UPDATE user SET `nom_user`=?,`prenom_user`=?,`age`=? ,`numero_tel`=?,`email`=?,`password`=?,`adresse`=?,`photo`=? WHERE `id_user`=?";
                   PreparedStatement pstm = cnx.prepareStatement(query);
                   pstm.setInt(10,u.getId_user());
                   pstm.setString(1,u.getNom_user());
                   pstm.setString(2, u.getPrenom_user());
                   pstm.setInt(3, u.getAge());
                   pstm.setInt(4, u.getNumero_tel());
                   pstm.setString(5, u.getEmail());
                   pstm.setString(7, pw);
                   pstm.setString(8, u.getAdresse());
                   pstm.setString(9, u.getPhoto());
                   int i = pstm.executeUpdate();
                   System.out.println(i + " User Updated Successfully");
               }}
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }
            
            catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(ServiceAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

   
    @Override
    public User getUserByEmail(String email) throws SQLException{
         
         String sql="SELECT * FROM user WHERE email='"+email+"'";
        Statement statement = cnx.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(sql);
        User u = new User();
       while(rs.next()){
                u.setId_user(rs.getInt("id_user"));
                u.setNom_user(rs.getString("nom_user"));
                u.setPrenom_user(rs.getString("prenom_user"));
                u.setAge(rs.getInt("age"));
                u.setNumero_tel(rs.getInt("numero_tel"));
                u.setEmail(rs.getString("email"));
                u.setAdresse(rs.getString("adresse"));
                u.setPhoto(rs.getString("photo"));
           
           
            }
       
       return u ; 
        }
    
     @Override
    public User getUserByUsername(String username) throws SQLException {
        String sql="SELECT * FROM user WHERE username='"+username+"'";
        Statement statement = cnx.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(sql);
        User u = new User();
       while(rs.next()){
                u.setId_user(rs.getInt("id_user"));
                u.setNom_user(rs.getString("nom_user"));
                u.setPrenom_user(rs.getString("prenom_user"));
                u.setAge(rs.getInt("age"));
                u.setNumero_tel(rs.getInt("numero_tel"));
                u.setEmail(rs.getString("email"));
                u.setAdresse(rs.getString("adresse"));
                u.setPhoto(rs.getString("photo"));
          
           
            }
       
       return u ; 
        }
    
    

    @Override
    public List<User> getUserByNom(String nom_user) throws SQLException {
          List<User> users = new ArrayList<>();
         String sql="SELECT * FROM user WHERE nom_user='"+nom_user+"'";
        Statement statement = cnx.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(sql);
     
       while(rs.next()){
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), 
                rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11)));
          
            }
       return users; 
    }

    @Override
    public List<User> getUserByStatut(int statut_user) throws SQLException {
        List<User> users = new ArrayList<>();
         String sql="SELECT * FROM user WHERE statut_user='"+statut_user+"'";
        Statement statement = cnx.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(sql);
     
       while(rs.next()){
                  users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), 
                rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11)));
            }
       return users; 
    }

   
    @Override
             public int getIdbyMail(String email) throws SQLException {
            PreparedStatement st = cnx.prepareStatement("select id_user from user where email=?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_user"); 
                           }
        return 0;
             }
             
    @Override
             public int getId() throws SQLException  {
            String sql="SELECT id_user FROM user ";
            Statement statement = cnx.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id =  rs.getInt("id_user"); 
                return id;
                           }
        return 0;
             }

    @Override
    public ObservableList<User> GetListUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Role> GetListRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFirstNamebyId(int idbyMail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
      
    }

   
    
   
