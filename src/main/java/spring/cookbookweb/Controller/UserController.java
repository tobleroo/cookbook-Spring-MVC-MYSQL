package spring.cookbookweb.Controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import spring.cookbookweb.Entity.User;
import spring.cookbookweb.Services.UserService;


@Controller
public class UserController {

    // login stuff

    UserService userService;

    
    
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/login-page")
    public String loginPage(){
        return "user-login";
    }



    // creatation stuff

    @GetMapping("/new-account")
    public String createAccountPage(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/new-account")
    public String saveNewUSer(@ModelAttribute User user, Model model) {
        
        if(!(userService.checkIfEmailAlreadyInUse(user))){

            userService.saveNewAccount(userService.encryptUserPassword(user));
            model.addAttribute("sugnUpSuccess", true);
        }else{
            model.addAttribute("signUpError", true);
        }
        
        return "sign-up";
    }
    
}
