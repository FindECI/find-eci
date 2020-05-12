package edu.eci.arsw.findeci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.findeci.model.mensajes;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.mensajesServices;

@Controller
public class chatController {

	@Autowired
	mensajesServices mensajesServ;
	
	@MessageMapping("/messagesP")
	@SendTo("/chat/messagesP")
	public List<mensajes> getMessagespareja(mensajes mensaje) {
		try {
			List<mensajes> menj = mensajesServ.mensajesbypareja(mensaje.getPareja(),mensaje.getChat());
			return menj;
        } catch (FindEciException e) {
            return null;
        }
	}
	
	@MessageMapping("/messagesU")
	@SendTo("/chat/messagesU")
	public List<mensajes> getMessagesusuario(mensajes mensaje) {
		
		try {
			List<mensajes> menj = mensajesServ.mensajesbyuser(mensaje.getUsuario(),mensaje.getChat());
			return menj;
        } catch (FindEciException e) {
            return null;
        }
	}
	
	@MessageMapping("/messages")
	public ResponseEntity<mensajes> saveMessagesusuario(mensajes mensaje) {
		 try {
			 	mensajesServ.saveMensaje(mensaje);
	            return new ResponseEntity<>(HttpStatus.CREATED);
	        } catch (FindEciException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	        }
	}
	
	
	
	
}
