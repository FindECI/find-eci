package edu.eci.arsw.findeci.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.mensajes;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.persistence.mensajesRepository;
import edu.eci.arsw.findeci.services.mensajesServices;

@Service
public class mensajesServicesImpl implements mensajesServices {

	@Autowired
	mensajesRepository mensajesRepo;

	@Override
	public void saveMensaje(mensajes mensaje) throws FindEciException {
		mensajesRepo.save(mensaje);
	}

	@Override
	public List<mensajes> mensajesbypareja(String correo, int chat) throws FindEciException {
		try {

			List<mensajes> mensajes = mensajesRepo.mensajesbypareja(correo, chat);
			return mensajes;

		} catch (java.util.NoSuchElementException ex) {
			throw new FindEciException("Este usuario no existe o chat no existe");
		}
	}

	@Override
	public List<mensajes> mensajesbyuser(String correo, int chat) throws FindEciException {
		try {

			List<mensajes> mensajes = mensajesRepo.mensajesbyuser(correo, chat);
			return mensajes;

		} catch (java.util.NoSuchElementException ex) {
			throw new FindEciException("Este usuario no existe o chat no existe");
		}
	}

	@Override
	public List<mensajes> mensajesbyChat(int idchat) throws FindEciException {
		try {

			List<mensajes> mensajes = mensajesRepo.mensajesbyChat(idchat);
			return mensajes;

		} catch (java.util.NoSuchElementException ex) {
			throw new FindEciException("chat no existe");
		}
	}

}
