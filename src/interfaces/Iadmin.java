/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import model.User;

/**
 *
 * @author Fatma
 */
public interface Iadmin extends Iuser{
    
    public boolean Banned(User u);
}
