
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Interface.IExperienciaService;
import com.portfolio.portfolio.Model.Experiencia;
import com.portfolio.portfolio.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository expeRepository;
      
    @Override 
     public List<Experiencia> getExperiencia(){
        List<Experiencia> listaExperiencias = expeRepository.findAll();
        return listaExperiencias;
    }
   
    @Override
    public void saveExperiencia(Experiencia expe) {
       expeRepository.save(expe); 
    }

    @Override
    public void deleteExperiencia(Long id) {
        expeRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia expe= expeRepository.findById(id).orElse(null);   
        return expe;
    }
    
    
    public boolean existsById(Long id) {
        return expeRepository.existsById(id);
    }

    @Override
    public Optional<Experiencia> getOne(Long id) {
         return expeRepository.findById(id);
    }       
}