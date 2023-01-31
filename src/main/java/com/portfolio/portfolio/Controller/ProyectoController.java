
package com.portfolio.portfolio.Controller;


import com.portfolio.portfolio.Interface.IProyectoService;
import com.portfolio.portfolio.Model.Experiencia;
import com.portfolio.portfolio.Model.Proyecto;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfoliodiego.onrender.com/")
public class ProyectoController {
    
    @Autowired
    private IProyectoService interProyecto;
    
     @GetMapping ("proyecto/traer")
    public List<Proyecto> getProyectos(){
        
        return interProyecto.getProyecto();
    }
    
    
    @GetMapping ("proyecto/detalle/{id}")
     public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id){
        if(!interProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = interProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping ("/proyecto/crear")
    public ResponseEntity saveProyecto (@RequestBody Proyecto proyecto){
    
        interProyecto.saveProyecto(proyecto);
        //return "Mensaje: El Proyecto fue creada Correctamente";
         return new ResponseEntity(new Mensaje("El proyecto fue creado Correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/proyecto/borrar/{id}")
    public ResponseEntity deleteProyecto (@PathVariable Long id){
        
        interProyecto.deleteProyecto(id);
        //return "Mensaje: la Proyecto fue eliminada correctamente";
        return new ResponseEntity(new Mensaje("El proyecto Borrado Correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/proyecto/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Proyecto proyecto){
        //Validamos si existe el ID
        if(!interProyecto.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

         //El puesto no puede estar 
        if(StringUtils.isBlank(proyecto.getTitulo()))
            return new ResponseEntity(new Mensaje("El Puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        // Agragar Validaciones
   
        Proyecto proyectomod = interProyecto.getOne(id).get();
        proyectomod.setTitulo(proyecto.getTitulo());
        proyectomod.setAnio(proyecto.getAnio());
        proyectomod.setDescripcion(proyecto.getDescripcion());
        proyectomod.setLink(proyecto.getLink());
       
        
        interProyecto.saveProyecto(proyectomod);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }
    
//    VERSION INICIAL  
//    
//    @PutMapping ("proyecto/editar/{id}")
//    public Proyecto editProyecto (@PathVariable Long id,
//                                  @RequestParam ("titulo") String nuevoTitulo,
//                                  @RequestParam ("anio") String nuevoAnio,
//                                  @RequestParam ("descripcion") String nuevoDescripcion,
//                                  @RequestParam ("link") String nuevoLink){
//            //buqueda      
//            Proyecto educ = interProyecto.findProyecto(id);
//            
//            educ.setTitulo(nuevoTitulo);
//            educ.setAnio(nuevoAnio);
//            educ.setDescripcion(nuevoDescripcion);
//            educ.setLink(nuevoLink);
//            
//        
//            interProyecto.saveProyecto(educ);
//            return educ;
//        
//    }             
}





