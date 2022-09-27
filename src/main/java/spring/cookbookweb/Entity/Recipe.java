package spring.cookbookweb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String recipeName;
    private String description;
    private int cookTime;
    private String difficulty;


    public Recipe (){}

    public Recipe (String name,String desc, int time, String diff){
        this.recipeName = name;
        this.description = desc;
        this.cookTime = time;
        this.difficulty = diff;
    }
    
    public int getCookTime() {
        return cookTime;
    }



    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }



    public String getDifficulty() {
        return difficulty;
    }



    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cookTime;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((recipeName == null) ? 0 : recipeName.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Recipe other = (Recipe) obj;
        if (cookTime != other.cookTime)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (difficulty == null) {
            if (other.difficulty != null)
                return false;
        } else if (!difficulty.equals(other.difficulty))
            return false;
        if (id != other.id)
            return false;
        if (recipeName == null) {
            if (other.recipeName != null)
                return false;
        } else if (!recipeName.equals(other.recipeName))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Recipe [cookTime=" + cookTime + ", description=" + description + ", difficulty=" + difficulty + ", id="
                + id + ", recipeName=" + recipeName + "]";
    }

    


    



    
}
