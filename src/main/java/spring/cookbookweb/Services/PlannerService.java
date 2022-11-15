package spring.cookbookweb.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Entity.Recipe;

@Service
public class PlannerService {

    static SearchService mySearch;

    public PlannerService(SearchService search) {
        PlannerService.mySearch = search;
    }

    //method to retrieve recipies from DB
    public static List<Recipe> getFromDB(String[] mealtypes, String[] maxCookTime){
        List<Recipe> generated = new ArrayList<>();

        for(int i = 0; i < mealtypes.length; i++){
            List<Recipe> temporary = mySearch.searchCookBook(mealtypes[i], maxCookTime[i], "");
            generated.add(GeneratorRecipeService.generateOneDish(temporary));
        }
        
        return generated;
    }

    // changing amount in each ingredients to users desired portion amount
    public static List<Recipe> calculateIngredientMeasures(List<Recipe> generatedRecipes, String[] portions){

        for(int a = 0; a < generatedRecipes.size(); a++){

            // loop through each recipes all ingredients and change portion values
            for(int i = 0; i < generatedRecipes.get(a).getIngredients().size(); i++){
                generatedRecipes.get(a).getAmount().get(i).setAmount(
                (generatedRecipes.get(a).getAmount().get(i).getAmount() / generatedRecipes.get(a).getPortions()) 
                * Integer.parseInt(portions[a]) );
            }

            generatedRecipes.get(a).setPortions(Integer.parseInt(portions[a]));
        }

        return generatedRecipes;
    }
    

    
}
