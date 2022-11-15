package spring.cookbookweb.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestParam("maxTime") String[] maxCookTime){
        
        List<Recipe> weeklyPlan = PlannerService.calculateIngredientMeasures(PlannerService.getFromDB(mealType, maxCookTime), portions);
        
        
        model.addAttribute("recipes", weeklyPlan);
        return "weekly-planner";
    }

    //create post for generating the planner and return to show


}
