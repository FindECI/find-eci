/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
<<<<<<< HEAD
 */
package edu.eci.arsw.findeci.services;

import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;

/**
 *
 * @author Andrés Quintero
 */
public interface UsuarioServices {

    void saveUser(Usuario usuario) throws FindEciException;

    Usuario findUserByCorreo(String correo) throws FindEciException;

}
