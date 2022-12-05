package spring.cookbookweb.ConfigAndUser;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;


@Controller
public class AccountController {

    private UserRepository userRepo;

    public AccountController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "registerPage";
    }

    @PostMapping("/save-new-user")
    public String saveNewAccount(User user){
        user.setRole("USER");
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "weekly-planner";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "user-login";
    }
}
