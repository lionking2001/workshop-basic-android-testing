package workshop.testing.data.model;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class RecipeTest {

    @Test
    public void water(){
        InputStream stream = RecipeTest.class.getResourceAsStream("/ecipes/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        assertNotNull(recipe);


    }

}