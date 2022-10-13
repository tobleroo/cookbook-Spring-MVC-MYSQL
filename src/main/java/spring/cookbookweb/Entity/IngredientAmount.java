package spring.cookbookweb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient_amount")
public class IngredientAmount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientAmountId;
    
    private float amount;

    @OneToOne(mappedBy = "amount")
    private Ingredient ingredient;

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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}
