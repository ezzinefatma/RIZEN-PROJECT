/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.wallet;

/**
 *
 * @author HUNTER
 */
public interface IWallet {
     //ajout 
    public void ajouterwallet(wallet x);
    
    //affichage 
     public List<wallet> afficherwallet();
        
    //modifier 
     public void modifier_wallet(wallet x);
        
    //supression
      public void supresionwallet(int x);
    
    // metier et services 
     //achat coins  
    // public int achatSolde(wallet x , int price );
     
    //affichage unitaire
     public List<wallet> afficher_wallet_User(wallet x);
     
     //rechercher wallet
     public void RechercherrWallet(int x); 
    
}
