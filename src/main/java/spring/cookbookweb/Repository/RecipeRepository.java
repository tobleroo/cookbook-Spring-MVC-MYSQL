package spring.cookbookweb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.cookbookweb.Entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

    Recipe findByRecipeName(String name);

    Recipe findByRecipeId(long id);
    
    List<Recipe> findByMealType(String type);

    List<Recipe> findByRecipeNameContaining(String name);

    List<Recipe> findByUserAccountId(Long id);
    
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
