
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Interface.ISkillService;
import com.portfolio.portfolio.Model.Skill;
import com.portfolio.portfolio.Repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    
     @Autowired
    private SkillRepository skillRepository;
      
@Override 
     public List<Skill> getSkill(){
        List<Skill> listaSkills = skillRepository.findAll();
        return listaSkills;
    }
   
  @Override
    public void saveSkill(Skill skill) {
       skillRepository.save(skill); 
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill= skillRepository.findById(id).orElse(null);   
        return skill;
    }
    
}