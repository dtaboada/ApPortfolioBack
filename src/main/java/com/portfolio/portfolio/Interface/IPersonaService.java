

package com.portfolio.portfolio.Interface;

import com.portfolio.portfolio.Model.Persona;
import java.util.List;
import java.util.Optional;


public interface IPersonaService {
 
    //método para traer la lista de todas las personas
    public List<Persona> getPersona();
    
    //método guardad persona
    public void savePersona (Persona perso);
    
    //metodo para borrar personas
    public void deletePersona (Long id);
    
    //metodo buscar persona por id
    public Persona findPersona (Long id);
    
        //metodo nuevo traer una persona
     public Optional <Persona> getOne(Long id);
     
      //metodo nuevo traer una persona
     public boolean existsById(Long id);
   
} 
