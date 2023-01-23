
package com.portfolio.portfolio.Controller;


import com.portfolio.portfolio.Interface.ISkillService;
import com.portfolio.portfolio.Model.Skill;
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
public class SkillController {
    
    @Autowired
    private ISkillService interSkill;
    
    @GetMapping ("skill/traer")
    public List<Skill> getSkill(){
        
        return interSkill.getSkill();
    }
    
    @PostMapping ("/skill/crear")
    public ResponseEntity saveSkill (@RequestBody Skill skill){
    
        interSkill.saveSkill(skill);
        return new ResponseEntity(new Mensaje("Mensaje: La Skill fue creada Correctamente"), HttpStatus.OK);
       
    }
    
    @DeleteMapping ("/skill/borrar/{id}")
    public ResponseEntity deleteSkill (@PathVariable Long id){
        
        interSkill.deleteSkill(id);
        return new ResponseEntity(new Mensaje("Mensaje: la Skill fue eliminada correctamente"), HttpStatus.OK);
      
    }
    
    @PutMapping ("skill/editar/{id}")
    public ResponseEntity editSkill (@PathVariable Long id,
                            @RequestParam ("porcentaje") Short nuevoPorcentaje,
                            @RequestParam ("descripcion") String nuevoDescripcion){
                               
            //buqueda      
            Skill skill = interSkill.findSkill(id);
            
            skill.setPorcentaje(nuevoPorcentaje);
            skill.setDescripcion(nuevoDescripcion);
       
            
        
            interSkill.saveSkill(skill);
            return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
        }   
    }             






