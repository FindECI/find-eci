/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package edu.eci.arsw.findeci.persistence;

import edu.eci.arsw.findeci.model.Usuario;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Jimmy Chirivi
 * 
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String >{

        @Transactional
        @Modifying
        @Query("update Usuario u set u.nombre= ?1, u.apellido= ?2, u.sexo= ?3, u.altura= ?4, u.celular= ?5, u.cuentaig= ?6 where u.correo= ?7")
        void setUsuario(String nombre, String apellido, String sexo ,short altura ,long celular ,String cuentaIg, String Correo);
        
        @Transactional
        @Modifying
        @Query("update Usuario u set u.contrasena= ?1 where u.correo= ?2")
        void setContraseña(String contraseña, String correo);
}