

package com.portfolio.portfolio.Repository;

import com.portfolio.portfolio.Model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository <Educacion, Long>{
    
}

