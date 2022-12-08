
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Interface.IPersonaService;
import com.portfolio.portfolio.Model.Persona;
import com.portfolio.portfolio.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
     @Autowired
    private PersonaRepository persoRepository;
      
@Override 
     public List<Persona> getPersona(){
        List<Persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }
   
  @Override
    public void savePersona(Persona perso) {
       persoRepository.save(perso); 
    }

    @Override
    public void deletePersona(Long id) {
        persoRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso= persoRepository.findById(id).orElse(null);   
        return perso;
    }
    
}