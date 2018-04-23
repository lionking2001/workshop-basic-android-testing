package workshop.testing.ui.recipe;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import workshop.testing.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static workshop.testing.ui.recipe.RecipeActivity.KEY_ID;

public class RecipeActivityTest {
    @Rule
    public ActivityTestRule<RecipeActivity> activityRule
            = new ActivityTestRule<RecipeActivity>(
            RecipeActivity.class, true, false
    );

//    @Test
//    public void noContentOnOpenActivity(){
//        onView(withId(R.id.description)).check(matches(withText("Recipe not found.")));
//    }


    @Test
    public void show_detail_of_chocolate_pudding() {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, "chocolate_pudding");
        activityRule.launchActivity(intent);

        onView(withId(R.id.title)).check(matches(withText("Chocolate Pudding")));
        onView(withId(R.id.description)).check(matches(withText("2 tablespoons chocolate\n" +
                "yolks of 4 eggs\n" +
                "1 cup sugar\n" +
                "1 quart milk\n" +
                "1 whole egg\n" +
                "2 tablespoons corn starch\n" +
                "\n" +
                "Cook until it thickens, beat whites of eggs and put on top, put in oven to brown. Serve with cream, if preferred.")));

    }

    @Test
    public void show_detail_of_creamed_carrots() {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, "creamed_carrots");
        activityRule.launchActivity(intent);

        onView(withId(R.id.title)).check(matches(withText("Creamed Carrots")));
        onView(withId(R.id.description)).check(matches(withText("Peel and dice carrots, cook in salt water until tender, remove from stove and drain. Fry 4 slides of bacon, drain off a part of grease, cut bacon in small slices, add carrots, 2 tablespoons of flour, stir all together, add 1 cup of sweet cream, salt and pepper to taste.")));

    }
    
    @Test
    public void show_detail_of_deviled_eggs() {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, "deviled_eggs");
        activityRule.launchActivity(intent);

        onView(withId(R.id.title)).check(matches(withText("Deviled Eggs")));
        onView(withId(R.id.description)).check(matches(withText("Boil fresh eggs until hard, remove shells, cut into halves lengthwise, remove yolks and mash very fine. Season with melted butter, pepper, salt, sugar and a little vinegar or prepared salad dressing may be used if preferred. Stuff eggs and in the center of each put a stuffed olive.")));

    }

    @Test
    public void success() {
        Intent intent = new Intent();
        intent.putExtra(KEY_ID, "chocolate_pudding");
        activityRule.launchActivity(intent);
        onView(withId(R.id.title)).check(matches(withText("Chocolate Pudding")));
    }
}