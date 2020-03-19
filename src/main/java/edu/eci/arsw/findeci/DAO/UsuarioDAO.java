package edu.eci.arsw.findeci.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eci.arsw.findeci.model.*; 


public interface UsuarioDAO extends JpaRepository<Usuario,String> {
	
}
