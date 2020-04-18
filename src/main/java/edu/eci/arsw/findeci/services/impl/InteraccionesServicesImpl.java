package edu.eci.arsw.findeci.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.model.interacciones;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.persistence.InteraccionesRepository;
import edu.eci.arsw.findeci.services.InteraccionesServices;

@Service
public class InteraccionesServicesImpl implements InteraccionesServices {

	@Autowired
	InteraccionesRepository intrepository;
	
	
	@Override
	public interacciones saveInteraccion(interacciones interaccion) throws FindEciException {
		return intrepository.save(interaccion);
	}


	@Override
	public List<interacciones> findIntewithOtheruser(String usuario, String interesado) throws FindEciException {
		try {
			return intrepository.interaccioneswithOtheruser(usuario, interesado);
		}
		catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
	}


	@Override
	public List<interacciones> findInteByuser(String usuario) throws FindEciException {
		try {
			return intrepository.interaccionesbyuser(usuario);
		}
		catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
	}


	@Override
	public List<interacciones> findInteNotification(String usuario) throws FindEciException {
		try {
			return intrepository.interaccionesNotification(usuario);
		}
		catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
	}

	
}
