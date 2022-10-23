package spring.cookbookweb.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.cookbookweb.Entity.IngredientAmount;

@Repository
public interface IngredientAmountRepository extends JpaRepository<IngredientAmount, Long>{
    
    IngredientAmount findByAmount(float value);
}
