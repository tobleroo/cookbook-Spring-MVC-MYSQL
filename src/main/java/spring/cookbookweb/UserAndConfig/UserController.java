package spring.cookbookweb.UserAndConfig;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    

    private UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("user", new MyUser());
        return "registerPage";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new MyUser());
        return "user-login";
    }

    @PostMapping("/process-register")
    public String processRegister(MyUser user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String cryptedPass = passwordEncoder.encode(user.getPassword());

        user.setPassword(cryptedPass);
        user.setRole("USER");
        userRepo.save(user);
        System.out.println("worked all the way here!");
        return"user-login";
    }

}
