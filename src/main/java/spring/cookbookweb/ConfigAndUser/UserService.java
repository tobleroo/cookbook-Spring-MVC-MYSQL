package spring.cookbookweb.ConfigAndUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Repository.RecipeRepository;

@Service
public class UserService {

    UserRepository userRepo;
    RecipeRepository recipeRepo;

    

    public UserService(UserRepository userRepo, RecipeRepository recipeRepo) {
        this.userRepo = userRepo;
        this.recipeRepo = recipeRepo;
    }



    //save the recipe to the user account
    public void addRecipeToAccountAndSave(SecurityUser secUser, Recipe recipe){

        //get the user from securityUser
        User userObj = secUser.getUser();

        //find all current recipies to this acc

        // add the new one to the list
        List<Recipe> accRecipes = new ArrayList<>();
        accRecipes.add(recipeRepo.findByRecipeId(recipe.getId()));

        //add list to user
        userObj.setAccountRecipies(accRecipes);

        System.out.println(userObj.getAccountRecipies().size());

        // resave the user with updated recipe list
        userRepo.save(userObj);
    }
    
}
