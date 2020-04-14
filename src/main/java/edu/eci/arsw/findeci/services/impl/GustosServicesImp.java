/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.Gustos;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.persistence.GustosRepository;
import edu.eci.arsw.findeci.services.GustosServices;

/**
 *
 * @author Andrés Quintero
 */

@Service	
public class GustosServicesImp implements GustosServices {

	
	@Autowired
	GustosRepository gustosRepo;
	
	@Override
	public Gustos saveUserGusto(Gustos gusto) throws FindEciException {
		
		return gustosRepo.save(gusto);
	}

	@Override
	public Gustos findUserGPeliculasByCorreoId(String correo, int id) throws FindEciException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gustos findUserGComidaByCorreoId(String correo, int id) throws FindEciException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gustos findUserGMusicaByCorreoId(String correo, int id) throws FindEciException {
		// TODO Auto-generated method stub
		return null;
	}

}
