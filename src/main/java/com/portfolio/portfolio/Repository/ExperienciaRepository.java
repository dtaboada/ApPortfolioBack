

package com.portfolio.portfolio.Repository;

import com.portfolio.portfolio.Model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Long>{
    
    public Optional<Experiencia> findByPuesto(String puesto);
    
    public boolean existsById(String id);
}

