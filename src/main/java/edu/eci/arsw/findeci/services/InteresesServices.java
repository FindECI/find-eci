/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services;

import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.persistence.FindEciException;

/**
 *
 * @author Andrés Quintero
 */
public interface InteresesServices {
    
   Intereses saveInteres(Intereses interes) throws FindEciException;

   Intereses findInteresByCorreo(Integer correo) throws FindEciException;
}
