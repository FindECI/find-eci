/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.eci.arsw.findeci.model.gustos;


/**
 *
 * @author Andrés Quintero
 */
public interface GustosRepository extends JpaRepository<gustos, Integer >  {
	
	@Query(value="select g.id as id,g.descripciongusto as descripciongusto ,g.tipgusto as tipgusto,g.usuario as usuario from gustos g where g.usuario= :correo",nativeQuery = true)
	List<gustos> gustosbyuser(String correo);
    
}
