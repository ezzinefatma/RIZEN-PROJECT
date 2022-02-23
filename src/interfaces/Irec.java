/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.reclamation;

/**
 *
 * @author HUNTER
 */
public interface Irec {
        //ajout 
    public void ajouterReclamation(reclamation r);
    
    
    //affichage 
     public List<reclamation> afficherReclamation();
        
    //modifier 
        public void modifierUser_rec(reclamation r);
       // public void modifieradmin_rec(reclamation r);
        
    //supression
      public void supresionReclamation(int r);
}
