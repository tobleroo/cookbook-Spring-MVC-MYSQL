package spring.cookbookweb.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient_amount")
public class IngredientAmount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientAmountId;
    
    private float amount;

    @ManyToMany(mappedBy = "amount")
    private List<Recipe> recipe = new ArrayList<>();

    public IngredientAmount() {}

    public IngredientAmount(float amount) {
        this.amount = amount;
    }

    public long getIngredientAmountId() {
        return ingredientAmountId;
    }

    public void setIngredientAmountId(long ingredientAmountId) {
        this.ingredientAmountId = ingredientAmountId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public List<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Recipe> recipe) {
        this.recipe = recipe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (ingredientAmountId ^ (ingredientAmountId >>> 32));
        result = prime * result + Float.floatToIntBits(amount);
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
        IngredientAmount other = (IngredientAmount) obj;
        if (ingredientAmountId != other.ingredientAmountId)
            return false;
        if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
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
        return "IngredientAmount [ingredientAmountId=" + ingredientAmountId + ", amount=" + amount + ", recipe="
                + recipe + "]";
    }

    

    

}
