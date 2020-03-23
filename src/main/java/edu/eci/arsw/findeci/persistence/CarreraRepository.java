/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.persistence;

import edu.eci.arsw.findeci.model.Carrera;
import edu.eci.arsw.findeci.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrés Quintero
 */
@Repository
@Component
public interface CarreraRepository extends JpaRepository<Carrera, Usuario > {
    
     Optional<Carrera> findByNombre(String nombre);
    
}