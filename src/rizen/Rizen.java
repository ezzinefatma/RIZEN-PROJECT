/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rizen;

import model.chat;
import model.status_stream;
import model.stream;
import model.stream_category;
import services.ServiceStream;
import services.ServiceUserHistory;

/**
 *
 * @author ford_
 */
public class Rizen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


 /**************stream**********************/
                     
  
  
  
        ServiceStream st = new ServiceStream();
        
       //streams
        stream s1 = new stream ("vinisus_fifa_22",stream_category.E_sport,2530,0,"wwww.youtube.com/shroud",1,status_stream.online,"link");
        stream s2 = new stream("ninja_pubg",stream_category.FPS,2530,60,"wwww.youtube.com/shroud",2,status_stream.online,"link");
          
        /*************recherche**********/
         // by title
       // System.out.println(st.RechercherParTitre("gg"));
        // by id
        //System.out.println(st.RechercherParId(9));
        
        //ajouter first_methode;
          //st.ajouterstream(s1);
        //ajouter 2 eme methode ;
              //st.ajouterstream1(s2);
              //Afficher list stream
          //  System.out.println(st.afficherstream());
            
        //Afficher un stream
         System.out.println(st.afficher_un_stream(46)); 
        
        //Delete
            //st.SupprimerParID(15);
        //Edit
        
        //stream s2modifier = new stream ("error",stream_category.Strategy,"wwww.youtube.com/shroud",status_stream.offline,"link");
          //st.ModifierStream(s2modifier,45);
       
         
        
        /************* Recomanded List ************/
          //System.out.println(st.Recommended_list1());
         //System.out.println(st.Recommended_list2());
         //System.out.println(st.Recommended_list3());
       //System.out.println(st.Recommended_list4(st.Recommended_list4_1()));
        
        //st.sys_info();
          //st.Recommended_list();
      
                // chat Service  : 
         //ServiceChat ch = new ServiceChat();
          
         chat c1 = new chat ("good game",1,1,12520);
         chat c2 = new chat("bonjour ",2,2,18000); 
         chat c2modifier = new chat (3,"shroud gg !!!",2,2,0);

         
         
         //Ichat c3 = (Ichat) new chat("good game",1,1,12520);
         //Ichat ch = new ServiceChat();
         
             //System.out.println(ch.afficher_msg());
           //ADD_first_Method
                //ch.ajouterchat(c1);
         //ADD_second_Method
               // ch.ajouterchat1(c2);
         //afficher chat
              // System.out.println(ch.afficherchat());
          //Delete_chat
                        
                      /*
          
          System.out.println(ch.afficherchat());
          System.out.println("*********************");
            ch.SupprimerParID_chat(2);
          System.out.println("*********************");

          System.out.println(ch.afficherchat()); 
                       */
          
                                
        //Edit_chat
                        /*          
        System.out.println(ch.afficherchat());
        System.out.println("*********************");
        
        
        
               ch.Modifierchat(c2modifier);   
             
        System.out.println("*********************");
        System.out.println(ch.afficherchat());
          
                        */
        
              //search by id / by Name
              
              
         //  System.out.println(ch.RechercherParId(4));             
           //  System.out.println(ch.RechercherParUser_Name("shroud"));           


   // **************service history***************//
   
   
        ServiceUserHistory his= new ServiceUserHistory();
        
        
        System.out.println(his.afficherhistory());    
        //his.Supprimer_his_ParID(1);
        //his.Supprimer_tous();
           // st.sys_info();




    }
    
}
