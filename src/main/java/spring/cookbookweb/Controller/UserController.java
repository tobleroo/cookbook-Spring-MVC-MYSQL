package spring.cookbookweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping("/new-account-page")
    public String createAccountPage(){
        return "sign-up";
    }

    @PostMapping("/saveNewUser")
    public String saveNewUSer(@RequestBody User user) {
        
        userService.saveNewAccount(user);
        
        return "user-login";
    }
    
}
