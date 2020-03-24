/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services;

import edu.eci.arsw.findeci.model.GustosMusica;
import edu.eci.arsw.findeci.persistence.FindEciException;

/**
 *
 * @author Andrés Quintero
 */
public interface GustosMusicaServices {
    
   GustosMusica saveUserGMusica(GustosMusica GMusica) throws FindEciException;

   GustosMusica findUserGMusicaByCorreo(String correo) throws FindEciException;
}
