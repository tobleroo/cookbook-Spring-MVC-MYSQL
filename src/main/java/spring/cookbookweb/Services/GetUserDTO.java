package spring.cookbookweb.Services;

import spring.cookbookweb.ConfigAndUser.SecurityUser;
import spring.cookbookweb.Entity.UserDTO;
import spring.cookbookweb.Repository.RecipeRepository;

public class GetUserDTO {
    
    RecipeRepository recipeRepo;

    public GetUserDTO(RecipeRepository recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    public UserDTO getUser(SecurityUser user){

        return new UserDTO(user.getUsername(), user.getUserId(), recipeRepo.findByUserAccountId(user.getUserId()));

    }
}
