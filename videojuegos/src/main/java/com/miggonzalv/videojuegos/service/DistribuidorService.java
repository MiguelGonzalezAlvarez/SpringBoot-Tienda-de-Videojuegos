package com.miggonzalv.videojuegos.service;

import com.miggonzalv.videojuegos.domain.Distribuidor;
import com.miggonzalv.videojuegos.repository.DistribuidorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DistribuidorService 
{
    
    private final DistribuidorRepository distribuidorRepository;

    public DistribuidorService(DistribuidorRepository distribuidorRepository) {
        this.distribuidorRepository = distribuidorRepository;
    }
    
    public List<Distribuidor> buscarTodos()
    {
        return distribuidorRepository.findAll();
    }
    
}
