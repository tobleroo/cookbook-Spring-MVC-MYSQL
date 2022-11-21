package spring.cookbookweb.Services;

import org.springframework.stereotype.Service;

import spring.cookbookweb.Entity.User;
import spring.cookbookweb.Repository.UserRepository;

@Service
public class UserService {

    UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void saveNewAccount(User newUser){
        userRepo.save(newUser);
    }

}
