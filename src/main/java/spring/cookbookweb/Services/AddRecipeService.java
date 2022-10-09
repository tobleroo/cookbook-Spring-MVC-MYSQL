package spring.cookbookweb.Services;



import java.util.List;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Entity.Ingredient;
import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Repository.IngredientRepository;
import spring.cookbookweb.Repository.RecipeRepository;

@Service
public class AddRecipeService {
    
    IngredientRepository ingrRepo;
    RecipeRepository recRepo;

    public AddRecipeService(IngredientRepository ingrRepo, RecipeRepository recRepo) {
        this.ingrRepo = ingrRepo;
        this.recRepo = recRepo;
    }

    // check if the ingredient already exists
    public void checkIfIngredientExists(){
        //get all currently existing ingredients in DB
        // List<Ingredient> myIngrs = ingrRepo.findAll();
        //System.out.println(myIngrs.get(0).getIngredientName());

        //see if i get ingredients when i collect a recipe obj
        Long one = (long) 1;
        Recipe myRecipe = recRepo.findById(one).get();
        List<Ingredient> recipeIngrs = myRecipe.getIngredients();
        // System.out.println(recipeIngrs.get(0).getIngredientName());

        // get all ingredients
        List<Ingredient> allIngrs = ingrRepo.findAll();
        for (Ingredient ingredient : allIngrs) {
            System.out.println(ingredient.getIngredientName());
        }
        
    }
}
