package spring.cookbookweb.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ingredients")
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientId;

    private String ingredientName;

    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recipe = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_amount_id")
    private IngredientAmount amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_weight_id")
    private IngredientWeightType weight;
    
    public Ingredient(){}
    
    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public IngredientAmount getAmountObj() {
        return amount;
    }

    public void setAmountObj(IngredientAmount amount) {
        this.amount = amount;
    }

    public List<Recipe> getRecipeObj() {
        return recipe;
    }

    public void setRecipe(List<Recipe> recipe) {
        this.recipe = recipe;
    }

    public long getId() {
        return ingredientId;
    }
    
    public void setId(long id) {
        this.ingredientId = id;
    }
    
    public String getIngredientName() {
        return ingredientName;
    }
    
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public IngredientWeightType getWeightObj() {
        return weight;
    }

    public void setWeightObj(IngredientWeightType weight) {
        this.weight = weight;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (ingredientId ^ (ingredientId >>> 32));
        result = prime * result + ((ingredientName == null) ? 0 : ingredientName.hashCode());
        result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
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
        Ingredient other = (Ingredient) obj;
        if (ingredientId != other.ingredientId)
            return false;
        if (ingredientName == null) {
            if (other.ingredientName != null)
                return false;
        } else if (!ingredientName.equals(other.ingredientName))
            return false;
        if (recipe == null) {
            if (other.recipe != null)
                return false;
        } else if (!recipe.equals(other.recipe))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient [ingredientId=" + ingredientId + ", ingredientName=" + ingredientName + ", recipe=" + recipe
                + ", amount=" + amount + ", weight=" + weight + "]";
    }

    

    
}
