package spring.cookbookweb.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.cookbookweb.ConfigAndUser.SecurityUser;
import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Entity.UserDTO;
import spring.cookbookweb.Repository.RecipeRepository;
import spring.cookbookweb.Services.GeneratorRecipeService;
import spring.cookbookweb.Services.GetUserDTO;
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
    public String giveRandomDish(Model model, @AuthenticationPrincipal SecurityUser user){
        UserDTO userDTO = new GetUserDTO(repository).getUser(user);
        Random randominator = new Random();
        int selectedDishNumber = randominator.nextInt(userDTO.getRecipies().size());
        
        model.addAttribute("recipes", userDTO.getRecipies().get(selectedDishNumber));
        return "generate-dish";
    }

    @GetMapping("/generator/filtered")
    public String giveRandomFilteredDish(Model model,
        @RequestParam("mealType") String mealType,
        @RequestParam("cookTime") String maxCookTime,
        @AuthenticationPrincipal SecurityUser user){

        String nameOfRecipe = "";
        List<Recipe> collectedRecipes = searchService.searchCookBook(mealType, maxCookTime, nameOfRecipe, user.getUserId());
        
        model.addAttribute("recipe", GeneratorRecipeService.generateOneDish(collectedRecipes));
        return "generate-dish";
    }
}
