/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pidev;

import interfaces.ICoins;
import interfaces.IWallet;
import interfaces.Irec;
import java.sql.Connection;
import model.Coins_history;
import model.Panier;
import model.Produit;
import model.Promotion;
import model.ReqEnum;
import model.User;
import model.chat;
import model.commentaire;
import model.event;
import model.news;
import model.publication;
import model.reclamation;
import model.stream;
import model.wallet;
import services.ServiceChat;
import services.ServiceEvent;
import services.ServiceNews;
import services.ServicePanier;
import services.ServiceProduit;
import services.ServicePromotion;
import services.ServiceStream;
import services.ServiceUser;
import services.ServiceWallet;
import services.Servicereclamation;
import services.coinService;
import services.servicecommentaire;
import services.servicepublication;
import util.maConnexion;

/**
 *
 * @author Fatma
 */
public class Pidev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Connection cnx=maConnexion.getInstance().getCnx();


 /**************wallets & reclamations**********************/
 
        //Servicereclamation sr = new Servicereclamation();
        ICoins cs = new coinService ();
        ServiceWallet sw =new ServiceWallet();
        coinService rb3c = new coinService();
        wallet r = new wallet ("6316951203258605",100,"20/11",1);
        wallet rr = new wallet ("6426951203258806",010,"10/12",2);
        //reclamation rabi3 =new reclamation(ReqEnum.en_cours, 3);

     //sw.achatSolde(sw.afficherwallet().get(0),300000);
    // sw.transfer_coins(sw.afficherwallet().get(0), sw.afficherwallet().get(2));
      
         //sw.afficherwallet();
         //cs.affichehystory();
        //sw.ajouterwallet(rabi3);
           //sw.achatSolde(rabi3,300000);
           //sw.achatSolde(rabi3,100000);
           //sw.afficher_wallet_User(rabi3);
           //sw.achatSolde(sw.afficherwallet().get(2),300000);

           //sw.afficher_wallet_User(rrr);
          // sw.transfer_coins(sw.afficherwallet().get(2), sw.afficherwallet().get(2));
          //cs.filterhystory(3);
         // cs.affichehystory();
           
        //Servicereclamation ic = new Servicereclamation();
       // ic.afficherReclamation();
      // ic.ajouterReclamation(rcc);
        //ic.RechercherStat(ReqEnum.en_cours);
        
         //rb3c.filterhystory(3);

     //sw.achat(rabi3,10000);
     //sw.achat(rabi3,10000);
    // sw.achat(rabi3,10000);
     //sw.afficher_wallet_User(rabi3);
     //sw.achat(r, 10000);
     //sw.achat(rabi3,10000);
     //sw.achat(rabi3,10000);
     //sw.achatSolde(sw.afficherwallet().get(2),300000);//tziid
        //System.out.println(rabi3.getSolde());
     //sw.afficher_wallet_User(rabi3); 
     //sw.achatSolde(sw.afficher_wallet_User(rabi3).get(0), 100000); //t3awedh
     //wallet rabi3w = sw.afficher_wallet_User(rr);
     
      
 
        
       

 
        
     
  
        
        
        
        
        
        
 
                
                
 
    
}
}
