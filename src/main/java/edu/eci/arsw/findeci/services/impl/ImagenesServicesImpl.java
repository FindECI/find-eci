package edu.eci.arsw.findeci.services.impl;


import edu.eci.arsw.findeci.Generar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.findeci.model.Imagenes;
import edu.eci.arsw.findeci.model.Intereses;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.persistence.ImagenesRepository;
import edu.eci.arsw.findeci.services.ImagenesServices;
import edu.eci.arsw.findeci.services.InteresesServices;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenesServicesImpl implements ImagenesServices {

    @Autowired
    ImagenesRepository imagenRepository;

    @Override
    public String saveImage(MultipartFile file) throws FindEciException {
        String ruta = "";

        if (!file.isEmpty()){
            byte[] bytes;
            try {
                bytes = file.getBytes();

                String nombre = Generar.code()+file.getOriginalFilename();

                Path path = Paths.get(".//src//main//resources//static//img//"+nombre);

                String tipo = file.getContentType();

                switch(tipo){
                    case "image/png":
                        Files.write(path, bytes);
                        ruta = "/img/"+nombre;
                        break;
                    case "image/jpg":
                        Files.write(path, bytes);
                        ruta = "/img/"+nombre;
                        break;
                    case "image/jpeg":
                        Files.write(path, bytes);
                        ruta = "/img/"+nombre;
                        break;
                    case "image/gif":
                        Files.write(path, bytes);
                        ruta = "/img/"+nombre;
                        break;
                    default:
                        ruta = "";
                        break;
                }
            } catch (IOException ex) {
                ruta = "";
            }
        }
        return ruta;
    }

    @Override
    public Imagenes findImageByCorreo(String correo) throws FindEciException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Imagenes> find(Pageable page){
        return imagenRepository.findAll(page).getContent();
    }

    @Override
    public void guardarImg(String titulo, String ruta) throws FindEciException {
        Imagenes img = new Imagenes();
        img.setRuta(ruta);
        img.setTitulo(titulo);
        img.setFecha(new Date());
        imagenRepository.save(img);
    }

    

}
