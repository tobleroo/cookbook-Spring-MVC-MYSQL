package spring.cookbookweb.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long recipeId;
    
    private String recipeName;
    private String description;
    private String difficulty;
    private String mealType;
    private int portions;
    private int cookTime;

    private Long userAccountId;

    // ManyToMany connection to ingredients DB table
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_has_ingredient", joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "recipeId"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredientId"))
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_has_amounts", joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "recipeId"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_amount_id", referencedColumnName = "ingredientAmountId"))
    private List<IngredientAmount> amount = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_has_weights", joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "recipeId"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_weight_id", referencedColumnName = "ingredientWeightId"))
    private List<IngredientWeightType> weight = new ArrayList<>();
    
    public Recipe (){}
    
    
    public Recipe(String recipeName, String description, int cookTime, String difficulty, String mealType,
            int portions) {
        this.recipeName = recipeName;
        this.description = description;
        this.cookTime = cookTime;
        this.difficulty = difficulty;
        this.mealType = mealType;
        this.portions = portions;
    }

    


    public int getPortions() {
        return portions;
    }


    public void setPortions(int portions) {
        this.portions = portions;
    }


    public List<IngredientAmount> getAmount() {
        return amount;
    }

    public void setAmount(List<IngredientAmount> amount) {
        this.amount = amount;
    }

    public List<IngredientWeightType> getWeight() {
        return weight;
    }

    public void setWeight(List<IngredientWeightType> weight) {
        this.weight = weight;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setOneIngredient(Ingredient oneIngredient){
        this.ingredients.add(oneIngredient);
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
        return recipeId;
    }
    public void setId(long id) {
        this.recipeId = id;
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
    
    public String getMealType() {
        return mealType;
    }
    
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public long getRecipeId() {
        return recipeId;
    }


    public Long getUserAccountId() {
        return userAccountId;
    }


    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (recipeId ^ (recipeId >>> 32));
        result = prime * result + ((recipeName == null) ? 0 : recipeName.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + cookTime;
        result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
        result = prime * result + ((mealType == null) ? 0 : mealType.hashCode());
        result = prime * result + portions;
        result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
        if (recipeId != other.recipeId)
            return false;
        if (recipeName == null) {
            if (other.recipeName != null)
                return false;
        } else if (!recipeName.equals(other.recipeName))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (cookTime != other.cookTime)
            return false;
        if (difficulty == null) {
            if (other.difficulty != null)
                return false;
        } else if (!difficulty.equals(other.difficulty))
            return false;
        if (mealType == null) {
            if (other.mealType != null)
                return false;
        } else if (!mealType.equals(other.mealType))
            return false;
        if (portions != other.portions)
            return false;
        if (ingredients == null) {
            if (other.ingredients != null)
                return false;
        } else if (!ingredients.equals(other.ingredients))
            return false;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        if (weight == null) {
            if (other.weight != null)
                return false;
        } else if (!weight.equals(other.weight))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", description=" + description
                + ", cookTime=" + cookTime + ", difficulty=" + difficulty + ", mealType=" + mealType + ", portions="
                + portions + ", ingredients=" + ingredients + ", amount=" + amount + ", weight=" + weight + "]";
    }


    

    

    

}
