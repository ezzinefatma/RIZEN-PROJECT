/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import java.util.List;
import model.event;
/**
 *
 * @author OUSSAMA
 */
public interface Ievent {
    public List<event> afficherEvent();
    public void ajouterEvent(event e);
    public void supprimerEvent(int id);
    public void modifierEvent(event e);
    public List<event> afficherEvents();
}
