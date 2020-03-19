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
<<<<<<< HEAD
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
=======
 */
@Service
public class UsuarioServicesImpl implements UsuarioServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void saveUser(Usuario usuario) throws FindEciException {
        Optional<Usuario> optionalUser = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (optionalUser.isPresent()) {
            throw new FindEciException(FindEciException.USER_ALREDY_EXISTS);
        } else {
            usuarioRepository.save(usuario);
        }
    }

    @Override
    public Usuario findUserByCorreo(String correo) throws FindEciException {
        Optional<Usuario> optinalUser = usuarioRepository.findByCorreo(correo);
        boolean present = optinalUser.isPresent();
        System.out.println(present);
        if (!present)
            throw new FindEciException(FindEciException.USER_NOT_FOUND);
        return optinalUser.get();
    }
    
}
>>>>>>> e9ab2e66c8a487ce07f75b59f7d2458e8d25a483
