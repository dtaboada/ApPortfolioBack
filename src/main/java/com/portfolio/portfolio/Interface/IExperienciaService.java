

package com.portfolio.portfolio.Interface;
import com.portfolio.portfolio.Model.Experiencia;
import java.util.List;
import java.util.Optional;


public interface IExperienciaService {
 
    //método para traer la lista de todas las Experiencias
    public List<Experiencia> getExperiencia();
    
    //método guardad Experiencia
    public void saveExperiencia (Experiencia perso);
    
    //metodo para borrar Experiencias
    public void deleteExperiencia (Long id);
    
    //metodo buscar Experiencia por id
    public Experiencia findExperiencia (Long id);
       
    //metodo nuevo traer una experiencia
     public Optional <Experiencia> getOne(Long id);
     
      //metodo nuevo traer una experiencia
     public boolean existsById(Long id);
   
}