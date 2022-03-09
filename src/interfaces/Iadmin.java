/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import model.Role;
import model.User;

/**
 *
 * @author Fatma
 */
public interface Iadmin extends Iuser{
    
    public boolean Banned(User u);
    public ObservableList<User> GetListUsers();
    public ObservableList<Role> GetListRoles();
    public User getUserByEmail(String email)throws SQLException;
    public User getUserByUsername(String username)throws SQLException;
    public List<User> getUserByNom(String nom_user)throws SQLException;
    public List<User> getUserByStatut(int statut_user)throws SQLException;
    
    
}
