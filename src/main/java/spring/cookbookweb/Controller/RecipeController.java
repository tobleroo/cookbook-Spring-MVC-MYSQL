package spring.cookbookweb.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.cookbookweb.Entity.Ingredient;
import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Repository.IngredientRepository;
import spring.cookbookweb.Repository.RecipeRepository;
import spring.cookbookweb.Services.AddRecipeService;


@Controller
public class RecipeController {
    
    private final RecipeRepository repository;
    private final IngredientRepository ingrRepo;

    RecipeController(RecipeRepository repository, IngredientRepository ingrRepo){
        this.repository = repository;
        this.ingrRepo = ingrRepo;
    }

    @GetMapping("/recipies")
    public String showRecipies(Model model){

        // quick check recipe service methods
        AddRecipeService myService = new AddRecipeService(ingrRepo, repository);
        myService.checkIfIngredientExists();

        
        model.addAttribute("recipes", repository.findAll());
        return "list-recipies";
    }

    @GetMapping("/addrecipepage")
    public String addEmployeeForm(Model model){
        model.addAttribute("recipe", new Recipe());
        return "add-recipe";
    }

    // not used currently. sacerecipeDEMO beneath used instead
    @PostMapping("/saverecipe")
    public String saveRecipe(@ModelAttribute Recipe recipe){
        repository.save(recipe);
        return "redirect:/recipies";
    }

    @PostMapping("/saverecipedemo")
    public String getDataForm(@RequestParam(required = false) String[] ingrNames,  // required false changed to NAME name in input html
        @RequestParam(required = false) int[]ingrAmounts,
        @RequestParam("recipeName") String recipeName,
        @RequestParam("recipeDescription") String recipeDesc,
        @RequestParam("recipeDiff") String difficulty,
        @RequestParam("recipeTime") int cookTime,
        @RequestParam("recipeType") String recipeType,
        @RequestParam("id") long id){

        //list for testing insert of ingredients
        ArrayList<Ingredient> myIngrs = new ArrayList<Ingredient>();
        Ingredient ingr1 = new Ingredient("koldolme");
        myIngrs.add(ingr1);
        Ingredient ingr2 = new Ingredient("sparris");
        myIngrs.add(ingr2);

        Recipe newRecipe;
        if(id == 0){
            newRecipe = new Recipe(recipeName, recipeDesc, cookTime, difficulty, recipeType, myIngrs);

        }else{
            newRecipe = new Recipe(recipeName, recipeDesc, cookTime, difficulty, recipeType, myIngrs);
            newRecipe.setId(id);
        }

        repository.save(newRecipe);

        // later use ingredients arrays to add to separate DB's
        return "redirect:/recipies";
    }

    @GetMapping("/updaterecipe")
    public String updateRecipe(@RequestParam long id, Model model){
        Recipe changeRecipe = repository.findById(id).get();
        // System.out.println(changeRecipe.getAllIngredients());
        model.addAttribute("recipe", changeRecipe);
        return "add-recipe";
    }

    @GetMapping("/deleterecipe")
    public String deleteRecipe(@RequestParam long id){
        repository.deleteById(id);
        return "redirect:/recipies";
    }
}
