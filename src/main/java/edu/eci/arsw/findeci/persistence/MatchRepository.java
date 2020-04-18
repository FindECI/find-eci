package edu.eci.arsw.findeci.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.eci.arsw.findeci.model.Matches;

public interface MatchRepository extends JpaRepository<Matches,Integer>{
	
	
	@Query(value = "select m.id as id,m.fecha as fecha,m.pareja as pareja,m.usuario as usuario from matches m where m.usuario= :correo",nativeQuery = true)
	List<Matches> allMatchesByUser(String correo);

}
