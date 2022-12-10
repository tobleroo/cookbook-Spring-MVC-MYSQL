package spring.cookbookweb.ConfigAndUser;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import spring.cookbookweb.Entity.Recipe;

@Entity
@Table(name = "users")
public class User {
    

    @Id
    @GeneratedValue
    private Long userId;
    private String username;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Recipe> accountRecipies = new ArrayList<>();

    public User() {
    }
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public Long getId() {
        return userId;
    }
    public void setId(Long id) {
        this.userId = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public List<Recipe> getAccountRecipies() {
        return accountRecipies;
    }
    public void setAccountRecipies(List<Recipe> accountRecipies) {
        this.accountRecipies = accountRecipies;
    }
    @Override
    public String toString() {
        return "User [id=" + userId + ", username=" + username + ", password=" + password + ", role=" + role + "]";
    }

    
}
