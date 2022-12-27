
package com.portfolio.portfolio.Controller;

import com.portfolio.portfolio.Interface.IPersonaService;
import com.portfolio.portfolio.Model.Persona;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping ("personas/traer")
    public List<Persona> getPersona(){
        
        return interPersona.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
    
        interPersona.savePersona(perso);
        return "Mensaje: La persona fue creada Correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona (@PathVariable Long id){
        
        interPersona.deletePersona(id);
        return "Mensaje: la persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("acerca") String nuevoAcerca,
                                @RequestParam ("banner") String nuevoBanner,
                                @RequestParam ("foto") String nuevoFoto,
                                @RequestParam ("telefono") String nuevoTelefono,
                                @RequestParam ("mail") String nuevoMail){
            //buqueda      
            Persona perso = interPersona.findPersona(id);
            
            perso.setApellido(nuevoApellido);
            perso.setNombre(nuevoNombre);
            perso.setTitulo(nuevoTitulo);
            perso.setAcerca(nuevoAcerca);
            perso.setBanner(nuevoBanner);
            perso.setFoto(nuevoFoto);
            perso.setTelefono(nuevoTelefono);
            perso.setMail (nuevoMail);
        
            interPersona.savePersona(perso);
            return perso; 
        
    }             
}





