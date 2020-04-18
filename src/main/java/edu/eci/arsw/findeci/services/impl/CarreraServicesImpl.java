package edu.eci.arsw.findeci.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.Carrera;
import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.persistence.CarreraRepository;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.CarreraServices;

@Service
public class CarreraServicesImpl implements CarreraServices {

	@Autowired
	CarreraRepository carrerarepo;
	
	
	@Override
	public Carrera saveCarrera(Carrera carrera) throws FindEciException {
		return carrerarepo.save(carrera);
	}

	@Override
	public Carrera findCarreraByCorreo(String correo) throws FindEciException {
		List<Carrera> userCarr;
		try {
			userCarr = carrerarepo.interesesbyuser(correo);
			return userCarr.get(0);
		}
		catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
	}

}
