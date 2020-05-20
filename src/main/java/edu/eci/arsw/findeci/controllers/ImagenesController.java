package edu.eci.arsw.findeci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.findeci.model.Imagenes;
import edu.eci.arsw.findeci.model.Usuario;
import edu.eci.arsw.findeci.persistence.FindEciException;
import edu.eci.arsw.findeci.services.ImagenesServices;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/image")
public class ImagenesController {

    @Autowired
    ImagenesServices imagServices;
    
    /**@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Imagenes> addUser(@RequestBody Imagenes imagen) {
        try {
            System.out.println("Entro a las imagenes....");
            imagServices.saveImage(imagen);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FindEciException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    **/
    
    @GetMapping("/{usuario}")
    public ModelAndView find(Pageable page, @PathVariable(name = "usuario") String user) throws FindEciException {

        ModelAndView md = new ModelAndView("fotos");
        md.addObject("imgs", imagServices.find(page, user));
        return md;

    }
    
    @PostMapping("/upload")
    @ResponseBody
    public String ruta_subida(@RequestParam("img") MultipartFile file) throws FindEciException{
         return imagServices.saveImage(file);
    }
    
    @PostMapping("/register")
    @ResponseBody
    public String insert (@RequestParam("titulo") String titulo, @RequestParam("usuario") String user, @RequestParam("ruta") String ruta) throws FindEciException{
        imagServices.guardarImg(titulo, user, ruta);
        return "/image/" + user;
    } 
    

}
