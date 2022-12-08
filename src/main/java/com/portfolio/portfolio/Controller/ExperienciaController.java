
package com.portfolio.portfolio.Controller;


import com.portfolio.portfolio.Interface.IExperienciaService;
import com.portfolio.portfolio.Model.Experiencia;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService interExperincia;
    
    @GetMapping ("experiencia/traer")
    public List<Experiencia> getExperiencia(){
        
        return interExperincia.getExperiencia();
    }
    
    @PostMapping ("/experiencia/crear")
    public String saveExperciencia (@RequestBody Experiencia expe){
    
        interExperincia.saveExperiencia(expe);
        return "Mensaje: La experiencia fue creada Correctamente";
    }
    
    @DeleteMapping ("/experiencia/borrar/{id}")
    public String deleteExperencia (@PathVariable Long id){
        
        interExperincia.deleteExperiencia(id);
        return "Mensaje: la experiencia fue eliminada correctamente";
    }
    
    @PutMapping ("experiencia/editar/{id}")
    public Experiencia editExperiencia (@PathVariable Long id,
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
            return expe;
        
    }             
}





