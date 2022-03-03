/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.chat;


/**
 *
 * @author ford_
 */
public interface Ichat {
    //Add
    public void ajouterchat(chat c);
    public void ajouterchat1(chat c);
    
    //List
    public List<chat> afficherchat(); 
    //delete
    public void SupprimerParID_chat(int id_chat);
    // Edit 
    public void Modifierchat (chat c);
    //search by title
    public List<chat> RechercherParUser_Name (String n);
    // search by id 
    public List<chat> RechercherParId (int id);
    //afficher_msg
    public List<chat> afficher_msg();
    
}
