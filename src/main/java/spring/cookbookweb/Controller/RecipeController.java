 package spring.cookbookweb.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Repository.IngredientAmountRepository;
import spring.cookbookweb.Repository.IngredientRepository;
import spring.cookbookweb.Repository.IngredientWeightRepository;
import spring.cookbookweb.Repository.RecipeRepository;
import spring.cookbookweb.Services.AddRecipeService;
import spring.cookbookweb.Services.ShowRecipeIngredientsService;


@Controller
public class RecipeController {
    
    private final RecipeRepository recipeRepo;
    private final IngredientRepository ingrRepo;
    private final IngredientAmountRepository amountRepo;
    private final IngredientWeightRepository weightRepo;
    private final AddRecipeService myRecipeService;
    

    RecipeController(RecipeRepository repository, IngredientRepository ingrRepo,
    IngredientAmountRepository amountRepo, IngredientWeightRepository weightRepo){
        this.recipeRepo = repository;
        this.ingrRepo = ingrRepo;
        this.amountRepo = amountRepo;
        this.weightRepo = weightRepo;
        this.myRecipeService = new AddRecipeService(this.ingrRepo, this.recipeRepo, this.amountRepo, this.weightRepo);
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/recipies")
    public String showRecipies(Model model){
        
        model.addAttribute("recipes", recipeRepo.findAll());
        return "list-recipies";
    }

    @GetMapping("/addrecipepage")
    public String addRecipeForm(Model model){
        model.addAttribute("recipe", new Recipe());
        return "add-recipe";
    }

    @PostMapping("/saverecipedemo")
    public String getDataForm(@RequestParam("ingrName") String[] ingrNames,
        @RequestParam("ingrAmount") float[]ingrAmounts,
        @RequestParam("ingrWeight") String[] ingrWeights,
        @RequestParam("recipeName") String recipeName,
        @RequestParam("recipeDescription") String recipeDesc,
        @RequestParam("recipeDiff") String difficulty,
        @RequestParam("recipeTime") int cookTime,
        @RequestParam("recipeType") String recipeType,
        @RequestParam("id") long id,
        @RequestParam("recipePortions") int portions){

        myRecipeService.addIngredientsToDB(ingrNames);
        myRecipeService.addAmountsToDB(ingrAmounts);
        myRecipeService.addWeightsTypeToDB(ingrWeights);
        
        // currently working to add a recipe
        Recipe newRecipe;
        if(id == 0){
            //if recipe doesnt exist
            newRecipe = new Recipe(recipeName, recipeDesc, cookTime, difficulty, recipeType,portions);
        }else{
            newRecipe = new Recipe(recipeName, recipeDesc, cookTime, difficulty, recipeType,portions);
            newRecipe.setId(id);
        }

        myRecipeService.addRecipeToDBWithIngredients(newRecipe, ingrNames, ingrAmounts, ingrWeights);

        return "redirect:/recipies";
    }

    @GetMapping("/updaterecipe")
    public String updateRecipe(@RequestParam long id, Model model){
        Recipe changeRecipe = recipeRepo.findById(id).get();
        
        List<ShowRecipeIngredientsService> ingredients = ShowRecipeIngredientsService
            .extractIngredients(changeRecipe);

        model.addAttribute("ingredientList", ingredients);
        model.addAttribute("recipe", changeRecipe);
        return "add-recipe";
    }

    @GetMapping("/deleterecipe")
    public String deleteRecipe(@RequestParam long id){
        // myRecipeService.deleteOneRecipe(id);

        //find the right recipe
        Recipe recipeToDelete = recipeRepo.findByRecipeId(id);
        recipeToDelete.getIngredients().removeAll(recipeToDelete.getIngredients());
        recipeToDelete.getWeight().removeAll(recipeToDelete.getWeight());
        recipeToDelete.getAmount().removeAll(recipeToDelete.getAmount());
        recipeRepo.delete(recipeToDelete);
        return "redirect:/recipies";
    }
}
