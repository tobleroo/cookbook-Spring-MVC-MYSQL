package spring.cookbookweb.ConfigAndUser;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    public Boolean saveUser(User user){

        Boolean alreadyExists;
        if(userRepo.findByUsername(user.getUsername()).isPresent()){
           alreadyExists = true;
        }else{
            user.setRole("USER");
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userRepo.save(user);
            alreadyExists = false;
        }

        return alreadyExists;
    }
    
}
