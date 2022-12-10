package spring.cookbookweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.cookbookweb.Entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
    
    Ingredient findByIngredientName(String name);
}
