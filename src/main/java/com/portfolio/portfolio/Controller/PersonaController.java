
package com.portfolio.portfolio.Controller;

import com.portfolio.portfolio.Interface.IPersonaService;
import com.portfolio.portfolio.Model.Persona;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfoliodiego.onrender.com/")
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

    //edita solo los datos de la personas No foto - No Banner.
    
   
    @PutMapping ("personas/editardatos/{id}")
    
    public ResponseEntity<?> editDatosPersona(@PathVariable("id") long id, @RequestBody Persona p){
        //Validamos si existe el ID
        
        if(!interPersona.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

         //El puesto no puede estar 
        if(StringUtils.isBlank(p.getNombre()))
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        // Agragar Validaciones{
            
//buqueda      
            Persona perso = interPersona.findPersona(id);
            
            perso.setApellido(p.getApellido());
            perso.setNombre(p.getNombre());
            perso.setTitulo(p.getTitulo());
            perso.setAcerca(p.getAcerca());
            perso.setTelefono(p.getTelefono());
            perso.setMail (p.getMail());
        
            interPersona.savePersona(perso);
            return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
        
    }   
    
        @PutMapping ("personas/editarfoto/{id}")
    
    public ResponseEntity<?> editFotoPersona(@PathVariable("id") long id, @RequestBody Persona p){
        //Validamos si existe el ID
        
        if(!interPersona.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        // Agragar Validaciones{
            
        //buqueda      
            Persona perso = interPersona.findPersona(id);
            
            perso.setFoto(p.getFoto());
          
            interPersona.savePersona(perso);
            return new ResponseEntity(new Mensaje("Foto Actualizada"), HttpStatus.OK);   
    }  

    @PutMapping ("personas/editarbanner/{id}")
    
    public ResponseEntity<?> editFotoBanner(@PathVariable("id") long id, @RequestBody Persona p){
        //Validamos si existe el ID
        
        if(!interPersona.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        // Agragar Validaciones{
            
        //buqueda      
            Persona perso = interPersona.findPersona(id);
            
            perso.setBanner (p.getBanner());
          
            interPersona.savePersona(perso);
            return new ResponseEntity(new Mensaje("Banner Actualizado"), HttpStatus.OK);   
    }      
}
