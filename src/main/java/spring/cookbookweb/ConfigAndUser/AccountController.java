package spring.cookbookweb.ConfigAndUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AccountController {

    private UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "registerPage";
    }

    @PostMapping("/save-new-user")
    public String saveNewAccount(User user, Model model){

        if(userService.saveUser(user)){
            model.addAttribute("alreadyExists", "username already exists!");
            return "registerPage";
        }else{
            model.addAttribute("successRegister", "Account seccessfully created!");
            return "user-login";
        }
        
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "user-login";
    }
}
