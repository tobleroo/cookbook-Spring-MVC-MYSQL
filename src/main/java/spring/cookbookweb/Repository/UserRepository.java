package spring.cookbookweb.Repository;

import org.springframework.stereotype.Repository;

import spring.cookbookweb.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}
