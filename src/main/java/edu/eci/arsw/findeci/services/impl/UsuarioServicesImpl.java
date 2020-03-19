/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services.impl;

import edu.eci.arsw.findeci.DAO.UsuarioDAO;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.UsuarioServices;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Quintero

*/ 

public class UsuarioServicesImpl implements UsuarioServices {
    
	@Autowired
	private UsuarioDAO usuariodao;

	@Override
	public boolean consultUser(String correo, String password) throws FindEciException {
		System.out.println("ppppppppppri:" + correo +','+ password);
		Optional<Usuario> usuario = usuariodao.findById(correo);
		if(usuario.isPresent()) {
			if(usuario.get().getContraseña().equals(password)) {
				return true;
			}
			else {
				return false;
			}			
		}
		else {
			
			return false;
		}
		
	}
	
      
}

