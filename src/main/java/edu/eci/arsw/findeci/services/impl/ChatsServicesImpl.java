package edu.eci.arsw.findeci.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.Chats;
import edu.eci.arsw.findeci.model.Matches;
import edu.eci.arsw.findeci.model.gustos;
import edu.eci.arsw.findeci.persistence.ChatRepository;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.ChatServices;

@Service
public class ChatsServicesImpl implements ChatServices  {

	@Autowired
	ChatRepository chatRepo;
	
	@Override
	public Chats saveChat(Chats chat) throws FindEciException {
		return chatRepo.save(chat);
	}

	@Override
	public List<Chats> allChatsByUser(String correo) throws FindEciException {
		try {
			List<Chats> chats = chatRepo.allChatsUsuario(correo);
			return chats;
		}
		catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
	}

	@Override
	public List<Chats> allChatsByPareja(String pareja) throws FindEciException {
		try {
			List<Chats> chats = chatRepo.allChatsPareja(pareja);
			return chats;
		}
		catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
	}
	

	

}
