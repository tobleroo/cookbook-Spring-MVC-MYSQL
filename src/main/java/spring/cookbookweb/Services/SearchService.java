package spring.cookbookweb.Services;

import spring.cookbookweb.Repository.IngredientAmountRepository;
import spring.cookbookweb.Repository.IngredientRepository;
import spring.cookbookweb.Repository.IngredientWeightRepository;
import spring.cookbookweb.Repository.RecipeRepository;

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

    public void searchQriterias(String mealType, int maxCookTime){
        if(mealType == "all"){
            //search only by cooktime
        }else{
            //search by both mealtype and cooking time 
        }
    }
}
