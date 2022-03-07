/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Promotion;

/**
 *
 * @author MSI
 */
public interface Ipromotion {

    /**
     *
     * @param p
     */
    public void ajouterpromotion(Promotion p); 

    /**
     *
     * @return
     */
    public List<Promotion > afficherpromotion();
      public void modifierpromotion(Promotion p);
      public void supppromotion(Promotion p);

}
