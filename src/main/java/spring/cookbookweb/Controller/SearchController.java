package spring.cookbookweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        @RequestParam("recipeName") String nameOfRecipe){
        //get the recipes from the searchService and repos
        model.addAttribute("recipes", searchService.searchCookBook(mealType, maxCookTime, nameOfRecipe));
        return "list-recipies";
    }

    
}
