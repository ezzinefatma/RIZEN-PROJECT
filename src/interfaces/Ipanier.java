/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Panier;

/**
 *
 * @author MSI
 */
public interface Ipanier {
    public void ajouterpanier(Panier s);

    /**
     *
     * @return
     */
    public List<Panier> afficherpanier();
      public void modifierpanier(Panier s);
      public void supppanier(Panier s);
      
}
