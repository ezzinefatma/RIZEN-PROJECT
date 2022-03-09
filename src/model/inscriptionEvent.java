/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author OUSSAMA
 */
public class inscriptionEvent {

    private int id_ins;
    private Timestamp date_ins;
    private int id_usr;
    private int id_event;
    private User usr;
    private event event;

    public inscriptionEvent(int id_ins, Timestamp date_ins, int id_usr, int id_event) {
        this.id_ins = id_ins;
        this.date_ins = date_ins;
        this.id_usr = id_usr;
        this.id_event = id_event;
    }

    public int getId_ins() {
        return id_ins;
    }

    public void setId_ins(int id_ins) {
        this.id_ins = id_ins;
    }

    public Timestamp getDate() {
        return date_ins;
    }

    public void setDate(Timestamp date) {
        this.date_ins = date;
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public event getEvent() {
        return event;
    }

    public void setEvent(event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "inscriptionEvent{" + "id_ins=" + id_ins + ", date=" + date_ins + ", id_usr=" + id_usr + ", id_event=" + id_event + ", usr=" + usr + ", event=" + event + '}';
    }
    

}
