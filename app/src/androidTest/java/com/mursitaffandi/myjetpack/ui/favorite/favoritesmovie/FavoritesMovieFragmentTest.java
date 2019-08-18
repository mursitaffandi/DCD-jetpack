package com.mursitaffandi.myjetpack.ui.favorite.favoritesmovie;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.testing.SingleFragmentActivity;
import com.mursitaffandi.myjetpack.utils.EspressoIdlingResource;
import com.mursitaffandi.myjetpack.utils.RecyclerViewItemCountAssertion;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class FavoritesMovieFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private FavoritesMovieFragment bookmarkFragment = new FavoritesMovieFragment();
    
    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(bookmarkFragment);
    }
    
    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }
    
    @Test
    public void loadBookmarks() { onView(withId(R.id.rv_list_favorite_movie)).check(new RecyclerViewItemCountAssertion(1));
    }
}