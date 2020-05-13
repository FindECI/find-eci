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
 * @author Jimmy Chirivi
 *
 */
@Service
public class UsuarioServicesImpl implements UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUser(Usuario usuario) throws FindEciException {
        if (usuario.equals(findUserByCorreo(usuario.getCorreo()))) {
            throw new FindEciException("Este usuario ya existe");
        } else {
            System.out.println("Entro a guardaaaaaaa el dato");
            return usuarioRepository.save(usuario);  
            
        }      
    }

    @Override
    public Usuario findUserByCorreo(String correo) throws FindEciException {
        try {
            Optional<Usuario> user = usuarioRepository.findById(correo);
            if (user.isPresent()) {
                return user.get();
            } else {
                return null;
            }

        } catch (java.util.NoSuchElementException ex) {
            throw new FindEciException("Este usuario no existe existe");
        }
    }

    @Override
    public Usuario findUserByLogin(String correo, String password) throws FindEciException {

        try {
            Usuario user = findUserByCorreo(correo);
            if (user.getContrasena().equals(password)) {
                return user;
            } else {
                throw new FindEciException("Error: Usuario no existe o clave incorrecta");
            }
        } catch (java.util.NoSuchElementException ex) {

            throw new FindEciException("Error: Usuario no existe o clave incorrecta");

        }

    }

    @Override
    public void updateUser(Usuario usuario) throws FindEciException {
         try {
                    usuarioRepository.setUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getSexo(), usuario.getAltura(), usuario.getCelular(), usuario.getCuentaig(), usuario.getCorreo());
		}
            catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
            }
    }

    @Override
    public void updateContraseña(String correo, String contraseña) throws FindEciException {
        try {
                    usuarioRepository.setContraseña(contraseña, correo);
		}
            catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
            }
    }

}
