package edu.eci.arsw.findeci.services;

import java.util.List;

import edu.eci.arsw.findeci.model.Chats;
import edu.eci.arsw.findeci.model.Matches;
import edu.eci.arsw.findeci.persistence.FindEciException;

public interface ChatServices {
	
	Chats saveChat (Chats chat)  throws FindEciException;
	
	List<Chats> allChatsByUser(String correo) throws FindEciException;
	
	List<Chats> allChatsByPareja(String pareja) throws FindEciException;
}
