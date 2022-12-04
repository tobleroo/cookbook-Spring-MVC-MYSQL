package spring.cookbookweb.UserAndConfig;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Long>{
    
    MyUser findByUserName(String name);
}
