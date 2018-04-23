package workshop.testing.data.local;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

import workshop.testing.data.model.Recipe;

public class RecipeStore {
    public final List<Recipe> recipes = new ArrayList<>();
    private final Map<String, Recipe> map = new HashMap<>();

    public RecipeStore(Context context, String directory) {
        // TODO:: for your homework -> Read all file from assets/recipes directory

        // Demo in workshop :: Ugly code !!
//        File file1 = new File(directory, "chocolate_pudding.txt");
        InputStream stream = null;

        List<File> fileList=new LinkedList<>();
        fileList.add(new File(directory, "chocolate_pudding.txt"));
        fileList.add(new File(directory, "creamed_carrots.txt"));
        fileList.add(new File(directory, "deviled_eggs.txt"));
        fileList.add(new File(directory, "fried_tomatoes.txt"));
        fileList.add(new File(directory, "hamcheese.txt"));
        try {
            for (int i=0; i<fileList.size();i++){
                stream = context.getAssets().open(fileList.get(i).getPath());
                Recipe recipe = Recipe.readFromStream(stream);
                recipes.add(recipe);
                map.put(recipe.id, recipe);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Recipe getRecipe(String id) {
        return map.get(id);
    }
}