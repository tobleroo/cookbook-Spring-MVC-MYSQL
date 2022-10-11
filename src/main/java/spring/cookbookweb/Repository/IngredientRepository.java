package spring.cookbookweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.cookbookweb.Entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
    
    Ingredient findByIngredientName(String name);
}
