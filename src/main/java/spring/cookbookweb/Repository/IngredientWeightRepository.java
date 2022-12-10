package spring.cookbookweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.cookbookweb.Entity.IngredientWeightType;

public interface IngredientWeightRepository extends JpaRepository<IngredientWeightType, Long>{
    
    IngredientWeightType findByWeightType(String weight);
}
