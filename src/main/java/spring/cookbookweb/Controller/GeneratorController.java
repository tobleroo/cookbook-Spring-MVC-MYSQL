package spring.cookbookweb.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Repository.RecipeRepository;
import spring.cookbookweb.Services.SearchService;

@Controller
public class GeneratorController {

    private final RecipeRepository repository;
    SearchService searchService;

    GeneratorController(RecipeRepository repo, SearchService searchService){
        this.repository = repo;
        this.searchService = searchService;
    }

    @GetMapping("/generate-dish")
    public String generatorPage(){
        return "generate-dish";
    }

    @GetMapping("/getrandomdish")
    public String giveRandomDish(Model model){
        Random randominator = new Random();
        int selectedDishNumber = randominator.nextInt(repository.findAll().size());
        
        model.addAttribute("recipes", repository.findAll().get(selectedDishNumber));
        return "generate-dish";
    }

    @GetMapping("/generator/filtered")
    public String giveRandomFilteredDish(Model model,
        @RequestParam("mealType") String mealType,
        @RequestParam("cookTime") String maxCookTime,
        @RequestParam("recipeName") String nameOfRecipe){

        List<Recipe> collectedRecipes = searchService.searchCookBook(mealType, maxCookTime, nameOfRecipe);
        int randomSelector = new Random().nextInt(collectedRecipes.size());
        Recipe chosenOne = collectedRecipes.get(randomSelector);
        model.addAttribute("recipe", chosenOne);
        return "generate-dish";
    }
}
