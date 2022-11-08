package spring.cookbookweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlannerController {

    public PlannerController() {}
    
    @GetMapping("/weekly-planner")
    public String showWeeklyPlanner(Model model){
        
        return "weekly-planner";
    }

    //create post for generating the planner and return to show


}
