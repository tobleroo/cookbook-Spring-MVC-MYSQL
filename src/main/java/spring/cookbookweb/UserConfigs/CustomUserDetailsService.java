// package spring.cookbookweb.UserConfigs;

// public class CustomUserDetailsService implements UserDetailsService{

//     private UserRepository userRepo;

//     public CustomUserDetailsService(UserRepository userRepo){
//         this.userRepo = userRepo;
//     }
    
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         User user = userRepo.findByEmail(username);
//         if (user == null) {
//             throw new UsernameNotFoundException("User not found");
//         }
//         return new CustomUserDetails(user);
//     }
// }
