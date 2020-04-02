package edu.eci.arsw.findeci.services;

import edu.eci.arsw.findeci.model.Imagenes;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;

public interface ImagenesServices {

	
	 Imagenes saveImage(Imagenes imagen) throws FindEciException;

	 Imagenes findImageByCorreo(String correo) throws FindEciException;
	
	
}
