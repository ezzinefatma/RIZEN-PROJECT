/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import services.serviceInscription;
import interfaces.Iinscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.event;
import model.inscriptionEvent;
import util.maConnexion;
import model.User;
import model.event;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author OUSSAMA
 */
public class serviceInscription implements Iinscription{
    
          Connection cnx = maConnexion.getInstance().getCnx();

          public static void SendMail(User u) {

        // Recipient's email ID needs to be mentioned.
        String to = u.getEmail();

        // Sender's email ID needs to be mentioned
        String from = "runtimepidev@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("runtimepidev@gmail.com", "pidevpidev");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("bonjour Mr/Mme "+u.getNom_user());

            // Now set the actual message
            message.setText("votre inscription est bien enregistrer !!!");
            message.setFileName("‪Sebai99.pdf");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
          
          public int calculeNbrInsc(event e) {
   int nbr = 0;
   String query = "select count(*) from inscription_event where id_event="+e.getId_event();
   try {
   Statement st = cnx.createStatement();
   ResultSet rs = st.executeQuery(query);
   while (rs.next()){
    nbr = rs.getInt(1); 

   }
   }
   catch(SQLException ex){
   ex.printStackTrace();
   }
   return nbr;
          }
          @Override
    public void ajouterInscription(event e , User u){
         String Req = "INSERT INTO `inscription_event`(`id_usr`,`id_event`) VALUES (?,?)";
        int nbr=0;
       try {
           int nbrr = calculeNbrInsc(e);
           if(nbrr<e.getCapacite()){
          Statement st = cnx.createStatement();
           PreparedStatement ps = cnx.prepareStatement(Req);
           ps.setInt(1, u.getId_user());
           ps.setInt(2, e.getId_event());
           ps.execute();
           System.out.println("inscription avec sucess !!!");
           List<inscriptionEvent> Liste = new ArrayList<>();
        String Reqq = "select * from inscription_event where id_usr="+u.getId_user();
      try {
            ResultSet rs = st.executeQuery(Reqq);
             
                  while (rs.next()) {   
                  
                Liste.add(new inscriptionEvent(rs.getInt(1),rs.getTimestamp(2),rs.getInt(3),rs.getInt(4)));
            
                  }
                  
                         
            }catch(SQLException ex) {
        }
      List<event> Liste2 = new ArrayList<>();
      for(int i = 0 ; i<Liste.size();i++)
      {
        
        String Reqqq = "select * from event where id_event="+Liste.get(i).getId_event();
      try {
            ResultSet rs = st.executeQuery(Reqqq);
             
                  while (rs.next()) {   
                
                Liste2.add(new event (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
                 
                  }
                  
                         
            }catch(SQLException ex) {
        }
      }
           PDF.CreatePDF(Liste2 ,u);
           SendMail(u);
           }
           else System.out.println("l'event est plain !!!!!");
       } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
        
    }
    
}
