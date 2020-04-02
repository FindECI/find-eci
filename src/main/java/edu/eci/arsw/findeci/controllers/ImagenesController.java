package edu.eci.arsw.findeci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.findeci.model.Imagenes;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.ImagenesServices;

@RestController
@RequestMapping(value = "/imagen")
public class ImagenesController {
	
	
	@Autowired
	ImagenesServices imagServices;
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Imagenes> addUser(@RequestBody Imagenes imagen) {
        try {
        	System.out.println("Entro a las imagenes....");
            imagServices.saveImage(imagen);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
