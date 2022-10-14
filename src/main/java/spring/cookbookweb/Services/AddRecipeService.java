package spring.cookbookweb.Services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Entity.Ingredient;
import spring.cookbookweb.Entity.IngredientAmount;
import spring.cookbookweb.Entity.IngredientWeightType;
import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Repository.IngredientAmountRepository;
import spring.cookbookweb.Repository.IngredientRepository;
import spring.cookbookweb.Repository.IngredientWeightRepository;
import spring.cookbookweb.Repository.RecipeRepository;

@Service
public class AddRecipeService {
    
    IngredientRepository ingrRepo;
    RecipeRepository recRepo;
    IngredientAmountRepository amountRepo;
    IngredientWeightRepository weightRepo;

    public AddRecipeService(IngredientRepository ingrRepo, RecipeRepository recRepo,
    IngredientAmountRepository amountRepo, IngredientWeightRepository weightRepo) {
        this.ingrRepo = ingrRepo;
        this.recRepo = recRepo;
        this.amountRepo = amountRepo;
        this.weightRepo = weightRepo;
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

    // method to save ingredients AMOUNT types
    public void addAmountsToDB(float [] amountToAddList){

        // convert int array to ingredientAmount obj
        List<IngredientAmount> newAmounts = new ArrayList<>();
        for(float amountToAdd : amountToAddList){
            newAmounts.add(new IngredientAmount(amountToAdd));
        }
        // run through each new ingredient to see if it exists and save
        for(IngredientAmount newIngrAmount : newAmounts){
            if(amountRepo.findByAmount(newIngrAmount.getAmount()) == null){
                amountRepo.save(newIngrAmount);
                System.out.println("ingredient amount object saved to DB");
            }else{
                System.out.println("amount does exist already in DB");
            }
        }
    }

    // method to save ingredient weight types
    public void addWeightsTypeToDB(String [] weightTypes){

        // convert int array to ingredientAmount obj
        List<IngredientWeightType> newAmounts = new ArrayList<>();
        for(String weightToAdd : weightTypes){
            newAmounts.add(new IngredientWeightType(weightToAdd));
        }
        // run through each new ingredient to see if it exists and save
        for(IngredientWeightType newIngrWeight : newAmounts){
            if(weightRepo.findByWeightType(newIngrWeight.getWeightType())== null){
                weightRepo.save(newIngrWeight);
                System.out.println("ingredient weight object saved to DB");
            }else{
                System.out.println("amount does exist already in DB");
            }
        }
    }

    // final method to save it all to a recipe to db
    public void addRecipeToDBWithIngredients(Recipe myRecipe, String[] ingredients, float[] ingrAmounts, String [] weightType){
        
        List<Ingredient> ingredientsList = new ArrayList<>();
        //add amount and weight type to the ingredients first, then add them to the right recipe
        for(int i = 0; i < ingredients.length; i++){
            Ingredient oneIngredient = ingrRepo.findByIngredientName(ingredients[i]);
            oneIngredient.setAmountObj(amountRepo.findByAmount(ingrAmounts[i]));
            oneIngredient.setWeightObj(weightRepo.findByWeightType(weightType[i]));
            ingredientsList.add(oneIngredient);
        }

        myRecipe.setIngredients(ingredientsList);
        recRepo.save(myRecipe);
        
    }
}
