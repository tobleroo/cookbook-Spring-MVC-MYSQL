package spring.cookbookweb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredient_weight")
public class IngredientWeightType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientWeightId; 

    private String weightType;

    @OneToOne(mappedBy = "weight")
    private Ingredient ingredient;

    public IngredientWeightType() {}

    public IngredientWeightType(String weightType) {
        this.weightType = weightType;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public long getIngredientWeightId() {
        return ingredientWeightId;
    }

    public String getWeightType() {
        return weightType;
    }

    public void setWeightType(String weightType) {
        this.weightType = weightType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (ingredientWeightId ^ (ingredientWeightId >>> 32));
        result = prime * result + ((weightType == null) ? 0 : weightType.hashCode());
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
        IngredientWeightType other = (IngredientWeightType) obj;
        if (ingredientWeightId != other.ingredientWeightId)
            return false;
        if (weightType == null) {
            if (other.weightType != null)
                return false;
        } else if (!weightType.equals(other.weightType))
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
        return "IngredientWeightType [ingredientWeightId=" + ingredientWeightId + ", weightType=" + weightType
                + ", ingredient=" + ingredient + "]";
    }
    
}
