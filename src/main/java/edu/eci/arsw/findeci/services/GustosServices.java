/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services;


import java.util.List;

import edu.eci.arsw.findeci.model.gustos;
import edu.eci.arsw.findeci.persistence.FindEciException;

/**
 *
 * @author Andrés Quintero
 */
public interface GustosServices {
    
   gustos saveUserGusto(gustos gusto) throws FindEciException;

   List<gustos> gustosByuser(String correo) throws FindEciException;
   
   void updateUserGusto(gustos gusto) throws FindEciException;
}
