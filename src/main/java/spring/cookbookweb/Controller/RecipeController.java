package spring.cookbookweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Repository.IngredientAmountRepository;
import spring.cookbookweb.Repository.IngredientRepository;
import spring.cookbookweb.Repository.IngredientWeightRepository;
import spring.cookbookweb.Repository.RecipeRepository;
import spring.cookbookweb.Services.AddRecipeService;


@Controller
public class RecipeController {
    
    private final RecipeRepository recipeRepo;
    private final IngredientRepository ingrRepo;
    private final IngredientAmountRepository amountRepo;
    private final IngredientWeightRepository weightRepo;
    

    RecipeController(RecipeRepository repository, IngredientRepository ingrRepo,
    IngredientAmountRepository amountRepo, IngredientWeightRepository weightRepo){
        this.recipeRepo = repository;
        this.ingrRepo = ingrRepo;
        this.amountRepo = amountRepo;
        this.weightRepo = weightRepo;
    }

    @GetMapping("/recipies")
    public String showRecipies(Model model){

        // Recipe demo = recipeRepo.findByRecipeName("first recipe");
        // System.out.println(demo.getIngredients().get(0).getWeightObj().getWeightType());
        
        model.addAttribute("recipes", recipeRepo.findAll());
        return "list-recipies";
    }

    @GetMapping("/addrecipepage")
    public String addEmployeeForm(Model model){
        model.addAttribute("recipe", new Recipe());
        return "add-recipe";
    }

    @PostMapping("/saverecipedemo")
    public String getDataForm(@RequestParam("ingrName") String[] ingrNames,  // required false changed to NAME name in input html
        @RequestParam("ingrAmount") float[]ingrAmounts,
        @RequestParam("ingrWeight") String[] ingrWeights,
        @RequestParam("recipeName") String recipeName,
        @RequestParam("recipeDescription") String recipeDesc,
        @RequestParam("recipeDiff") String difficulty,
        @RequestParam("recipeTime") int cookTime,
        @RequestParam("recipeType") String recipeType,
        @RequestParam("id") long id){

        AddRecipeService myRecipeService = new AddRecipeService(ingrRepo, recipeRepo, amountRepo, weightRepo);


        System.out.print(ingrNames[0] + ingrAmounts[0] + ingrWeights[0]);

        myRecipeService.addIngredientsToDB(ingrNames);
        myRecipeService.addAmountsToDB(ingrAmounts);
        myRecipeService.addWeightsTypeToDB(ingrWeights);
        
        //currently working to add a recipe
        Recipe newRecipe;
        if(id == 0){
            //if recipe doesnt exist
            newRecipe = new Recipe(recipeName, recipeDesc, cookTime, difficulty, recipeType);
        }else{
            newRecipe = new Recipe(recipeName, recipeDesc, cookTime, difficulty, recipeType);
            newRecipe.setId(id);
        }

        myRecipeService.addRecipeToDBWithIngredients(newRecipe, ingrNames, ingrAmounts, ingrWeights);

        return "redirect:/recipies";
    }

    @GetMapping("/updaterecipe")
    public String updateRecipe(@RequestParam long id, Model model){
        Recipe changeRecipe = recipeRepo.findById(id).get();
        // System.out.println(changeRecipe.getAllIngredients());
        model.addAttribute("recipe", changeRecipe);
        return "add-recipe";
    }

    @GetMapping("/deleterecipe")
    public String deleteRecipe(@RequestParam long id){
        recipeRepo.deleteById(id);
        return "redirect:/recipies";
    }
}
