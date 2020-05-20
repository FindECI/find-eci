package edu.eci.arsw.findeci.persistence;

import edu.eci.arsw.findeci.model.Imagenes;
import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenesRepository extends PagingAndSortingRepository<Imagenes, Serializable>{
    
    @Query("select i from Imagenes i where i.usuario= :user order by i.fecha desc")
    public abstract Page<Imagenes> findAll(Pageable page, String user);
    

}
