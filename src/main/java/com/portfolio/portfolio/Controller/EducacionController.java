
package com.portfolio.portfolio.Controller;


import com.portfolio.portfolio.Interface.IEducacionService;
import com.portfolio.portfolio.Model.Educacion;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping ("educacion/traer")
    public List<Educacion> getEducacion(){
        
        return interEducacion.getEducacion();
    }
    
    @PostMapping ("/educacion/crear")
    public String saveEducacion (@RequestBody Educacion educ){
    
        interEducacion.saveEducacion(educ);
        return "Mensaje: La Educacion fue creada Correctamente";
    }
    
    @DeleteMapping ("/educacion/borrar/{id}")
    public String deleteEducacion (@PathVariable Long id){
        
        interEducacion.deleteEducacion(id);
        return "Mensaje: la Educacion fue eliminada correctamente";
    }
    
    @PutMapping ("educacion/editar/{id}")
    public Educacion editEducacion (@PathVariable Long id,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("institucion") String nuevoInstitucion,
                                @RequestParam ("anioInicio") String nuevoAnioInicio,
                                @RequestParam ("anioFin") String nuevoAnioFin,
                                @RequestParam ("descripcion") String nuevoDescripcion,
                                @RequestParam ("logo") String nuevoLogo){
            //buqueda      
            Educacion educ = interEducacion.findEducacion(id);
            
            educ.setTitulo(nuevoTitulo);
            educ.setInstitucion(nuevoInstitucion);
            educ.setAnioInicio(nuevoAnioInicio);
            educ.setAnioFin(nuevoAnioFin);
            educ.setDescripcion(nuevoDescripcion);
            educ.setLogo(nuevoLogo);
            
        
            interEducacion.saveEducacion(educ);
            return educ;
        
    }             
}





