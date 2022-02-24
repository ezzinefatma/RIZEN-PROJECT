/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pidev;

import java.sql.Connection;
import model.Coins_history;
import model.Panier;
import model.Produit;
import model.Promotion;
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
        coinService cs = new coinService ();
        ServiceWallet sw =new ServiceWallet();
        Servicereclamation sr = new Servicereclamation();
        wallet r = new wallet ("6316951203258605",100,"20/11",1);
        wallet rr = new wallet ("6426951203258806",010,"10/12",2);
        wallet rrr = new wallet ("7536951203258907",001,"03/01",3);
        //sw.ajouterwallet(r);
        //sw.ajouterwallet(rr);
        //sw.ajouterwallet(rrr);
        //reclamation rq = new reclamation("question","iwant to see my wallet history ",2);
       // sr.ajouterReclamation(rq);
       // sr.afficherReclamation();
        /*
       User us = new User("test","test",55,71589,"@@@@@@@@@","dfghjklm","dfghjklm");
        ServiceUser sr = new ServiceUser();

        coinService cs = new coinService();
        //cs.affichehystory(us);
        cs.supresionHystory(3);*/
        
     
       // sw.achatSolde(r,10000);
        //sw.afficher_wallet_User(r);
        //cs.affichehystory();
        //sw.achatSolde(r, 10000);
        //sw.achatSolde(r, 300000);
        //sw.achatSolde(sw.afficherwallet().get(0),10000);
        
        //sw.achatSolde(sw.afficherwallet().get(1),300000); 
       // sw.achatSolde(sw.afficherwallet().get(2),100000); // 1000
       // sw.achatSolde(sw.afficherwallet().get(0),300000); //5300
       // sw.achatSolde(sw.afficherwallet().get(1),10000); //5100
      /* sw.afficher_wallet_User(r);
       sw.afficher_wallet_User(rr);
       sw.afficher_wallet_User(rrr);*/
       
       //sw.achatSolde(sw.afficherwallet().get(2),100000); // 1000
       sw.achatSolde(sw.afficherwallet().get(1),10000); //5100
       //sw.achatSolde(sw.afficherwallet().get(0),10000); //5100
       //sw.supresionwallet(1000);
       //sw.RechercherrWallet(2);
       cs.filterhystory(2);
       
     //  sw.afficher_wallet_User(r);
        
        
        
        
        
        
        
 
                
                
 
    
}
}
