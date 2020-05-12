package edu.eci.arsw.findeci.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.eci.arsw.findeci.model.mensajes;

public interface mensajesRepository extends JpaRepository<mensajes,Integer> {
	
	@Query(value="select m.id as id,m.mensaje as mensaje,m.usuario as usuario,m.pareja as pareja,m.chat as chat,m.fecha as fecha from mensajes m where m.pareja= :correo and m.chat= :chat",nativeQuery = true)
	List<mensajes> mensajesbypareja(String correo,int chat);
	
	@Query(value="select m.id as id,m.mensaje as mensaje,m.usuario as usuario,m.pareja as pareja,m.chat as chat, m.fecha as fecha from mensajes m where m.usuario= :correo and m.chat= :chat",nativeQuery = true)
	List<mensajes> mensajesbyuser(String correo,int chat);
	

}
