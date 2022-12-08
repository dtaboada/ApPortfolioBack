

package com.portfolio.portfolio.Interface;

import com.portfolio.portfolio.Model.Educacion;
import java.util.List;


public interface IEducacionService {
 
    //método para traer la lista de todas las Educacions
    public List<Educacion> getEducacion();
    
    //método guardad Educacion
    public void saveEducacion (Educacion educ);
    
    //metodo para borrar Educacions
    public void deleteEducacion (Long id);
    
    //metodo buscar Educacion por id
    public Educacion findEducacion (Long id);
   
}
