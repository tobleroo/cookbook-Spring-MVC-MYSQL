package spring.cookbookweb.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Entity.IngredientAmount;
import spring.cookbookweb.Entity.Recipe;

@Service
public class PlannerService {

    static SearchService mySearch;

    public PlannerService(SearchService search) {
        PlannerService.mySearch = search;
    }

    //method to retrieve recipies from DB
    public static List<Recipe> getFromDB(String[] mealtypes, String[] maxCookTime, Long id){
        List<Recipe> generated = new ArrayList<>();
        
        for(int i = 0; i < mealtypes.length; i++){
            if(mySearch.checkIfMealtypeExists(mealtypes[i])){
                List<Recipe> temporary = mySearch.searchCookBook(mealtypes[i], maxCookTime[i], "", id);
                generated.add(GeneratorRecipeService.generateOneDish(temporary));
            }
        }
        
        return generated;
    }

    // changing amount in each ingredients to users desired portion amount
    public static List<Recipe> calculateIngredientMeasures(List<Recipe> generatedRecipes, String[] portions){

        
        for(int i = 0; i < generatedRecipes.size(); i++){

            List<IngredientAmount> redoneList = new ArrayList<>();

            for(IngredientAmount amount : generatedRecipes.get(i).getAmount()){
                IngredientAmount redoneAmount = new IngredientAmount();
                redoneAmount.setAmount( amount.getAmount() / generatedRecipes.get(i).getPortions() * Integer.parseInt(portions[i]) );
                redoneList.add(redoneAmount);
            }

            generatedRecipes.get(i).setAmount(redoneList);
            generatedRecipes.get(i).setPortions(Integer.parseInt(portions[i]));

        }

        return generatedRecipes;
    }
    
    
    
}
