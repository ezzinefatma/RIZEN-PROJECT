/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Istreaming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.stream;
import model.stream_category;
import model.react_stream;
import model.status_stream;
import model.user_history;
import util.maConnexion;

/**
 *
 * @author ford_
 */
public class ServiceStream implements Istreaming{
    
    //var
    Connection cnx = maConnexion.getInstance().getCnx();

    @Override
    public void ajouterstream(stream s) {
        String request = "INSERT INTO `stream`(`titre_stream`, `categorie`, `nbr_like`, `nbr_report`, `url`, `id_user`, `status`, `background_pic`, `react`)"
                + " VALUES ('"+s.getTitre_stream()
                +"','"+s.getCategorie()
                +"','"+s.getNbr_like()
                +"','"+s.getNbr_report()
                +"','"+s.getUrl()
                +"','"+s.getId_user()
                +"','"+s.getStatus()
                +"','"+s.getBackground_pic()
                +"','"+s.getReact()
                +"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(request);
            System.out.println("Done !!! stream ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    @Override
  public List<stream> afficherstream() {
        List<stream> streams = new ArrayList<>();
        
        //String query = "SELECT stream.id_stream, stream.titre_stream, stream.categorie, stream.nbr_like, stream.nbr_report, stream.url, stream.status, stream.background_pic,stream.react, user.nom_user FROM stream INNER JOIN user ON stream.id_stream=user.id_user";
             String query = " SELECT * FROM `stream`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {             
                streams.add(new stream(rs.getInt(1), rs.getString(2),stream_category.valueOf(rs.getString(3)), rs.getInt(4), rs.getInt(5) , rs.getString(6), rs.getInt(7),status_stream.valueOf(rs.getString(8)),rs.getString(9),react_stream.valueOf(rs.getString(10))));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    return streams;
    }

    @Override
  public void ajouterstream1(stream s) {
String Req = "INSERT INTO `stream`(`titre_stream`, `categorie`, `nbr_like`, `nbr_report`, `url`, `id_user`,`status`, `background_pic`, `react`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(Req);
            ps.setString(1, s.getTitre_stream());
            
            ps.setString(2,s.getCategorie().name());   
            ps.setInt(3, s.getNbr_like());
            ps.setInt(4, s.getNbr_report());
            ps.setString(5, s.getUrl());
            ps.setInt(6, s.getId_user());
            ps.setString(7,s.getStatus().name());
            ps.setString(8,s.getBackground_pic());
            ps.setString(9,s.getReact().name());
             ps.execute();
            System.out.println("done  : stream ajoutee avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
  

}
  
    @Override
    public void SupprimerParID(int id_stream){
    try{
    String query="DELETE FROM `stream` WHERE id_stream="+id_stream;
    Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done!! stream bien supprime ");
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }
    
    @Override
            public void ModifierStream (stream s){
        try{
        
       String query="UPDATE `stream` SET `titre_stream`='"+s.getTitre_stream()
               +"',`categorie`='"+s.getCategorie()
               +"',`nbr_like`='"+s.getNbr_like()
               +"',`nbr_report`='"+s.getNbr_report()
               +"',`url`='"+s.getUrl()
               +"',`id_user`='"+s.getId_user()
               +"',`url`='"+s.getStatus()
               +"',`url`='"+s.getBackground_pic()
               +"',`url`='"+s.getReact()
               +"' WHERE id_stream="+s.getId_stream();
        Statement st = cnx.createStatement();
    st.executeUpdate(query);
        System.out.println("Done. stream bien modifier ");
        }catch(SQLException e){
        System.out.println(e.getMessage());
    
    }     
        }
    
  public void afficher_un_stream(int id) {
        
        
        String query = "SELECT * FROM stream WHERE id_stream="+id;
         
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
            System.out.println("titre de stream=" + rs.getString(2));
            System.out.println("categorie=" + stream_category.valueOf(rs.getString(3)));
            System.out.println("nbr like =" + rs.getInt(4));
            System.out.println("report nbr =" + rs.getInt(5));
            System.out.println("url=" + rs.getString(6));
            System.out.println("user id=" + rs.getInt(7));
            System.out.println("status=" + status_stream.valueOf(rs.getString(8)));
            System.out.println("background_pic=" + rs.getString(9));
            System.out.println("react=" + react_stream.valueOf(rs.getString(10)));
            
            
       
         }
            // ajouter 1 row sur la table de history 
            
            String Req = "INSERT INTO `user_stream_history`(`id_user`, `stream_id`, `streamer_id`) SELECT `id_user`,`id_stream`,`id_user` from `stream` where id_stream="+id ;
                    PreparedStatement ps = cnx.prepareStatement(Req);
                    ps.execute();
           /* 
             ps.setInt(1,rs.);
            ps.setInt(2,rs.getInt(3));   
            ps.setInt(3, rs.getInt(4));
              */
            System.out.println("done  : historique ajoutee avec succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
      
    }   


//recommended list by Highest like nbr
  
public List<stream> Recommended_list1(){

List<stream> rec1_streams = new ArrayList<>();

String q ="select * from (select * from stream order by nbr_like desc LIMIT 3) as top_3_stream";

 try {
   
              Statement s = cnx.createStatement();
              ResultSet rs = s.executeQuery(q);
             while (rs.next()) {
            rec1_streams.add(new stream(rs.getInt(1), rs.getString(2), stream_category.valueOf(rs.getString(3)), rs.getInt(4), rs.getInt(5) , rs.getString(6), rs.getInt(7),status_stream.valueOf(rs.getString(8)),rs.getString(9),react_stream.valueOf(rs.getString(10))));

             //int y =rs.getInt(1);
             }

} catch (SQLException ex) {
            ex.printStackTrace();
    }
        return rec1_streams;
 
    }


 //afficher le streamer le plus regardé on se basant sur l'historique
         public List<stream> Recommended_list2() {
        List<stream> rec_streams = new ArrayList<>();
        
        
             
        String q1 ="select streamer_id  from user_stream_history group by streamer_id order by count(*) desc limit 1";
         try {
            
              Statement s = cnx.createStatement();
              ResultSet r = s.executeQuery(q1);
             while (r.next()) { 
             int x =r.getInt(1);
             
                   
        String query = "SELECT * FROM stream where id_user="+x;
        
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {                
                rec_streams.add(new stream(rs.getInt(1), rs.getString(2), stream_category.valueOf(rs.getString(3)), rs.getInt(4), rs.getInt(5) , rs.getString(6), rs.getInt(7),status_stream.valueOf(rs.getString(8)),rs.getString(9),react_stream.valueOf(rs.getString(10))));
            }
           
             }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
    }
        return rec_streams;
  

    }
   


//recommended list by Highest like nbr for  each category
         
    public  List<stream> Recommended_list3()  {
    List<stream> rec2_streams = new ArrayList<>();
    
    
    //boucle for  pour parcourir tout les categorie 
    for (stream_category cat : stream_category.values())
    { 
   
String q ="SELECT * from stream where nbr_like=(select MAX(nbr_like) from stream WHERE categorie LIKE '"+cat+"')";

 try {
   
              Statement s = cnx.createStatement();
              ResultSet rs = s.executeQuery(q);
             
             int x= rs.getRow();
              
              
             while (rs.next()) {
            rec2_streams.add(new stream(rs.getInt(1), rs.getString(2), stream_category.valueOf(rs.getString(3)), rs.getInt(4), rs.getInt(5) , rs.getString(6), rs.getInt(7),status_stream.valueOf(rs.getString(8)),rs.getString(9),react_stream.valueOf(rs.getString(10))));

             //int y =rs.getInt(1);
             }

} catch (SQLException ex) {
            ex.printStackTrace();
    }

                                       }//for
    
                     return rec2_streams;
                                               }  
    
   
  // recommanded list by must  viewed   category on stream_history 
   public  List<stream> Recommended_list4()
    {    
        
        List<stream> rec_streams = new ArrayList<>();
                String q1 ="select stream_id  from user_stream_history";
try {
            
              Statement s = cnx.createStatement();
              ResultSet r = s.executeQuery(q1);
             while (r.next()) { 
             int x =r.getInt(1);
             
             String query = "SELECT categorie FROM stream where id_stream="+x;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
        
            while (rs.next()) {                
             stream_category cat = stream_category.valueOf(rs.getString(1));
            stream_category st_cat;
             int a = 0,b=0,c=0,d=0,e=0,f=0,g =0;
               switch (cat) {
            case Action:
            a++;
                 break;
            case Adventure:
            b++;
                 break;
            case E_sport:
            c++;
                 break;
            case FPS:
            d++;
                 break;
            case Racing:
            e++;
                 break;
            case Role_Playing:
            f++;
                 break;
            case Strategy:
            g++;
                 break;
    } 
            int max =Math.max(g,(Math.max(f,(Math.max(e,(Math.max(Math.max(a, b), Math.max(c, d))))))));
            if (max==a){ 
                st_cat = stream_category.Action;
                 } else if
                         (max==b)
                     st_cat = stream_category.Adventure;
                 else if
                         (max==c)
                     st_cat = stream_category.E_sport;
                 else if
                         (max==d)
                     st_cat = stream_category.FPS;
                 
                 else if
                         (max==e)
                     st_cat = stream_category.Racing;
                 
                 else if
                         (max==f)
                     st_cat = stream_category.Role_Playing;
                 
                 
                 
                 
                 
                 //  rec_streams.add(new stream( stream_category.valueOf(rs.getString(1))));
                 
                 else {
                     st_cat = stream_category.Strategy;
                 }
            
        String q2="select * from stream WHERE categorie='"+st_cat+"' ORDER BY nbr_like desc limit 3";
            
            try {
            Statement st1 = cnx.createStatement();
            ResultSet rs1 = st1.executeQuery(q2);
            while (rs1.next()) {   
            
                   rec_streams.add(new stream(rs1.getInt(1), rs1.getString(2), stream_category.valueOf(rs1.getString(3)), rs1.getInt(4), rs1.getInt(5) , rs1.getString(6), rs1.getInt(7),status_stream.valueOf(rs1.getString(8)),rs1.getString(9),react_stream.valueOf(rs1.getString(10))));

            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  

            } 
            }catch (SQLException ex) {
            ex.printStackTrace();
        }  
        }        }catch (SQLException ex) {
            ex.printStackTrace();
        }    

             
            
    
        return rec_streams;
  
                     } 
    
// concatinée les 3 methodes 
         @Override
         public void Recommended_list() {
             ArrayList recommanded = new ArrayList();
            recommanded.addAll(Recommended_list1());
            recommanded.addAll(Recommended_list2());
             System.out.println("\n recommanded");
             
            System.out.println(recommanded);
        }
         
         
         // search by title 
         
    @Override
       public List<stream> RechercherParTitre (String titre) 
      {  
          
          List<stream> streams = new ArrayList<>();
          String query = "SELECT `titre_stream`, `categorie`, `nbr_like`, `nbr_report`, `url`, `id_user`,`status`, `background_pic`, `react` FROM stream WHERE titre_stream like'%"+ titre +"%'";
        
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
              // int  nbrRow = rs.getRow();
             
                  while (rs.next()) {   
                      
                streams.add(new stream( rs.getString(1), stream_category.valueOf(rs.getString(2)), rs.getInt(3), rs.getInt(4) , rs.getString(5), rs.getInt(6),status_stream.valueOf(rs.getString(7)),rs.getString(8),react_stream.valueOf(rs.getString(9))));
            
                  }
                         
            }catch(SQLException ex) {
        }
         
              return streams;     
         }

    /**
     *
     * @param id
     * @return
     */
    @Override
       public List<stream> RechercherParId (int id) 
              {  
          
          List<stream> stream_id = new ArrayList<>();
          String query = "SELECT `titre_stream`, `categorie`, `nbr_like`, `nbr_report`, `url`, `id_user`,`status`, `background_pic`, `react` FROM stream WHERE  id_stream="+id;
        
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
              // int  nbrRow = rs.getRow();
             
                  while (rs.next()) {   
                      
                stream_id.add(new stream( rs.getString(1), stream_category.valueOf(rs.getString(2)), rs.getInt(3), rs.getInt(4) , rs.getString(5), rs.getInt(6),status_stream.valueOf(rs.getString(7)),rs.getString(8),react_stream.valueOf(rs.getString(9))));
            
                  }
                         
            }catch(SQLException ex) {
        }
         
              return stream_id;
        
              
         }

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
             }
         
        

         
    

