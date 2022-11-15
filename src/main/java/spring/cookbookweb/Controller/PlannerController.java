package spring.cookbookweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestParam("portions") int[] portions,
    @RequestParam("maxTime") int[] maxCookTime){
        
        for(String meal : mealType){
            System.out.println(meal);
        }
        return "weekly-planner";
    }

    //create post for generating the planner and return to show


}
