/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eci.arsw.findeci.model.Imagenes;
import edu.eci.arsw.findeci.model.gustos;

/**
 *
 * @author Andrés Quintero
 */
public interface GustosRepository extends JpaRepository<gustos, Integer >  {
    
}
