package com.miggonzalv.videojuegos.controller;

import com.miggonzalv.videojuegos.domain.Videojuego;
import com.miggonzalv.videojuegos.service.VideojuegoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListadoController 
{
    
    private final VideojuegoService gameService;
    
    public ListadoController(VideojuegoService servicio)
    {
        this.gameService = servicio;
    }
    @RequestMapping("/")
    public String listarVideojuegos(Model modelo)
    {
        //busqueda de los videojuegos
        List<Videojuego> lista = gameService.buscarDestacados();
        modelo.addAttribute("destacados", lista);
        return "listado";
    }
    
    @RequestMapping("/videojuegosPorDistribuidor")
    public String listarVideojuegosPorDistribuidor(Model modelo, int distribuidorId)
    {
        //busqueda de los videojuegos por distribuidor
        List<Videojuego> lista = gameService.buscarPorDistribuidor(distribuidorId);
        modelo.addAttribute("destacados", lista);
        return "listado";
    }
    
    @RequestMapping("/buscar")
    public String buscar(Model modelo, @RequestParam("q")String consulta)
    {
        List<Videojuego> lista = gameService.buscar(consulta);
        modelo.addAttribute("destacados", lista);
        return "listado";
    }
}
