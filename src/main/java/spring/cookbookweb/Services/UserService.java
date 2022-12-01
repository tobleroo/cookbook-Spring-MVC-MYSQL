package spring.cookbookweb.Services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public boolean checkIfEmailAlreadyInUse(User user){

        return userRepo.existsByEmail(user.getEmail());
    }

    public User encryptUserPassword(User user){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String cryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(cryptedPassword);

        return user;
    }

}
