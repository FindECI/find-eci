package edu.eci.arsw.findeci.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.eci.arsw.findeci.model.Carrera;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;


public interface CarreraRepository  extends JpaRepository<Carrera,Integer>{

	
	@Query(value="select c.id as id,c.nombre as nombre,c.semestre as semestre,c.usuario as usuario from carrera c where c.usuario= :correo",nativeQuery = true)
	List<Carrera> interesesbyuser(String correo);
        
        @Transactional
        @Modifying
        @Query("update Carrera c set c.nombre= ?1, c.semestre= ?2 where c.usuario= ?3")
        void setCarrera(String carrera, Integer semestre,String correo);
}
