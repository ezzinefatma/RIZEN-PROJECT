/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;
import model.CoinsGame;
import model.EnumCoins;
import model.wallet;

/**
 *
 * @author HUNTER
 */
public interface IcoinGame {
    
    
    
   public void ajouter(CoinsGame x); 
   public List<CoinsGame> afficher();
   public List<CoinsGame> afficherLigne(int x);
   public List<CoinsGame> afficherRemise();
   public void supresionParLigne(int x); 
   public void modifier_CG(CoinsGame x);
   public void Rolette(wallet x,int z)throws SQLException;
   
   public int wasteOfmoney() throws SQLException;
   

    
}
