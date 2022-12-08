
package com.portfolio.portfolio.Controller;


import com.portfolio.portfolio.Interface.ISkillService;
import com.portfolio.portfolio.Model.Skill;
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
public class SkillController {
    
    @Autowired
    private ISkillService interSkill;
    
    @GetMapping ("skill/traer")
    public List<Skill> getSkill(){
        
        return interSkill.getSkill();
    }
    
    @PostMapping ("/skill/crear")
    public String saveSkill (@RequestBody Skill skill){
    
        interSkill.saveSkill(skill);
        return "Mensaje: La Skill fue creada Correctamente";
    }
    
    @DeleteMapping ("/skill/borrar/{id}")
    public String deleteSkill (@PathVariable Long id){
        
        interSkill.deleteSkill(id);
        return "Mensaje: la Skill fue eliminada correctamente";
    }
    
    @PutMapping ("skill/editar/{id}")
    public Skill editSkill (@PathVariable Long id,
                            @RequestParam ("porcentaje") Short nuevoPorcentaje,
                            @RequestParam ("descripcion") String nuevoDescripcion){
                               
            //buqueda      
            Skill skill = interSkill.findSkill(id);
            
            skill.setPorcentaje(nuevoPorcentaje);
            skill.setDescripcion(nuevoDescripcion);
       
            
        
            interSkill.saveSkill(skill);
            return skill;
        }   
    }             






