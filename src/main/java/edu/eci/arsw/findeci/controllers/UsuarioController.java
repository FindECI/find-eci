package edu.eci.arsw.findeci.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.UsuarioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * 
 * @author Jimmy Chirivi
 * 
 */


@RestController
@RequestMapping(value="/userForm")
public class UsuarioController {
	
	@Autowired
	private UsuarioServices userserv;
	
	@RequestMapping(method = RequestMethod.GET,path="/{correo}")
	public ResponseEntity<Usuario> getUser(@PathVariable(name = "correo") String correo){
		try {
			Usuario usuario = userserv.findUserByCorreo(correo);
			return ResponseEntity.ok(usuario);
		}
		catch(FindEciException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario){
        try {
        	
			userserv.saveUser(usuario);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (FindEciException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}		
    }
	
	
	@RequestMapping(method = RequestMethod.GET,path="/{correo}/{password}")
	public ResponseEntity<Usuario> confirmLogin(@PathVariable(name = "correo") String correo,@PathVariable(name = "password") String password){
		try {
			Usuario usuario = userserv.findUserByLogin(correo,password);
			return ResponseEntity.ok(usuario);
		}
		catch(FindEciException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
