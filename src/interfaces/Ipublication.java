/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.User;
import model.publication;

/**
 *
 * @author ASUS
 */
public interface Ipublication {


  //Add
    public void ajouterPublication(publication pub);
    
    
    public void SupprimerParID(int id_pub);
    public List<publication> afficherPublication();
    public void modifierpublication (publication pub,int id);

     public List<publication>RechercherParId(int id);
     public List<publication>RechercherParcontent(String content_pub);
      public List<publication> PublicationSuperieur();
     // public List<publication> SeulementPublication();
    
}
