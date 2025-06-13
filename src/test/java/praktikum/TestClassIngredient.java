package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestClassIngredient {
    private IngredientType type;
    private String name;
    private float price;
    private Ingredient ingredient;
    public TestClassIngredient (IngredientType type, String name, float price ){
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient(){
        return new Object[][]{
                { IngredientType.SAUCE, "hot sauce", 100 },
                { IngredientType.FILLING, "cutlet", 100},
        };
    }
    @Test
    public void checkClassIngredientGetType() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void checkClassIngredientGetName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkClassIngredientGetPrice() {
        assertEquals(price, ingredient.getPrice(), 0.001);
    }



}