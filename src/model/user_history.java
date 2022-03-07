/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author ford_
 */
public class user_history {
    private int his_id  ;
  private int id_user ;
  private int stream_id ;
  private String user_name;
  private String titre_stream; 
  private String url ;
  private Timestamp date;

    public user_history() {
    }

    public user_history(String user_name, String titre_stream, String url, Timestamp date) {
        this.user_name = user_name;
        this.titre_stream = titre_stream;
        this.url = url;
        this.date = date;
    }

    public user_history(int id_user, int stream_id, String user_name, String titre_stream, String url, Timestamp date) {
        this.id_user = id_user;
        this.stream_id = stream_id;
        this.user_name = user_name;
        this.titre_stream = titre_stream;
        this.url = url;
        this.date = date;
    }

    public user_history(int his_id, int id_user, int stream_id, String user_name, String titre_stream, String url, Timestamp date) {
        this.his_id = his_id;
        this.id_user = id_user;
        this.stream_id = stream_id;
        this.user_name = user_name;
        this.titre_stream = titre_stream;
        this.url = url;
        this.date = date;
    }

    public int getHis_id() {
        return his_id;
    }

    public void setHis_id(int his_id) {
        this.his_id = his_id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getStream_id() {
        return stream_id;
    }

    public void setStream_id(int stream_id) {
        this.stream_id = stream_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTitre_stream() {
        return titre_stream;
    }

    public void setTitre_stream(String titre_stream) {
        this.titre_stream = titre_stream;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "user_history{" + "his_id=" + his_id + ", id_user=" + id_user + ", stream_id=" + stream_id + ", user_name=" + user_name + ", titre_stream=" + titre_stream + ", url=" + url + ", date=" + date + '}';
    }

   

    
   
}
