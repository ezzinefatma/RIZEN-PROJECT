/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.ReqEnum;
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
        public void modifier_reclamation(reclamation r);
        public void modifier_admin_rec(reclamation r);
        public void modifier_user_rec(reclamation r);
        
    //supression
      public void supresionReclamation(int r);
      //recherche par stt 
      public void RechercherStat(ReqEnum x);
}
