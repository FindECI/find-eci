package edu.eci.arsw.findeci.services;

import edu.eci.arsw.findeci.model.Imagenes;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ImagenesServices {

	
	 Imagenes saveImage(Imagenes imagen) throws FindEciException;

	 Imagenes findImageByCorreo(String correo) throws FindEciException;
         
         List<Imagenes> find(Pageable page) throws FindEciException;
	
	
}
