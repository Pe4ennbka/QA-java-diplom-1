package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TestMockClassBurger {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;


    @Test
    public void checkClassBurgerSetBuns(){
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(10f);

        burger.setBuns(bun);

        Assert.assertEquals(20f,  burger.getPrice(), 0.1f);

    }
    @Test
    public void checkClassBurgerAddIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void checkClassBurgerRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
        Assert.assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void checkClassBurgerMoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
        Assert.assertEquals(2, burger.ingredients.size());
    }
    @Test
    public void checkClassBurgerGetPrice(){
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(10f);
        when(ingredient1.getPrice()).thenReturn(5f);

        burger.setBuns(bun);

        burger.addIngredient(ingredient1);

        Assert.assertEquals(25f,     burger.getPrice(), 0.1f);
    }
    @Test
    public void checkClassBurgerGetReceipt(){
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(100F);
        when(bun.getName()).thenReturn("black bun");
        when(ingredient1.getPrice()).thenReturn(100F);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        String receiptBurger = "(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 300,000000\n";

        Assert.assertEquals(receiptBurger.replace("\r\n", "\n").trim(), burger.getReceipt().replace("\r\n", "\n").trim());
    }



}
