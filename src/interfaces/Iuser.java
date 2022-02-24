/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.User;

/**
 *
 * @author Fatma
 */
public interface Iuser {
    
    //ADD
    public void  ajouterUser(User u);
    
    //LIST 
    public List<User> afficherUsers();
    
    //Update 
    public void modifierUser (User u);
    
    //Login
    
   // public boolean login(String email,String password)throws Exception ;
    
    
    
}
