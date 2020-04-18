package edu.eci.arsw.findeci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.findeci.model.Carrera;
import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.CarreraServices;

@RestController
@RequestMapping(value = "/Carrera")
public class carreraController {
	
	
	@Autowired
	CarreraServices carreraserv;
	
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Carrera> addCarrera(@RequestBody Carrera carrera) {
               
    	try {
    		carreraserv.saveCarrera(carrera);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/{correo}")
    public ResponseEntity<Carrera> getUserInt(@PathVariable(name = "correo") String correo) {
    	try {
            Carrera carrera = carreraserv.findCarreraByCorreo(correo);
            return ResponseEntity.ok(carrera);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	

}
