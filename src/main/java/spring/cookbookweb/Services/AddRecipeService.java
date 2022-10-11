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
        Set<Ingredient> newIngredients = new HashSet<>();
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
        Set<Ingredient> mySetOfIngrs = new HashSet<>();
        // for(String ingredientToAdd : ingredients){
        //     Ingredient demo = ingrRepo.findByIngredientName(ingredientToAdd);
        //     mySetOfIngrs.add(demo);
        // }

        // cant add more than one ingredient obj to the set
        Ingredient demo = ingrRepo.findByIngredientName("potato");
        mySetOfIngrs.add(demo);
        Ingredient demo2 = ingrRepo.findByIngredientName("sallad");
        mySetOfIngrs.add(demo2);
        System.out.println(mySetOfIngrs.isEmpty());
        
    }
}
