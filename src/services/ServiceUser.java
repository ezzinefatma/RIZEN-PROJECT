/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Iuser;
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
import model.User;
import static util.Pwd.getSHA;
import static util.Pwd.toHexString;
import util.maConnexion;

/**
 *
 * @author Fatma
 */
public class ServiceUser implements Iuser{
    
    Connection cnx = maConnexion.getInstance().getCnx();  
    List<User> Users=new ArrayList();
    
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
                            int id=rs.getInt("id_user");
                            String nom=rs.getString("nom_user");
                            String prenom=rs.getString("prenom_user");
                            int age= rs.getInt("age");
                            int phone =rs.getInt("numero_tel") ;
                            String adress=rs.getString("adresse");
                            UserSession.getInstace(id,nom,prenom,age,phone,adress, email, password);
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
                System.out.println("User Added Succesfully");
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
                   String  query="UPDATE user SET `nom_user`=?,`prenom_user`=?,`age`=? ,`numero_tel`=?,`adresse`=?,`photo`=? WHERE `id_user`=?";
                   PreparedStatement pstm = cnx.prepareStatement(query);
 
                   pstm.setString(1,u.getNom_user());
                   pstm.setString(2, u.getPrenom_user());
                   pstm.setInt(3, u.getAge());
                   pstm.setInt(4, u.getNumero_tel());
                   pstm.setString(5, u.getAdresse());
                   pstm.setString(6, u.getPhoto());
                   pstm.setInt(7,u.getId_user());
                   int i = pstm.executeUpdate();
                   System.out.println(i + " User Updated Successfully");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
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
    public void UpdatePassword(String email, String password) throws Exception{
       
       String  pw = toHexString(getSHA(password));
       
       String sql= "UPDATE user SET `password`='"+ pw +"'"+"WHERE `email`='"+ email+"'";
       PreparedStatement statement = cnx.prepareStatement(sql);
       int rowsUpdated = statement.executeUpdate(sql);
       if (rowsUpdated > 0) {
             System.out.println("password updated successfully!");
         }
    }    

    @Override
    public String getFirstNamebyId(int idbyMail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
   

 
}
    
    
    

    

