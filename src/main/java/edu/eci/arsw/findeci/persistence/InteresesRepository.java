/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.eci.arsw.findeci.model.Intereses;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

public interface InteresesRepository extends JpaRepository<Intereses,Integer>{
 
	@Query(value="select i.id as id,i.aspectos_importantes as aspectos_importantes,i.sexo_interes as sexo_interes,i.tipo_relacion as tipo_relacion,i.usuario as usuario from intereses i where i.usuario= :correo",nativeQuery = true)
	List<Intereses> interesesbyuser(String correo);
	
	@Query(value="select i.id as id,i.aspectos_importantes as aspectos_importantes,i.sexo_interes as sexo_interes,i.tipo_relacion as tipo_relacion,i.usuario as usuario from intereses i where i.usuario <> :correo and i.sexo_interes = :sexo",nativeQuery = true)
	List<Intereses> interesesOtherUser(String correo, String sexo);
        
        @Transactional
        @Modifying
        @Query("update Intereses i set i.aspectos_importantes= ?1, i.sexo_interes= ?2, i.tipo_relacion= ?3 where i.usuario= ?4")
        void setIntereses(String aspectosImportantes, String sexoInt, String tipoRel, String correo);
	
	
	
}
