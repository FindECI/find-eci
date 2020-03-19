/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.eci.arsw.findeci.services.impl.UsuarioServicesImpl;

/**
 *
 * @author Andrés Quintero
 */
@Controller
public class FindEciController {	
	
	
     
    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }
    
    @RequestMapping("/RegistroU")
    public String pr(Model model){
        return "RegistroUsuario";
    }
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/userForm")
    public String userForm(){
        return "user-form";
    }
    
    @RequestMapping("/Intereses")
    public String gustos(){
        return "Intereses";
    }
    @RequestMapping("/gustosMusicales")
    public String gustosMusicales(){
        return "gustosMusicales";
    }
    @RequestMapping("/gustosComida")
    public String gustosComida(){
        return "GustosComida";
    }
    @RequestMapping("/GustosPeliculas")
    public String GustosPeliculas(){
        return "GustosPeliculas";
    }
    @RequestMapping("/Fetiches")
    public String Fetiches(){
        return "Fetiches";
    }
    
}
