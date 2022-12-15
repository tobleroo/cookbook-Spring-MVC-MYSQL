package spring.cookbookweb.Entity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    
    private String username;
    private Long id;

    private List<Recipe> recipies = new ArrayList<>();

    public UserDTO(String username, Long id, List<Recipe> recipies) {
        this.username = username;
        this.id = id;
        this.recipies = recipies;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public List<Recipe> getRecipies() {
        return recipies;
    }

    
}
