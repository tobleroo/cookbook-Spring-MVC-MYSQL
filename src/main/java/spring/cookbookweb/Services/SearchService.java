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

    public Boolean checkIfMealtypeExists(String mealtype){
        return recRepo.existsByMealType(mealtype);
    }

    public List<Recipe> searchCookBook(String mealType, String maxCookTime, String nameToSearch, Long id){

        //convert input number from string to int
        int cookTime = 100000;
        if(maxCookTime != ""){
            cookTime = Integer.parseInt(maxCookTime);
        }

        List<Recipe> searchesRecipies = new ArrayList<>();

        //1. all types , no search text , max time
        //2. all types , with search text , max time
        //3. specific type, no search , time
        //4. specific type, search text, time


        if(mealType.equals("all") && nameToSearch == ""){
            searchesRecipies = recRepo.findByCookTimeLessThanEqualAndUserAccountId(cookTime, id);
        }else if(mealType.equals("all") && nameToSearch != ""){
            searchesRecipies = recRepo.findByRecipeNameContainingAndCookTimeLessThanEqualAndUserAccountId(nameToSearch, cookTime, id);
        }else if(!(mealType.equals("all")) && nameToSearch == ""){
            searchesRecipies = recRepo.findByMealTypeAndCookTimeLessThanEqualAndUserAccountId(mealType, cookTime, id);
        }else if(!(mealType.equals("all")) && nameToSearch != ""){
            searchesRecipies = recRepo.findByRecipeNameContainingAndMealTypeAndCookTimeLessThanEqualAndUserAccountId(nameToSearch, mealType, cookTime, id);
        }
        
        return searchesRecipies;
    }
}
