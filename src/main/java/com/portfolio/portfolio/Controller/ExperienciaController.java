
package com.portfolio.portfolio.Controller;


import com.portfolio.portfolio.Interface.IExperienciaService;
import com.portfolio.portfolio.Model.Experiencia;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService interExperincia;
    
    @GetMapping ("experiencia/traer")
    public List<Experiencia> getExperiencia(){
        
        return interExperincia.getExperiencia();
    }
      
    @PostMapping ("/experiencia/crear")
    public ResponseEntity saveExperciencia (@RequestBody Experiencia expe){
    
        interExperincia.saveExperiencia(expe);
        //return "Mensaje: La experiencia fue creada Correctamente";
         return new ResponseEntity(new Mensaje("La experiencia fue creada Correctamente"), HttpStatus.OK);
    }
 
        
    
    
    @DeleteMapping ("/experiencia/borrar/{id}")
    public ResponseEntity deleteExperencia (@PathVariable Long id){
        
        interExperincia.deleteExperiencia(id);
        return new ResponseEntity(new Mensaje("La experiencia fue creada Correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("experiencia/editar/{id}")
    public ResponseEntity editExperiencia (@PathVariable Long id,
                                @RequestParam ("puesto") String nuevoPuesto,
                                @RequestParam ("empresa") String nuevoEmpresa,
                                @RequestParam ("anioInicio") String nuevoAnioInicio,
                                @RequestParam ("anioFin") String nuevoAnioFin,
                                @RequestParam ("descripcion") String nuevoDescripcion,
                                @RequestParam ("logo") String nuevoLogo){
            //buqueda      
            Experiencia expe = interExperincia.findExperiencia(id);
            
            expe.setPuesto(nuevoPuesto);
            expe.setEmpresa(nuevoEmpresa);
            expe.setAnioInicio(nuevoAnioInicio);
            expe.setAnioFin(nuevoAnioFin);
            expe.setDescripcion(nuevoDescripcion);
            expe.setLogo(nuevoLogo);
            
        
            interExperincia.saveExperiencia(expe);
            return new ResponseEntity(new Mensaje("La experiencia fue editada  Correctamente"), HttpStatus.OK);
        
    }             
}





