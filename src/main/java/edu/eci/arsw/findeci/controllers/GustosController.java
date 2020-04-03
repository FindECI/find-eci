/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.controllers;

import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.model.gustos;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.GustosServices;
import edu.eci.arsw.findeci.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andrés Quintero
 */

@RestController
@RequestMapping(value = "/Gustos")
public class GustosController {
    
private String correo;
	
	@Autowired
	GustosServices gustoservice;
	
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Intereses> addUser(@RequestBody gustos gusto) {
               
    	try {
            gustoservice.saveUserGusto(gusto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }


	/*
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
 
    @Autowired
    private UsuarioServices userserv;

    @RequestMapping(method = RequestMethod.GET, path = "/{correo}")
    public ResponseEntity<Usuario> getUser(@PathVariable(name = "correo") String correo) {
        try {
            Usuario usuario = userserv.findUserByCorreo(correo);
            return ResponseEntity.ok(usuario);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario) {
        try {

            userserv.saveUser(usuario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }*/
}
