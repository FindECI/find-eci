package edu.eci.arsw.findeci.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import edu.eci.arsw.findeci.model.interacciones;

public interface InteraccionesRepository extends JpaRepository<interacciones, Integer > {
	
	@Query(value="select i.id as id,i.likes as likes ,i.pareja as pareja,i.usuario as usuario from interacciones i where i.usuario= :correo",nativeQuery = true)
	List<interacciones> interaccionesbyuser(String correo);
	
	@Query(value="select i.id as id,i.likes as likes ,i.pareja as pareja,i.usuario as usuario,i.usuario as usuario from interacciones i where i.usuario= :usuario, i.pareja= :pareja",nativeQuery = true)
	List<interacciones> interaccioneswithOtheruser(String usuario,String pareja);
	
	
	@Query(value="select i.id as id,i.likes as likes ,i.pareja as pareja,i.usuario as usuario from interacciones i where i.pareja= :correo and i.likes = 1",nativeQuery = true)
	List<interacciones> interaccionesNotification(String correo);
}
