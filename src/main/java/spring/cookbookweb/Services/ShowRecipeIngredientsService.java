package spring.cookbookweb.Services;

import java.util.ArrayList;
import java.util.List;

import spring.cookbookweb.Entity.Recipe;

public class ShowRecipeIngredientsService {

    // only used to append ingredients in foreach to update recipe!!

    private String ingredientName;
    private float amount;
    private String WeightType;
    
    public ShowRecipeIngredientsService(String ingredientName, float amount, String weightType) {
        this.ingredientName = ingredientName;
        this.amount = amount;
        WeightType = weightType;
    }

    // send in a recipe obj to extract ignredients to a separate list of this class type. 
    // for sending to frontend
    public static List<ShowRecipeIngredientsService> extrectIngredients(Recipe recipe){
        List<ShowRecipeIngredientsService> ingredients = new ArrayList<>();
        for(int i = 0; i < recipe.getIngredients().size(); i++){
            ingredients.add(new ShowRecipeIngredientsService(
            recipe.getIngredients().get(i).getIngredientName()
            ,recipe.getAmount().get(i).getAmount()
            ,recipe.getWeight().get(i).getWeightType()));
        }
        return ingredients;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public float getAmount() {
        return amount;
    }

    public String getWeightType() {
        return WeightType;
    }
    
    
}
