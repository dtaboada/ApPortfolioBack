

package com.portfolio.portfolio.Interface;

import com.portfolio.portfolio.Model.Proyecto;
import java.util.List;
import java.util.Optional;


public interface IProyectoService {
 
    //método para traer la lista de todas las Proyectos
    public List<Proyecto> getProyecto();
    
    //método guardad Proyecto
    public void saveProyecto (Proyecto perso);
    
    //metodo para borrar Proyectos
    public void deleteProyecto (Long id);
    
    //metodo buscar Proyecto por id
    public Proyecto findProyecto (Long id);
    
    //metodo nuevo traer una experiencia
     public Optional <Proyecto> getOne(Long id);
     
    //
     public boolean existsById(Long id);
   
}
