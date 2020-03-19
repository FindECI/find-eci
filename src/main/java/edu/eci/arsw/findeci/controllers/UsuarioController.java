package edu.eci.arsw.findeci.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.impl.UsuarioServicesImpl;

@RestController
@RequestMapping(value="/hello")
public class UsuarioController {
	
	
	private UsuarioServicesImpl usuarioservimp;
	
    
    @RequestMapping(method = RequestMethod.GET,path = "{username}/{password}")    
   public String showHello(@PathVariable("username") String user,@PathVariable("password") String pass,Model model){
    	System.out.println("pri:" + user +','+ pass);
    	try {
			if(usuarioservimp.consultUser(user, pass)) {
				System.out.println("prinnnnnnnn");
				model.addAttribute("saludo", "Aplicación en desarrollo");
			    return "hello";
			}
		} catch (FindEciException e) {
			e.printStackTrace();
			return "index";
		}
    	return "index";   	
       
   }
	
}
