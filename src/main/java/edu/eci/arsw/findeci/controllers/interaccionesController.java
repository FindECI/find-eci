package edu.eci.arsw.findeci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.model.interacciones;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.InteraccionesServices;

@RestController
@RequestMapping(value = "/Interacciones")
public class interaccionesController {
	
	@Autowired
	InteraccionesServices intservices;
	
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<interacciones> addInteracciones(@RequestBody interacciones interacciones) {
        try {
            intservices.saveInteraccion(interacciones);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    /*
     * Trae la interacciones generadas por el usuario a consultar
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{correo}")
    public ResponseEntity<List<interacciones>> getUserInteracciones(@PathVariable(name = "correo") String correo) {
    	 try {
             List<interacciones> interaccion = intservices.findInteByuser(correo);
             return ResponseEntity.ok(interaccion);
         } catch (FindEciException e) {
             return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
         }
    }
    
    /*
     * Trae informacion de otros usuarios interesados en usuario a consultar
     */
    @RequestMapping(method = RequestMethod.GET, path = "/notification/{correo}")
    public ResponseEntity<List<interacciones>> getUserInteraccionesNotif(@PathVariable(name = "correo") String correo) {
    	 try {
             List<interacciones> interaccion = intservices.findInteNotification(correo);
             return ResponseEntity.ok(interaccion);
         } catch (FindEciException e) {
             return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
         }
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{usuario}/{pareja}")
    public ResponseEntity<List<interacciones>> getUserOtherInteracciones(@PathVariable(name = "usuario") String usuario,@PathVariable(name = "pareja") String pareja) {
    	 try {
             List<interacciones> interaccion = intservices.findIntewithOtheruser(usuario, pareja);
             return ResponseEntity.ok(interaccion);
         } catch (FindEciException e) {
             return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
         }
    }
    

}
