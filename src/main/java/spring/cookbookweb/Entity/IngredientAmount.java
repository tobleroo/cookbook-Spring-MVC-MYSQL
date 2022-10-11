package spring.cookbookweb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient_amount")
public class IngredientAmount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientAmountId;
    
    private int amount;
}
