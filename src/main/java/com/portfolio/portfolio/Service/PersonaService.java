
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Interface.IPersonaService;
import com.portfolio.portfolio.Model.Experiencia;
import com.portfolio.portfolio.Model.Persona;
import com.portfolio.portfolio.Repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
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
    
        
    public boolean existsById(Long id) {
        return persoRepository.existsById(id);
    }

    @Override
    public Optional<Persona> getOne(Long id) {
         return persoRepository.findById(id);
    }     
    
    
}