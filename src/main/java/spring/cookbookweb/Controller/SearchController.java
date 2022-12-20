package spring.cookbookweb.Controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.cookbookweb.ConfigAndUser.SecurityUser;
import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Entity.UserDTO;
import spring.cookbookweb.Services.SearchService;

@Controller
public class SearchController {

    SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping("/recipies/filtered")
    public String returnFilteredList(Model model,
        @RequestParam("mealType") String mealType,
        @RequestParam("cookTime") String maxCookTime,
        @RequestParam("recipeName") String nameOfRecipe,
        @AuthenticationPrincipal SecurityUser user){
        //get the recipes from the searchService and repos
        List<Recipe> chosenRecipies = searchService.searchCookBook(mealType, maxCookTime, nameOfRecipe, user.getUserId());
        UserDTO newUser = new UserDTO(user.getUsername(), user.getUserId(), chosenRecipies);
        model.addAttribute("userDTO", newUser);
        return "list-recipies";
    }
}
