package workshop.testing.data.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.*;

public class RecipeTest {

    @Test
    public void water() {
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        assertNotNull(recipe);
        assertEquals("Water", recipe.title);
        assertEquals("water", recipe.id);
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description);


    }

    @Test
    public void mixing() {
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/mixed.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        assertNotNull(recipe);
        assertEquals("Juice of 3 lemons\n" +
                "1 orange\n" +
                "1 pint grape juice\n" +
                "1 cup sugar\n" +
                "1 cup water\n" +
                "1 pine apple juice\n" +
                "Mix all together and strain. Add large piece of ice.",recipe.description);

    }

   @Test
    public void no_id() throws IOException{
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/no_id.txt");
        stream.close();
        Recipe recipe = Recipe.readFromStream(stream);
       assertEquals(null, recipe);
    }

}