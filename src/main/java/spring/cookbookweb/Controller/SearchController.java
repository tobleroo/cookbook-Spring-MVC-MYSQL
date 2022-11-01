package spring.cookbookweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.cookbookweb.Repository.IngredientAmountRepository;
import spring.cookbookweb.Repository.IngredientRepository;
import spring.cookbookweb.Repository.IngredientWeightRepository;
import spring.cookbookweb.Repository.RecipeRepository;
import spring.cookbookweb.Services.AddRecipeService;

@Controller
public class SearchController {

    public SearchController(){}

    @GetMapping("/recipies/filtered")
    public String returnFilteredList(Model model,
        @RequestParam("mealType") String mealType,
        @RequestParam("cookTime") int maxCookTime){
        
        //get the recipes from the searchService and repos

        return "list-recipies";
    }

    
}
