package workshop.testing.ui.recipe;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import workshop.testing.R;
import workshop.testing.data.local.RecipeStore;
import workshop.testing.data.model.Recipe;

public class RecipeActivity extends AppCompatActivity {
    public static final String KEY_ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final TextView titleView = (TextView) findViewById(R.id.title);
        TextView descriptionView = (TextView) findViewById(R.id.description);
        final Button favorite =(Button) findViewById(R.id.favorite) ;

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favorite.setText("Added");
            }
        });

        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        final Recipe recipe = store.getRecipe(id);

        if (recipe == null) {
            titleView.setVisibility(View.GONE);
            descriptionView.setText(R.string.recipe_not_found);
            return;
        }

        titleView.setText(recipe.title);
        descriptionView.setText(recipe.description);
    }
}