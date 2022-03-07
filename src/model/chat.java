/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ford_
 */
public class chat {
         private    int      id_comment;
         private    String   content ;
         private    int      id_user ;
         private    int      id_stream  ;
         private    int      report_nbr ;
         
    //Constructor

    public chat() {
    }

    public chat(String content, int id_user, int id_stream, int report_nbr) {
        this.content = content;
        this.id_user = id_user;
        this.id_stream = id_stream;
        this.report_nbr = report_nbr;
    }

    public chat(int id_comment, String content, int id_user, int id_stream, int report_nbr) {
        this.id_comment = id_comment;
        this.content = content;
        this.id_user = id_user;
        this.id_stream = id_stream;
        this.report_nbr = report_nbr;
    }
 
     // Getters

    public int getId_comment() {
        return id_comment;
    }

    public String getContent() {
        return content;
    }

    /**
     *
     * @return
     */
    public int getId_user() {
        return id_user;
    }

    public int getId_stream() {
        return id_stream;
    }

    public int getReport_nbr() {
        return report_nbr;
    }
    
    // Setters

    /**
     *
     * @param id_comment
     */

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_stream(int id_stream) {
        this.id_stream = id_stream;
    }

    public void setReport_nbr(int report_nbr) {
        this.report_nbr = report_nbr;
    }
    
    //Affichage
    @Override
    public String toString() {
        return "chat{"+ "id=" + id_comment + "\n"+", content=" + content + "\n"+", id_user=" +id_user+ "\n"+", id_stream=" +id_stream+ "\n"+",nbr_report=" + report_nbr + "\n"+"\n"+"*********************"+"\n"+'}';
    }
 
}
