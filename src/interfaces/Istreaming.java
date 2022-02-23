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
}

    

