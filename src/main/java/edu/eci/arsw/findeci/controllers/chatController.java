package edu.eci.arsw.findeci.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.findeci.model.mensajes;

@Controller
public class chatController {

	@MessageMapping("/message")
	@SendTo("/chat/messages")
	public mensajes getMessages(mensajes mensaje) {
		return mensaje;
	}
}
