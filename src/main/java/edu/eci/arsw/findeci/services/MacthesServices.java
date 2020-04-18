package edu.eci.arsw.findeci.services;

import java.util.List;

import edu.eci.arsw.findeci.model.Matches;
import edu.eci.arsw.findeci.persistence.FindEciException;

public interface MacthesServices {
	
	
	Matches saveMatch (Matches match) throws FindEciException; 
	
	List<Matches> findMacthesByUser(String usuario) throws FindEciException;

}
