/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import model.User;

/**
 *
 * @author Fatma
 */
public interface Iuser {
    
    //ADD

    public void addUser(User u);
    public boolean login(String email,String password)throws Exception ;
   public ObservableList<User> afficherUsers();
    //Update 
    public void modifierUser (User u);
    //Login
    public int getIdbyMail(String email) throws SQLException ;
    public int getId() throws SQLException ;
    public void UpdatePassword(String email, String password)throws Exception;

    public String getFirstNamebyId(int idbyMail);
    public User getByEmail(String email );
    
    
}
