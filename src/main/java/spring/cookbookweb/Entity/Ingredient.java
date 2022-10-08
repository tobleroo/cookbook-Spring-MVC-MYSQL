package spring.cookbookweb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ingredients")
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientId;

    // @Column(unique = true)
    private String ingredientName;

    
    // ManyToMany connection to Recipe class can be found 
    // in Recipe class. using unidir manyToMany with ingredient class(this)

    
    public Ingredient(){}
    
    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (ingredientId ^ (ingredientId >>> 32));
        result = prime * result + ((ingredientName == null) ? 0 : ingredientName.hashCode());
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
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient [ingredientId=" + ingredientId + ", ingredientName=" + ingredientName + "]";
    }
    
}
