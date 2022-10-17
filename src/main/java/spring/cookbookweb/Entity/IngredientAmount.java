package spring.cookbookweb.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient_amount")
public class IngredientAmount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientAmountId;
    
    private float amount;

    @OneToMany(mappedBy = "amount")
    private List<Ingredient> ingredient = new ArrayList<>();

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

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (ingredientAmountId ^ (ingredientAmountId >>> 32));
        result = prime * result + Float.floatToIntBits(amount);
        result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
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
        if (ingredient == null) {
            if (other.ingredient != null)
                return false;
        } else if (!ingredient.equals(other.ingredient))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IngredientAmount [ingredientAmountId=" + ingredientAmountId + ", amount=" + amount + ", ingredient="
                + ingredient + "]";
    }

    

}
