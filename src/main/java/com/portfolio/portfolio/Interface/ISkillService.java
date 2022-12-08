

package com.portfolio.portfolio.Interface;

import com.portfolio.portfolio.Model.Skill;
import java.util.List;


public interface ISkillService {
 
    //método para traer la lista de todas las Skills
    public List<Skill> getSkill();
    
    //método guardad Skill
    public void saveSkill (Skill skill);
    
    //metodo para borrar Skills
    public void deleteSkill (Long id);
    
    //metodo buscar Skill por id
    public Skill findSkill (Long id);
   
}
