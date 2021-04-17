package com.miggonzalv.videojuegos.repository;

import com.miggonzalv.videojuegos.domain.Videojuego;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VideojuegosRepository extends JpaRepository<Videojuego, Integer>
{
    @Query("from Videojuego v order by v.nombre")
    List<Videojuego> buscarTodos();    
    
    @Query("from Videojuego v where v.distribuidor.id = ?1 order by v.nombre")
    List<Videojuego> buscarPorDistribuidor(int distribuidorId);  
    
    @Query("from Videojuego v where v.nombre like %?1%")
    List<Videojuego> buscar(String consulta);  
    
    /*Esta funcion hace lo mismo que buscar pero es generada por JPA automaticamente
    Esto es debido a que por el nombre findBy deduce que es busqueda con Nombre busca el parametro
    nombre y luego con Containing se encargara de aquello que contengan el nombre*/
    //List<Videojuego> findByNombreContaining(String consulta); 
}
