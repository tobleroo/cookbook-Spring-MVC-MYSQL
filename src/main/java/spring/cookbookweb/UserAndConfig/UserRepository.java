package spring.cookbookweb.UserAndConfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<MyUser, Long>{
    
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public MyUser findByUserName(String name);
}
