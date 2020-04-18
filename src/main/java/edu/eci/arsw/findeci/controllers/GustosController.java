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

import java.util.List;

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
    
	
	@Autowired
	GustosServices gustoservice;
	
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<gustos> addUser(@RequestBody gustos gusto) {
               
    	try {
            gustoservice.saveUserGusto(gusto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    
    @RequestMapping(method = RequestMethod.GET, path = "/{correo}")
    public ResponseEntity<List<gustos>> getUser(@PathVariable(name = "correo") String correo) {
        try {
            List<gustos> gusto = gustoservice.gustosByuser(correo);
            return ResponseEntity.ok(gusto);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
