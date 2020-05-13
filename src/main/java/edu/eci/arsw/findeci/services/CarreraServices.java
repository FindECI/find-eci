package edu.eci.arsw.findeci.services;

import edu.eci.arsw.findeci.model.Carrera;
import edu.eci.arsw.findeci.persistence.FindEciException;

public interface CarreraServices {
	
	Carrera saveCarrera(Carrera carrera) throws FindEciException;

	Carrera findCarreraByCorreo(String correo) throws FindEciException;
        
        void updateCarrera(Carrera carrera) throws FindEciException;

}
