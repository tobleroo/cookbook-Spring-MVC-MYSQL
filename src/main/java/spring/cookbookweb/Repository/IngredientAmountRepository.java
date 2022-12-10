package spring.cookbookweb.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import spring.cookbookweb.Entity.IngredientAmount;

public interface IngredientAmountRepository extends JpaRepository<IngredientAmount, Long>{
    
    IngredientAmount findByAmount(float value);
}
