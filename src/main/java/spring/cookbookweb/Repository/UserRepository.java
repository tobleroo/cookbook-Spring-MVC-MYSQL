package spring.cookbookweb.Repository;

import org.springframework.stereotype.Repository;

import spring.cookbookweb.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
