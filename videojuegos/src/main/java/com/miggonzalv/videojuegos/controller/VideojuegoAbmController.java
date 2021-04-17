package com.miggonzalv.videojuegos.controller;

import com.miggonzalv.videojuegos.domain.Videojuego;
import com.miggonzalv.videojuegos.service.DistribuidorService;
import com.miggonzalv.videojuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideojuegoAbmController {
    
    private final DistribuidorService distribuidorService;
    private final VideojuegoService videojuegoService;

    public VideojuegoAbmController(DistribuidorService distribuidorService,VideojuegoService videojuegoService) {
        this.distribuidorService = distribuidorService;
        this.videojuegoService = videojuegoService;
    }
    
    @RequestMapping("/videojuegos/crear")
    public String mostrarFormAlta(Model modelo)
    {
        modelo.addAttribute("distribuidores", distribuidorService.buscarTodos());
        modelo.addAttribute("videojuego", new Videojuego());
        return "formVideojuego";
    }
    
    @PostMapping("/videojuegos/guardar")
    public String guardar(Videojuego videojuego)
    {
        //System.out.println(videojuego);
        videojuegoService.guardar(videojuego);
        return "redirect:/";
    }
    
}
