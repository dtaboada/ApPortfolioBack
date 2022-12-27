
package com.portfolio.portfolio.Controller;


import com.portfolio.portfolio.Interface.IProyectoService;
import com.portfolio.portfolio.Model.Proyecto;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService interProyecto;
    
    @GetMapping ("proyecto/traer")
    public List<Proyecto> getProyecto(){
        
        return interProyecto.getProyecto();
    }
    
    @PostMapping ("/proyecto/crear")
    public String saveProyecto (@RequestBody Proyecto educ){
    
        interProyecto.saveProyecto(educ);
        return "Mensaje: La Proyecto fue creada Correctamente";
    }
    
    @DeleteMapping ("/proyecto/borrar/{id}")
    public String deleteProyecto (@PathVariable Long id){
        
        interProyecto.deleteProyecto(id);
        return "Mensaje: la Proyecto fue eliminada correctamente";
    }
    
    @PutMapping ("proyecto/editar/{id}")
    public Proyecto editProyecto (@PathVariable Long id,
                                  @RequestParam ("titulo") String nuevoTitulo,
                                  @RequestParam ("anio") String nuevoAnio,
                                  @RequestParam ("descripcion") String nuevoDescripcion,
                                  @RequestParam ("link") String nuevoLink){
            //buqueda      
            Proyecto educ = interProyecto.findProyecto(id);
            
            educ.setTitulo(nuevoTitulo);
            educ.setAnio(nuevoAnio);
            educ.setDescripcion(nuevoDescripcion);
            educ.setLink(nuevoLink);
            
        
            interProyecto.saveProyecto(educ);
            return educ;
        
    }             
}





