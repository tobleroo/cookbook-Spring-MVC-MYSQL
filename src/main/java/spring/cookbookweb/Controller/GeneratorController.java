package spring.cookbookweb.Controller;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Repository.RecipeRepository;

@Controller
public class GeneratorController {

    private final RecipeRepository repository;

    GeneratorController(RecipeRepository repo){
        this.repository = repo;
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
}
