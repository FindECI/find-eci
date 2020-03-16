/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.findeci.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Andrés Quintero
 */
@Controller
public class FindEciController {
     @RequestMapping("/hello")
    public String showHello(Model model){
        model.addAttribute("saludo", "Aplicación en desarrollo");
        return "hello";
    }
    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }
    @RequestMapping("/RegistroU")
    public String pr(Model model){
        return "RegistroUsuario";
    }
}
