
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Interface.IEducacionService;
import com.portfolio.portfolio.Model.Educacion;
import com.portfolio.portfolio.Repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
     @Autowired
    private EducacionRepository educRepository;
      
@Override 
     public List<Educacion> getEducacion(){
        List<Educacion> listaEducacions = educRepository.findAll();
        return listaEducacions;
    }
   
  @Override
    public void saveEducacion(Educacion educ) {
       educRepository.save(educ); 
    }

    @Override
    public void deleteEducacion(Long id) {
        educRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educ= educRepository.findById(id).orElse(null);   
        return educ;
    }
    
}