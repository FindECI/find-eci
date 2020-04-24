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

import edu.eci.arsw.findeci.model.Chats;
import edu.eci.arsw.findeci.model.gustos;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.ChatServices;

@RestController
@RequestMapping(value="/chats")
public class chatsController {

	@Autowired
	ChatServices chatServices;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Chats> saveChat(@RequestBody Chats chats){
		
		try {
			chatServices.saveChat(chats);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }	
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/usuario/{correo}")
    public ResponseEntity<List<Chats>> getChatsUser(@PathVariable(name = "correo") String correo) {
        try {
            List<Chats> chat = chatServices.allChatsByUser(correo);
            return ResponseEntity.ok(chat);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/pareja/{correo}")
	 public ResponseEntity<List<Chats>> getChatsParejas(@PathVariable(name = "correo") String correo) {
        try {
            List<Chats> chat = chatServices.allChatsByPareja(correo);
            return ResponseEntity.ok(chat);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
