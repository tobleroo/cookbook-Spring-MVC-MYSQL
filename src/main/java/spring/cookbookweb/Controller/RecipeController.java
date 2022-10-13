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

        //save ingredients to a set list
        // Set<Ingredient> demoIngredients = new HashSet<>();
        // demoIngredients.add(new Ingredient("potato"));
        // demoIngredients.add(new Ingredient("cucumber"));
        // demoIngredients.add(new Ingredient("carrot"));
        // demoIngredients.add(new Ingredient("spaghetti"));
        // check if they already exists in DB and save it
        // myRecipeService.addIngredientsToDB(demoIngredients);
        
        model.addAttribute("recipes", recipeRepo.findAll());
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
        recipeRepo.save(recipe);
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

        AddRecipeService myRecipeService = new AddRecipeService(ingrRepo, recipeRepo, amountRepo, weightRepo);

        // demo for prototyping saving ingredients to db
        String [] ingredientNames = {"gurka", "potatis","sallad","hasch"};
        float[] ingredientAmount = {2,4,5,6};
        String [] ingredientWeights = {"tone","kilogram","mg","ounce"};
        myRecipeService.addIngredientsToDB(ingredientNames);
        myRecipeService.addAmountsToDB(ingredientAmount);
        myRecipeService.addWeightsTypeToDB(ingredientWeights);
        
        //currently working to add a recipe
        Recipe newRecipe;
        if(id == 0){
            //if recipe doesnt exist
            newRecipe = new Recipe(recipeName, recipeDesc, cookTime, difficulty, recipeType);
        }else{
            newRecipe = new Recipe(recipeName, recipeDesc, cookTime, difficulty, recipeType);
            newRecipe.setId(id);
        }

        myRecipeService.addRecipeToDBWithIngredients(newRecipe, ingredientNames, ingredientAmount);

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
