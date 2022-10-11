package spring.cookbookweb.Services;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    // check if the ingredient already exists else save it
    public void addIngredientsToDB(String [] ingredientsToAdd){

        // convert string array to ingredient obj
        List<Ingredient> newIngredients = new ArrayList<>();
        for(String ingrNewName : ingredientsToAdd){
            newIngredients.add(new Ingredient(ingrNewName));
        }
        // run through each new ingredient to see if it exists and save
        for(Ingredient newIngr : newIngredients){
            if(ingrRepo.findByIngredientName(newIngr.getIngredientName()) == null){
                ingrRepo.save(newIngr);
                System.out.println("ingredient object saved to DB");
            }else{
                System.out.println("obj does exist already");
            }
        }
    }

    public void addRecipeToDBWithIngredients(Recipe myRecipe, String[] ingredients){
        
        
        List<Ingredient> ingredientsList = new ArrayList<>();
        for(String myIngrName : ingredients){
            ingredientsList.add(ingrRepo.findByIngredientName(myIngrName));
        }

        myRecipe.setIngredients(ingredientsList);
        recRepo.save(myRecipe);
        
    }
}
