package com.miggonzalv.videojuegos.service;

import com.miggonzalv.videojuegos.domain.Videojuego;
import com.miggonzalv.videojuegos.repository.VideojuegosRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VideojuegoService 
{
    
    private final VideojuegosRepository videojuegosRepository;

    public VideojuegoService(VideojuegosRepository videojuegosRepository) 
    {
        this.videojuegosRepository = videojuegosRepository;
    }

    public List<Videojuego> buscarDestacados() 
    {
        return videojuegosRepository.buscarTodos();
    }
    
    public List<Videojuego> buscarPorDistribuidor(int distribuidorId) 
    {
        return videojuegosRepository.buscarPorDistribuidor(distribuidorId);
    }
    
    public List<Videojuego> buscar(String consulta) 
    {
        return videojuegosRepository.buscar(consulta);
    }
    
    public Videojuego guardar(Videojuego videojuego) 
    {
        return videojuegosRepository.save(videojuego);
    }
    
}
