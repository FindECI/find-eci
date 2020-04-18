package edu.eci.arsw.findeci.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.Matches;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.persistence.MatchRepository;
import edu.eci.arsw.findeci.services.MacthesServices;

@Service
public class MatchesServicesImpl implements MacthesServices{

	@Autowired
	MatchRepository matchRepo;

	@Override
	public Matches saveMatch(Matches match) throws FindEciException {
		
		return matchRepo.save(match);
	}

	@Override
	public List<Matches> findMacthesByUser(String usuario) throws FindEciException {
		
		try {
			
			return matchRepo.allMatchesByUser(usuario);
			
		}catch(java.util.NoSuchElementException ex){
			throw new FindEciException("Este usuario no existe");
		}
		
	}
	
}
