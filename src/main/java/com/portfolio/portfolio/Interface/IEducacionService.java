

package com.portfolio.portfolio.Interface;

import com.portfolio.portfolio.Model.Educacion;
import java.util.List;
import java.util.Optional;


public interface IEducacionService {
 
    //método para traer la lista de todas las Educacions
    public List<Educacion> getEducacion();
    
    //método guardad Educacion
    public void saveEducacion (Educacion educ);
    
    //metodo para borrar Educacions
    public void deleteEducacion (Long id);
    
    //metodo buscar Educacion por id
    public Educacion findEducacion (Long id);
   
       //metodo nuevo traer una educacion
     public Optional <Educacion> getOne(Long id);
     
      //metodo nuevo traer una educacion
     public boolean existsById(Long id);
    
}
