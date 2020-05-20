package edu.eci.arsw.findeci.services;

import edu.eci.arsw.findeci.model.Imagenes;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ImagenesServices {

    String saveImage(MultipartFile file) throws FindEciException;

    Imagenes findImageByCorreo(String correo) throws FindEciException;

    List<Imagenes> find(Pageable page, String user) throws FindEciException;

    public void guardarImg(String titulo, String user, String ruta) throws FindEciException;

}
