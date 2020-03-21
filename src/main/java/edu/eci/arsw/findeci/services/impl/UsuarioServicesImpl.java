/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/ 
package edu.eci.arsw.findeci.services.impl;

import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.persistence.UsuarioRepository;
import edu.eci.arsw.findeci.services.UsuarioServices;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Quintero
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
