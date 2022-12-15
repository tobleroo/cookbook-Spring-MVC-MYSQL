package spring.cookbookweb.ConfigAndUser;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Repository.RecipeRepository;

@Service
public class UserService {

    UserRepository userRepo;
    RecipeRepository recipeRepo;

    
    public UserService(UserRepository userRepo, RecipeRepository recipeRepo) {
        this.userRepo = userRepo;
        this.recipeRepo = recipeRepo;
    }
    
}
