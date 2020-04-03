/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services;


import edu.eci.arsw.findeci.model.gustos;
import edu.eci.arsw.findeci.persistence.FindEciException;

/**
 *
 * @author Andrés Quintero
 */
public interface GustosServices {
    
   gustos saveUserGusto(gustos gusto) throws FindEciException;

   gustos findUserGPeliculasByCorreoId(String correo,int id) throws FindEciException;

   gustos findUserGComidaByCorreoId(String correo,int id) throws FindEciException;
   
   gustos findUserGMusicaByCorreoId(String correo,int id) throws FindEciException;
}
