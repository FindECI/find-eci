/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.services.impl;

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
    public Intereses findInteresByCorreo(Integer correo) throws FindEciException {
		  	
    	try {
            Optional<Intereses> intereses = interesesRepo.findById(correo);
            if (intereses.isPresent()) {
                return intereses.get();
            } else {
                return null;
            }

        } catch (java.util.NoSuchElementException ex) {
            throw new FindEciException("Este usuario no existe existe");
        }
    }
    
}
