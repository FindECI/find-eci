package edu.eci.arsw.findeci.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.eci.arsw.findeci.model.Chats;
public interface ChatRepository extends JpaRepository<Chats, Integer >  {
	
	@Query(value = "select c.id as id,c.pareja as pareja,c.usuario as usuario from chats c where c.usuario= :correo or c.pareja = :correo",nativeQuery = true)
	List<Chats> allChatsUsuario(String correo);
	
	@Query(value = "select c.id as id,c.pareja as pareja,c.usuario as usuario from chats c where c.pareja= :correo",nativeQuery = true)
	List<Chats> allChatsPareja(String correo);
}
