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

    /**
     *
     * @return
     */
     public List<wallet> afficherwallet();
        
    //modifier 
        public void modifier_wallet(wallet x);
       // public void modifier_wallet_user(wallet w);
        
    //supression
      public void supresionwallet(int x);
    
}
