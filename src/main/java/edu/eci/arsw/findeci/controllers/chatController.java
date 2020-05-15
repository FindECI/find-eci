package edu.eci.arsw.findeci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.findeci.model.mensajes;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.mensajesServices;

@Controller
public class chatController {

	@Autowired
	mensajesServices mensajesServ;

	///suscripcion "messagesAllmensajes"
	@MessageMapping("/chat.messangesAll")
	@SendTo("/chat/messagesAll")
	public List<mensajes> getAllmessasges(@Payload mensajes mensaje) {
		try {
			List<mensajes> menj = mensajesServ.mensajesbyChat(mensaje.getChat());
			return menj;
		} catch (FindEciException e) {
			return null;
		}
	}
	
	///suscripcion = "messagesPareja"
	@MessageMapping("/chat.messagesP")
	@SendTo("/chat/messagesPareja")
	public List<mensajes> getMessagespareja(@Payload mensajes mensaje) {
		System.out.println("entraaaaa:..... "+mensaje.getUsuario()+"///"+mensaje.getPareja());
		try {
			List<mensajes> menj = mensajesServ.mensajesbypareja(mensaje.getPareja(), mensaje.getChat());
			return menj;
		} catch (FindEciException e) {
			return null;
		}
	}

	@MessageMapping("/chat.messagesU")
	@SendTo("/chat/messagesUser")
	public List<mensajes> getMessagesusuario(mensajes mensaje) {

		try {
			List<mensajes> menj = mensajesServ.mensajesbyuser(mensaje.getUsuario(), mensaje.getChat());
			return menj;
		} catch (FindEciException e) {
			return null;
		}
	}
	
	///suscripcion
	@MessageMapping("/chat.saveUser")
	@SendTo("/char/messagesUser")
	public mensajes addUser (@Payload mensajes mensaje, SimpMessageHeaderAccessor headerAccessor){
		headerAccessor.getSessionAttributes().put("username", mensaje.getUsuario());
		return mensaje;
	}

	@MessageMapping("/chat.messages")
	@SendTo("/chat/messagesUser")
	public mensajes saveMessagesusuario(@Payload mensajes mensaje) {
		
			try {
				mensajesServ.saveMensaje(mensaje);
			} catch (FindEciException e) {
				e.printStackTrace();
			}
			return mensaje;
	}	

}
