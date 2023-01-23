
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Interface.IProyectoService;
import com.portfolio.portfolio.Model.Experiencia;
import com.portfolio.portfolio.Model.Proyecto;
import com.portfolio.portfolio.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
     @Autowired
    private ProyectoRepository proyRepository;
      
@Override 
     public List<Proyecto> getProyecto(){
        List<Proyecto> listaProyectos = proyRepository.findAll();
        return listaProyectos;
    }
   
  @Override
    public void saveProyecto(Proyecto educ) {
       proyRepository.save(educ); 
    }

    @Override
    public void deleteProyecto(Long id) {
        proyRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        Proyecto educ= proyRepository.findById(id).orElse(null);   
        return educ;
    }
    
    public boolean existsById(Long id) {
        return proyRepository.existsById(id);
    }
      
    @Override
    public Optional<Proyecto> getOne(Long id) {
         return proyRepository.findById(id);
    }
}