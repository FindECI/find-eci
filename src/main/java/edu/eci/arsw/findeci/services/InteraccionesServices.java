package edu.eci.arsw.findeci.services;

import java.util.List;

import edu.eci.arsw.findeci.model.interacciones;
import edu.eci.arsw.findeci.persistence.FindEciException;

public interface InteraccionesServices {
	
	interacciones saveInteraccion(interacciones interaccion ) throws FindEciException;
	
	List<interacciones> findIntewithOtheruser(String usuario, String interesado) throws FindEciException;
	
	List<interacciones> findInteByuser(String usuario)  throws FindEciException;
	
	List<interacciones> findInteNotification(String usuario)  throws FindEciException;
}
