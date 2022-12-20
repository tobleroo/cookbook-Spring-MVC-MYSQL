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

    List<Recipe> findByCookTimeLessThanEqualAndUserAccountId(int maxTime, Long id);
    //2.
    List<Recipe> findByRecipeNameContainingAndCookTimeLessThanEqualAndUserAccountId(String searchName, int maxTime, Long id);
    //3.
    List<Recipe> findByMealTypeAndCookTimeLessThanEqualAndUserAccountId(String type, int maxtime, Long id);
    //4.
    List<Recipe> findByRecipeNameContainingAndMealTypeAndCookTimeLessThanEqualAndUserAccountId(String searchName, String mealType, int maxtime, Long id);

}
