package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestMockClassBun {


    @Test
    public void checkClassBunGetName(){
        Bun bun  = new Bun("black bun", 100);
        Assert.assertEquals("black bun", bun.getName());
    }
    @Test
    public void checkClassBunGetPrice(){
        Bun bun  = new Bun("white bun", 200);
        Assert.assertEquals(200, bun.getPrice(), 0.001F);
    }

}

