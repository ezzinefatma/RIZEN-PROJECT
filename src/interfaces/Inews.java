/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import java.util.List;
import javafx.collections.ObservableList;
import model.news;
/**
 *
 * @author OUSSAMA
 */
public interface Inews {
    public ObservableList<news> afficherNews();
    public void ajouterNews(news n);
    public void supprimerNews(int id);
    public void modifierNews(news n);
    public List<news> RechercherParTitre (String titre , String stream);
}
