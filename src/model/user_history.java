/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ford_
 */
public class user_history {
    private int his_id  ;
  private int id_user ;
  private int stream_id ;
  private int streamer_id ;

    public user_history() {
    }

    public user_history(int id_user, int stream_id, int streamer_id) {
        this.id_user = id_user;
        this.stream_id = stream_id;
        this.streamer_id = streamer_id;
    }

    public user_history(int his_id, int id_user, int stream_id, int streamer_id) {
        this.his_id = his_id;
        this.id_user = id_user;
        this.stream_id = stream_id;
        this.streamer_id = streamer_id;
    }

    public int getHis_id() {
        return his_id;
    }

    public int getId_user() {
        return id_user;
    }

    public int getStream_id() {
        return stream_id;
    }

    public int getStreamer_id() {
        return streamer_id;
    }

    public void setHis_id(int his_id) {
        this.his_id = his_id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setStream_id(int stream_id) {
        this.stream_id = stream_id;
    }

    public void setStreamer_id(int streamer_id) {
        this.streamer_id = streamer_id;
    }

    @Override
    public String toString() {
        return "user_history{" + "his_id=" + his_id + ", id_user=" + id_user + ", stream_id=" + stream_id + ", streamer_id=" + streamer_id + '}';
    }
  
   
}
