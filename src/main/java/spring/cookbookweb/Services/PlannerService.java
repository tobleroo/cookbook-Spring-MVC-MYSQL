package spring.cookbookweb.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Entity.Recipe;

@Service
public class PlannerService {

    SearchService mySearch;

    public PlannerService(SearchService search) {
        this.mySearch = search;
    }

    //method to retrieve recipies
    public void getFromDB(String[] mealtypes, int[] maxCookTime){
        List<Recipe> generated = new ArrayList<>();

        for(String meal : mealtypes){
            
        }
    }
    

    
}
