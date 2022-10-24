package spring.cookbookweb.Services;

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
