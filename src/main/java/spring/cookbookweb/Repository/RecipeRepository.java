package spring.cookbookweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.cookbookweb.Entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{

    Recipe findByRecipeName(String name);

    Recipe findByRecipeId(long id);
    
}
