/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services.impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.gustos;
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
	public gustos saveUserGusto(gustos gusto) throws FindEciException {
		
		return gustosRepo.save(gusto);
	}

	@Override
	public List<gustos> gustosByuser(String correo) throws FindEciException {
		try {
			List<gustos> gusto = gustosRepo.gustosbyuser(correo);
			return gusto;
		}
		catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
	}

	

}
