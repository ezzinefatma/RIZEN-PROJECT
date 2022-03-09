/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.sql.PreparedStatement;
import java.io.FileOutputStream;
import java.io.IOException;
import util.maConnexion;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import com.lowagie.text.Chunk;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;
import model.event;
import model.inscriptionEvent;
import model.news;
/**
 *
 * @author OUSSAMA
 */
public class PDF {
    public static void CreatePDF(List<event> L , User u){
        
         
        Document document = new Document(PageSize.A4);
    try {
      PdfWriter.getInstance(document,
          new FileOutputStream("C:/Users/OUSSAMA/Desktop/"+u.getNom_user()+(int)(Math.random()*100)+".pdf"));
      document.open();
      Image image = Image.getInstance("C:/Users/OUSSAMA/Desktop/logoo.png");
      document.add(image);
      document.addTitle("Lettre de confirmation d'inscrption");
      document.addAuthor("RIZEN Groupe");
      BaseFont fonte = BaseFont.createFont(
          BaseFont.COURIER,
          BaseFont.CP1252,
          BaseFont.NOT_EMBEDDED);
      Font maFonte = new Font(fonte);
      maFonte.setColor(Color.RED);
      maFonte.setStyle(Font.BOLD);
      maFonte.setSize(38.0f);
      document.add(new Paragraph("RIZEN Groupe", 
	    new Font(Font.COURIER, 28, Font.BOLD, Color.RED)));
      Phrase phrase = new Phrase(new Chunk("Mr/Mme "+u.getNom_user()));
      phrase
          .add(new Chunk(
              " votre inscription est bien accepte voila une petite information sur votre events ."));
      document.add(phrase);
       Table tableau = new Table(2,L.size());
       tableau.addCell("Title event");
       tableau.addCell("Date debut");
     for (int i=0 ; i<L.size();i++){
         
      tableau.addCell(L.get(i).getTitre_event());
      tableau.addCell(L.get(i).getDate_debut());
      
      }
      document.add(tableau);
    } catch (DocumentException de) {
      de.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    document.close();
        
    }
    
}
