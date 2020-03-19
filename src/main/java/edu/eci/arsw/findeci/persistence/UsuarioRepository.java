/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.persistence;

import edu.eci.arsw.findeci.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UsuarioRepository extends JpaRepository<Usuario, String >{
    
    @Override
    Usuario save(Usuario usuario);

    Optional<Usuario> findByCorreo(String correo);
}
