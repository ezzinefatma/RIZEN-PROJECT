/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.user_history;

/**
 *
 * @author ford_
 */
public interface Iuser_history {
    
    //List
    public List<user_history> afficherhistory(); 
    //delete
    public void SupprimerParID(int history_id);
    // delete_all
   public void Supprimer_tous();
    
}
