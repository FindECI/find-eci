package edu.eci.arsw.findeci.services.impl;

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

@Service
public class ImagenesServicesImpl implements ImagenesServices {
	
	
	@Autowired
	ImagenesRepository imagenRepository;

	@Override
	public Imagenes saveImage(Imagenes imagen) throws FindEciException {
		   
		return imagenRepository.save(imagen);
   	}

	@Override
	public Imagenes findImageByCorreo(String correo) throws FindEciException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
