package com.mursitaffandi.myjetpack.ui.listmovie;

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
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MovieFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private final MovieListFragment movieFragment = new MovieListFragment();



    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(movieFragment);

    }
    
    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }
    
    @Test
    public void loadMovie() {
        onView(withId(R.id.rv_list_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_list_show)).check(new RecyclerViewItemCountAssertion(10));
    }

}
