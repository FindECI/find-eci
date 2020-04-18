/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.persistence.InteresesRepository;
import edu.eci.arsw.findeci.services.InteresesServices;

/**
 *
 * @author Andrés Quintero
 */

@Service
public class InteresesServicesImpl implements InteresesServices{
	
	
	@Autowired
	InteresesRepository interesesRepo;

    @Override
    public Intereses saveInteres(Intereses interes) throws FindEciException {
    	
            return interesesRepo.save(interes);  
            
          
    }

    @Override
	public Intereses findInteresByCorreo(String correo) throws FindEciException {
		List<Intereses> userInt;
		try {
			userInt = interesesRepo.interesesbyuser(correo);
			return userInt.get(0);
		}
		catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
	}

	@Override
	public List<Intereses> findAllIntereses(String correo) throws FindEciException {
		List<Intereses> allInt;
		Intereses interesado = findInteresByCorreo(correo);
		String Gustogenero ;
		if(interesado.getSexoInteres().equals("Masculino")) {
			Gustogenero = "Femenino";
		}
		else if(interesado.getSexoInteres().equals("Femenino")) {
			Gustogenero = "Masculino";
		} 
		else {
			Gustogenero = "Otro";
		}
		try {
			allInt = interesesRepo.interesesOtherUser(interesado.getUsuario(),Gustogenero);
			return allInt;
		}
		catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
	}
    
}
