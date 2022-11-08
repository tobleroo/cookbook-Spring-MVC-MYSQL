package spring.cookbookweb.Services;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Entity.Recipe;

@Service
public class GeneratorRecipeService {

    public GeneratorRecipeService() {}
    
    
    public static Recipe generateOneDish(List<Recipe> collectedRecipes){

        int randomSelector = new Random().nextInt(collectedRecipes.size());
        Recipe chosenOne = collectedRecipes.get(randomSelector);
        return chosenOne;
    }
}
