/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services;

import java.util.List;

import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.persistence.FindEciException;

public interface InteresesServices {
    
   Intereses saveInteres(Intereses interes) throws FindEciException;

   Intereses findInteresByCorreo(String correo) throws FindEciException;
   
   List<Intereses> findAllIntereses(String correo) throws FindEciException;


}
