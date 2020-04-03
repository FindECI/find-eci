
package edu.eci.arsw.findeci.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.InteresesServices;
import edu.eci.arsw.findeci.services.UsuarioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping(value = "/Intereses")
public class InteresesController {
    
     
    @Autowired
    private InteresesServices intserv;

    
    @RequestMapping(method = RequestMethod.GET, path = "/{correo}")
    public ResponseEntity<Intereses> getUser(@PathVariable(name = "correo") Integer correo) {
    	try {
            Intereses interes = intserv.findInteresByCorreo(correo);
            return ResponseEntity.ok(interes);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Intereses> addUser(@RequestBody Intereses interes) {
        System.out.println("oleeeee mire:"+ interes.getId() + interes.getSexoInteres() + interes.getTipoRel() + interes.getApectosImportantes());
        System.out.println("usuuuuariooo: "+ interes.getUsuario());        
    	try {
            intserv.saveInteres(interes);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
