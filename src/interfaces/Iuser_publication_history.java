/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.publication;

/**
 *
 * @author ASUS
 */
public interface Iuser_publication_history {
    
        public void ajouterPublication(publication pub);
        public void SupprimerParID(int id_pub);
        public List<publication>RechercherParId(int id);


    
}
