package spring.cookbookweb.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.cookbookweb.ConfigAndUser.SecurityUser;
import spring.cookbookweb.Entity.Recipe;
import spring.cookbookweb.Services.PlannerService;

@Controller
public class PlannerController {

    public PlannerController() {}

    @GetMapping("/meal-planner")
    public String goToPlanner(Model model){
        return "weekly-planner";
    }
    
    @GetMapping("/generated-planner")
    public String showWeeklyPlanner(Model model, 
    @RequestParam("mealType") String[] mealType,
    @RequestParam("portions") String[] portions,
    @RequestParam("maxTime") String[] maxCookTime,
    @AuthenticationPrincipal SecurityUser user){
        // if no values or single attribute is sent it comes as null
        
        List<Recipe> generatedList = new ArrayList<>();

        //make sures cooktime array is not sent as null(size 0)
        if(maxCookTime.length == 0){
            String [] replacer = {""};
            generatedList = PlannerService.calculateIngredientMeasures(PlannerService.getFromDB(mealType, replacer, user.getUserId()), portions);
            
        }else{
            generatedList = PlannerService.calculateIngredientMeasures(PlannerService.getFromDB(mealType, maxCookTime, user.getUserId()), portions);
            
        }
        
        
        model.addAttribute("recipes", generatedList);
        return "weekly-planner";
    }

    //create post for generating the planner and return to show


}