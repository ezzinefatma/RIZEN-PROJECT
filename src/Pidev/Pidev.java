/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pidev;

import java.sql.Connection;
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
import services.ServiceAdmin;
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
import services.servicecommentaire;
import services.servicepublication;
import static util.Pwd.getSHA;
import static util.Pwd.toHexString;
import util.MaConnexion;
import util.SendMail;

/**
 *
 * @author Fatma
 */
public class Pidev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
      
       Connection cnx=MaConnexion.getInstance().getCnx();
       //SendMail.send("oussamaesprit1@gmail.com",0);
        //User
      User u1 = new User ("Ben nasr", "Fatma", 22, 22345678,"fatmanaser@gmail.com","fatma_avatar","mypassword","rue sculpture nabeul","photo fatima",1);
      User u2 = new User ("Ben nasr", "Ghada", 30, 22347178,"ghadanaser@gmail.com","ghada_avatar","pwd123","rue jasmin tunis","photo ghada",0);

        //Service
        ServiceUser sp = new ServiceUser();
        ServiceAdmin sa= new ServiceAdmin();
        
     
        //Ajouter
     // sp.ajouterUser(u1);
    //  sp.ajouterUser(u2);
       /* System.out.println("\n" + sa.Banned(u1));

        System.out.println("************Get by Email************");
        System.out.println("\n" + sa.getUserByEmail("ghadanaser@gmail.com"));
         System.out.println("************Get by Username************");
        System.out.println("\n" + sa.getUserByUsername("ghada_avatar"));
        System.out.println("************Get by Nom************");
        System.out.println("\n" + sa.getUserByNom("Ben nasr"));
        System.out.println("************Get by Statut************");
        System.out.println("\n" + sa.getUserByStatut(1));
        
       
        
        
        
        //Modifier
       // sa.modifierUser(new User (1,"Ben nasr", "Fatma", 22, 22345678,"fatmanaser@gmail.com","fatma_shoto","pwd","rue sculpture nabeul","photo fatima","User",1));
        
        //Afficher
       // System.out.println(sp.afficherUsers());
        
       //lOGIN
       
       sa.login("ghadanaser@gmail.com","ps");
     
     */
                /**************POSTS**********************/
        /*        
        //Service
       servicepublication sp = new servicepublication();
      servicecommentaire sc = new servicecommentaire();
        //publication
       publication pub = new publication("salut", "16/03/2020", 55, 1);
      //publication pub1 = new publication(1,"Salut comment cava ?", "17/02/2022", 55, 1);
       
       //commentaire
       // commentaire com = new commentaire("cava et toi ?", "16/02/2022", 1);
      //  System.out.println(sc.afficherCommentaire());
         //Ajouter
         // sc.ajouterCommentaire(com);
            sp.ajouterPublication(pub);
            //  sp.modifierpublication(pub1);
            System.out.println(sp.afficherPublication());
         // delete
        // sc.SupprimerParID(4);
        //  sp.SupprimerParID(7);
       // commentaire com_edit = new commentaire(1,"Nn ", "10/02/2020", 1);
     //  sc.modifiercommentaire(com_edit);
     
     */
     /************************produits*************************/
     
   /*
 Produit s = new Produit("Hardware","hyperX","hyperX",25.f,"done","image","En Stock",7.f,3);
       //  Produit s3_edit = new Produit(1,"Hardware","jk","t",2.f,"done","image","En Stock",75.f,3);
         ServiceProduit sp = new ServiceProduit();
        sp.ajouterproduit(s);
        
          //sp.modifierproduit(s3_edit);
        
     // sp.suppproduit(s3_edit);
       
        
        //Afficher
   //  System.out.println( sp.afficherproduit());
   /*Promotion p = new Promotion(2,"7/8/2020","01/10/2021",20);
         Promotion p1 = new Promotion(1,1,"8/8/2020","01/10/2021",30);
        
         ServicePromotion spp = new ServicePromotion();
        spp.ajouterpromotion(p);
        
         // spp.modifierpromotion(p1);
        
      // spp.supppromotion(p1);
        /*
        
        //Afficher
   /* System.out.println( spp.afficherpromotion());
     Panier s1 = new Panier(1,1,315);
         Panier s3 = new Panier(1,1,3);
         ServicePanier sppp = new ServicePanier();
        //sp.ajouterpanier(s);
        
        // sp.modifierpanier(s3);
        
      //sp.supppanier(s);
        
        
        
        //Afficher
   System.out.println( sppp. afficherpanier());
     
*/




 /**************wallets & reclamations**********************/
 /*
 Servicereclamation sr = new Servicereclamation();
       ServiceWallet sw =new ServiceWallet();
        wallet rr = new wallet (50,"*************",301,"12/04",1);
         reclamation rq = new reclamation("cool","its done ","resolue",1);
        sr.ajouterReclamation(rq);
        sr.afficherReclamation();
       // sr.supresionReclamation(2);
      //sw.ajouterwallet(rr);
          //   sw.afficherwallet();
 */
  /**************stream**********************/
                     
  
  
  
  //ServiceStream st = new ServiceStream();
        
       /* //streamer
        stream s1 = new stream ("vinisus_fifa_22","esports",2530,0,"wwww.youtube.com/shroud",1);
        stream s2 = new stream("ninja_pubg","fps",2530,60,"wwww.youtube.com/shroud",2);
          
        //ajouter first_methode
          st.ajouterstream(s1);
        //ajouter 2 eme methode 
              //st.ajouterstream1(s2);
        //Afficher
            System.out.println(st.afficherstream());
        
        //Delete
            //st.SupprimerParID(8);
        //Edit
        /*
        stream s2modifier = new stream (5,"shroud_pubg","esports",2530,0,"wwww.youtube.com/shroud",2);
          st.ModifierStream(s2modifier);
         ServiceChat ch = new ServiceChat();
          
         chat c1 = new chat ("good game",1,1,12520);
         chat c2 = new chat("bonjour ",2,2,18000); 
         
         */

        // chat Service  : 
/*

           //ADD_first_Method
                ch.ajouterchat(c1);
         //ADD_second_Method
                ch.ajouterchat1(c2);
         //afficher chat
             System.out.println(ch.afficherchat());
          //Delete_chat
                        
          
          
          System.out.println(ch.afficherchat());
          System.out.println("*********************");
            ch.SupprimerParID_chat(2);
          System.out.println("*********************");

          System.out.println(ch.afficherchat()); 
          
          
                                
        //Edit_chat
                                 
        System.out.println(ch.afficherchat());
        System.out.println("*********************");
        
        chat c2modifier = new chat (3,"shroud gg !!!",2,2,0);
        
               ch.Modifierchat(c2modifier);   
             
        System.out.println("*********************");
        System.out.println(ch.afficherchat());
          
    }          
  
  */
  
                                             
                                 
         /***********************event*************/
                               
      /*  ServiceEvent se = new ServiceEvent();
        ServiceNews sn = new ServiceNews();
        event e1 = new event("fifa","02/02/2020","02/03/2020","C:/image/img.png","fifa event",20,"meet");
        event e2 = new event (3,"gta","14/02/2022","16/02/2022","C:/image/img.png","gta event",30,"meet");
        news n1 = new news("titre news", "contenu news");
        news n2 = new news(2,"titrenews","contenu news");
        se.ajouterEvent(e1);
        //se.supprimerEvent(2);
        
        //se.modifierEvent(e2);
        System.out.println(se.afficherEvent());
        //System.out.println(sn.afficherNews());
        //sn.ajouterNews(n1);
        //sn.supprimerNews(1);
        //sn.modifierNews(n2);
             */
 
    }
    
}
