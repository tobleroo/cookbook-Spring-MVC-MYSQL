package spring.cookbookweb.serviceTests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import spring.cookbookweb.Entity.Ingredient;
import spring.cookbookweb.Entity.IngredientAmount;
import spring.cookbookweb.Entity.IngredientWeightType;
import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Services.PlannerService;

public class PlannerServiceTests {
    
    @Test
    void testCalculateIngredientMeasures() {
        
        //create 2 recipes
        Recipe recipe1 = new Recipe("recipe1", "pdioawjdi", 20, "easy", "dinner", 2);

        Ingredient ingr1 = new Ingredient("gurka");
        Ingredient ingr2 = new Ingredient("tomater");
        List<Ingredient> ingrList1 = new ArrayList<>();
        ingrList1.add(ingr1);
        ingrList1.add(ingr2);
        recipe1.setIngredients(ingrList1);

        IngredientAmount am1 = new IngredientAmount(2);
        IngredientAmount am2 = new IngredientAmount(4);
        List<IngredientAmount> amList1 = new ArrayList<>();
        amList1.add(am1);
        amList1.add(am2);
        recipe1.setAmount(amList1);

        IngredientWeightType we1 = new IngredientWeightType("kilo");
        IngredientWeightType we2 = new IngredientWeightType("tone");
        List<IngredientWeightType> weList = new ArrayList<>();
        weList.add(we1);
        weList.add(we2);

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe1);

        String [] portions = {"5"};

        //test method

        // List<Recipe> calculated = PlannerService.calculateIngredientMeasures(recipeList, portions);

        // System.out.println("first ingr standard amount: " + recipe1.getAmount().get(0).getAmount());

        // System.out.println("recalculated amount: " + calculated.get(0).getAmount().get(0).getAmount());
        
    }
}
