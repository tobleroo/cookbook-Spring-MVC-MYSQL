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


    

}
