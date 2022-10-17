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
@Table(name = "Ingredient_weight")
public class IngredientWeightType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientWeightId; 

    private String weightType;

    @OneToMany(mappedBy = "amount")
    private List<Ingredient> ingredient = new ArrayList<>();

    public IngredientWeightType() {}

    public IngredientWeightType(String weightType) {
        this.weightType = weightType;
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
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
