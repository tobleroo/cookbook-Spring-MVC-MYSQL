package spring.cookbookweb.Services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Repository.IngredientAmountRepository;
import spring.cookbookweb.Repository.IngredientRepository;
import spring.cookbookweb.Repository.IngredientWeightRepository;
import spring.cookbookweb.Repository.RecipeRepository;

@Service
public class SearchService {
    
    IngredientRepository ingrRepo;
    RecipeRepository recRepo;
    IngredientAmountRepository amountRepo;
    IngredientWeightRepository weightRepo;

    public SearchService(IngredientRepository ingrRepo, RecipeRepository recRepo,
    IngredientAmountRepository amountRepo, IngredientWeightRepository weightRepo) {
        this.ingrRepo = ingrRepo;
        this.recRepo = recRepo;
        this.amountRepo = amountRepo;
        this.weightRepo = weightRepo;
    }

    public List<Recipe> searchCookBook(String mealType, String maxCookTime, String nameToSearch){

        //convert input number from string to int
        int cookTime = 100000;
        if(maxCookTime != ""){
            cookTime = Integer.parseInt(maxCookTime);
        }

        List<Recipe> searchesRecipies = new ArrayList<>();
        if(mealType.equals("all") && nameToSearch == ""){
            //search all with no input name search. if time isnt inputed it will return all.
            searchesRecipies = recRepo.findByCookTimeLessThanEqual(cookTime);
            System.out.println("in first");
        }else if(!(mealType.equals("all")) && nameToSearch == ""){
            searchesRecipies = recRepo.findByMealTypeAndCookTimeLessThanEqual(mealType, cookTime);
        }else if(!(mealType.equals("all")) && nameToSearch != ""){
            //search by NOT all with name search inputed
            searchesRecipies = recRepo.findByRecipeNameContainingAndMealTypeAndCookTimeLessThanEqual(nameToSearch, mealType, cookTime);
            System.out.println("in second");
        }else if(nameToSearch != ""){
            searchesRecipies = recRepo.findByRecipeNameContainingAndCookTimeLessThanEqual(nameToSearch, cookTime);
            System.out.println("in third");
        }
        
        return searchesRecipies;
    }
}
