/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services;


import edu.eci.arsw.findeci.model.Gustos;
import edu.eci.arsw.findeci.persistence.FindEciException;

/**
 *
 * @author Andrés Quintero
 */
public interface GustosServices {
    
   Gustos saveUserGusto(Gustos gusto) throws FindEciException;

   Gustos findUserGPeliculasByCorreoId(String correo,int id) throws FindEciException;

   Gustos findUserGComidaByCorreoId(String correo,int id) throws FindEciException;
   
   Gustos findUserGMusicaByCorreoId(String correo,int id) throws FindEciException;
}
