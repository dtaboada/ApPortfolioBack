
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Interface.IProyectoService;
import com.portfolio.portfolio.Model.Proyecto;
import com.portfolio.portfolio.Repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
     @Autowired
    private ProyectoRepository educRepository;
      
@Override 
     public List<Proyecto> getProyecto(){
        List<Proyecto> listaProyectos = educRepository.findAll();
        return listaProyectos;
    }
   
  @Override
    public void saveProyecto(Proyecto educ) {
       educRepository.save(educ); 
    }

    @Override
    public void deleteProyecto(Long id) {
        educRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        Proyecto educ= educRepository.findById(id).orElse(null);   
        return educ;
    }
    
}