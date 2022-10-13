package spring.cookbookweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.cookbookweb.Entity.IngredientWeightType;

@Repository
public interface IngredientWeightRepository extends JpaRepository<IngredientWeightType, Long>{
    
    IngredientWeightType findByWeightType(String weight);
}
