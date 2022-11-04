package spring.cookbookweb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.cookbookweb.Entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{

    Recipe findByRecipeName(String name);

    Recipe findByRecipeId(long id);
    
    List<Recipe> findByMealType(String type);

    List<Recipe> findByRecipeNameContaining(String name);
    
    // fresh searches
    //1.
    List<Recipe> findByCookTimeLessThanEqual(int maxTime);
    //2.
    List<Recipe> findByRecipeNameContainingAndCookTimeLessThanEqual(String searchName, int maxTime);
    //3.
    List<Recipe> findByMealTypeAndCookTimeLessThanEqual(String type, int maxtime);
    //4.
    List<Recipe> findByRecipeNameContainingAndMealTypeAndCookTimeLessThanEqual(String searchName, String mealType, int maxtime);

}
