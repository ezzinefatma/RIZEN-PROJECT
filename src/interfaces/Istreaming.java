/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.io.IOException;
import java.util.List;
import model.User;
import model.stream;

/**
 *
 * @author ford_
 */
public interface Istreaming {
    
    //Add
    public void ajouterstream(stream s);
    public void ajouterstream1(stream s);
    //List
    public List<stream> afficherstream(); 
    
    //delete
    public void SupprimerParID(int id_stream);
    // Edit 
    public void ModifierStream (stream s,int id);
    //recommanded_list
    public void Recommended_list();
    //search by title
    public List<stream> RechercherParTitre (String titre);
    // search by id 
    public List<stream> RechercherParId (int id);
public void sys_info() throws IOException;

}

    

