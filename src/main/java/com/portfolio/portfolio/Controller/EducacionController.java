
package com.portfolio.portfolio.Controller;


import com.portfolio.portfolio.Interface.IEducacionService;
import com.portfolio.portfolio.Model.Educacion;
import com.portfolio.portfolio.Model.Experiencia;
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

public class EducacionController {
    
    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping ("educacion/traer")
    public List<Educacion> getEducacion(){
        
        return interEducacion.getEducacion();
        
    }
    
       @GetMapping("/educacion/detalle/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
        if(!interEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = interEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }  
    
    @PostMapping ("/educacion/crear")
    public ResponseEntity saveEducacion (@RequestBody Educacion educ){
    
        interEducacion.saveEducacion(educ);
        //return "Mensaje: La Educacion fue creada Correctamente";
        return new ResponseEntity(new Mensaje("La experiencia fue creada Correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/educacion/borrar/{id}")
    public ResponseEntity deleteEducacion (@PathVariable Long id){
        
        interEducacion.deleteEducacion(id);
        //return "Mensaje: la Educacion fue eliminada correctamente";
        return new ResponseEntity(new Mensaje("La Educacion fue Borrada Correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("educacion/editar/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Educacion educ){
        //Validamos si existe el ID
        if(!interEducacion.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

         //El puesto no puede estar 
        if(StringUtils.isBlank(educ.getTitulo()))
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        // Agragar Validaciones{
            //buqueda      
           
            Educacion educMod = interEducacion.getOne(id).get();
            educMod.setTitulo(educ.getTitulo());
            educMod.setInstitucion(educ.getInstitucion());
            educMod.setAnioInicio(educ.getAnioInicio());
            educMod.setAnioFin(educ.getAnioFin());
            educMod.setDescripcion(educ.getDescripcion());
            educMod.setLogo(educ.getLogo());
        
            interEducacion.saveEducacion(educMod);
            return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
        
    }             
}
// Version Anterior:

//  @PutMapping ("educacion/editar/{id}")
//    public Educacion editEducacion (@PathVariable Long id,
//                                @RequestParam ("titulo") String nuevoTitulo,
//                                @RequestParam ("institucion") String nuevoInstitucion,
//                                @RequestParam ("anioInicio") String nuevoAnioInicio,
//                                @RequestParam ("anioFin") String nuevoAnioFin,
//                                @RequestParam ("descripcion") String nuevoDescripcion,
//                                @RequestParam ("logo") String nuevoLogo){
//            //buqueda      
//            Educacion educ = interEducacion.findEducacion(id);
//            
//            educ.setTitulo(nuevoTitulo);
//            educ.setInstitucion(nuevoInstitucion);
//            educ.setAnioInicio(nuevoAnioInicio);
//            educ.setAnioFin(nuevoAnioFin);
//            educ.setDescripcion(nuevoDescripcion);
//            educ.setLogo(nuevoLogo);
//            
//        
//            interEducacion.saveEducacion(educ);
//            return educ;
