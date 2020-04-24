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

import edu.eci.arsw.findeci.model.Matches;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.MacthesServices;

@RestController
@RequestMapping(value="/match")
public class MatchController {
	
	@Autowired
	MacthesServices matchServ;
	
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Matches> addMatch(@RequestBody Matches match) {
               
    	try {
            matchServ.saveMatch(match);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
	
	@RequestMapping(method = RequestMethod.GET, path="/{correo}")
	public ResponseEntity<List<Matches>> allUsers(@PathVariable(name="correo") String correo){
		try {
			List<Matches> match = matchServ.findMacthesByUser(correo);
			return ResponseEntity.ok(match);
		} catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/pareja/{correo}")
	public ResponseEntity<List<Matches>> allPareja(@PathVariable(name="correo") String correo){
		try {
			List<Matches> match = matchServ.findMacthesByPareja(correo);
			return ResponseEntity.ok(match);
		} catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
}
