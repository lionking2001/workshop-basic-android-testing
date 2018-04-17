package workshop.testing.data.local;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import workshop.testing.data.model.Recipe;

public class RecipeStore {
    public final List<Recipe> recipes = new ArrayList<>();
    private final Map<String, Recipe> map = new HashMap<>();

    public RecipeStore(Context context, String directory) {
        // TODO:: for your homework -> Read all file from assets/recipes directory

        // Demo in workshop :: Ugly code !!
        File file1 = new File(directory, "chocolate_pudding.txt");
        File file2 = new File(directory,"creamed_carrots.text");
        File file3 = new File(directory,"deviled_eggs");
        File file4 = new File(directory,"fried_tomatoes");
        InputStream stream1 = null;
        try {
            stream1 = context.getAssets().open(file1.getPath());
            Recipe recipe = Recipe.readFromStream(stream1);
            recipes.add(recipe);
            map.put(recipe.id, recipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Recipe getRecipe(String id) {
        return map.get(id);
    }
}
