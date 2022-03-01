/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
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
    public void ModifierStream (stream s);
    //recommanded_list
    public void Recommended_list();
    //search by title
    public List<stream> RechercherParTitre (String titre);
    // search by id 
    public List<stream> RechercherParId (int id);


}

    

