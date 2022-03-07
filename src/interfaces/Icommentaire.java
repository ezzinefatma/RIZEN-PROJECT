/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.commentaire;

/**
 *
 * @author ASUS
 */
public interface Icommentaire {
    //Add

    /**
     *
     * @param com
     */
    public void ajouterCommentaire(commentaire com);
    
    /**
     *
     * @param id_com
     */
    public void SupprimerParID(int id_com);
     public List<commentaire> afficherCommentaire();
public void modifiercommentaire (commentaire com );




}
