package edu.eci.arsw.findeci.services;

import java.util.List;



import edu.eci.arsw.findeci.model.mensajes;
import edu.eci.arsw.findeci.persistence.FindEciException;

public interface mensajesServices {
	
	void saveMensaje(mensajes mensaje) throws FindEciException;
	
	List<mensajes> mensajesbyChat(int idchat) throws FindEciException;
	
	List<mensajes> mensajesbypareja(String correo,int chat) throws FindEciException;
	
	List<mensajes> mensajesbyuser(String correo,int chat) throws FindEciException;

}
