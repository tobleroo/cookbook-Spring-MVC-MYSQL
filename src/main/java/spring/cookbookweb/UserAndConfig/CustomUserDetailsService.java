package spring.cookbookweb.UserAndConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser user = userRepo.findByUserName(username);

        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }

        return new CustomUserDetails(user);

    }

    
    
}
