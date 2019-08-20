package com.mursitaffandi.myjetpack.ui;

import android.view.View;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.ui.home.HomeActivity;
import com.mursitaffandi.myjetpack.utils.EspressoIdlingResource;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;

public class ShowsTest {
//    TODO : Run this test before FavoritesTvshowFragmentTest and FavoritesMovieFragmentTest
    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void toDetailActivityTest() {
//        mengklik bottom navigation Movie
        onView(withId(R.id.action_movie)).perform(click());
//    mengcek list movie ditampilkan
        onView(withId(R.id.rv_list_show)).check(matches(isDisplayed()));
//    mengklik item pertama pada list movie untuk masuk ke halaman DetailMovie
        onView(withId(R.id.rv_list_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
//    mengcek judul movie ditampilkan
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
//        mengcek judul movie adalah "Cars"
        onView(withId(R.id.text_title)).check(matches(withText("Cars")));
//        mengklik tombol favorite untuk mengsetting movie menjadi favorite di database
        onView(withId(R.id.action_favorite)).perform(click());
//        mengklik tombol toolbar back to home untuk kembali ke halaman home movie
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());
        
        
//        mengklik bottom navigation TvShow
        onView(withId(R.id.action_tvshow)).perform(click());
//    mengcek list TvShow ditampilkan
        onView(withId(R.id.rv_list_show)).check(matches(isDisplayed()));
//    mengklik item kedua pada list TvShow untuk masuk ke halaman DetailTvShow
        onView(withId(R.id.rv_list_show)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
//    mengcek judul TvShow ditampilkan
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
//        mengcek judul TvShow adalah "Arrow"
        onView(withId(R.id.text_title)).check(matches(withText("Arrow")));
//        mengklik tombol favorite untuk mengsetting movie menjadi favorite di database
        onView(withId(R.id.action_favorite)).perform(click());
//        mengklik tombol toolbar back to home untuk kembali ke halaman home movie
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());
        
        
//        mengklik bottom navigation Favorite Movie
        onView(withId(R.id.action_favorite)).perform(click());
//        mengklik tombol tab "MOVIES" pada tab_home
        Matcher<View> matcher = allOf(withText("MOVIES"),
                isDescendantOfA(withId(R.id.tab_home)));
        onView(matcher).perform(click());

//    mengcek list Favorite Movie ditampilkan
        
        onView(withId(R.id.rv_list_favorite_movie)).check(matches(isDisplayed()));
//    mengklik item kedua pada list Favorite Movie untuk masuk ke halaman DetailMovie
        onView(withId(R.id.rv_list_favorite_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
//    mengcek judul movie ditampilkan
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
//        mengcek judul movie adalah "Cars"
        onView(withId(R.id.text_title)).check(matches(withText("Cars")));
//        mengklik tombol favorite untuk mengsetting movie menjadi unfavorite di database
        onView(withId(R.id.action_favorite)).perform(click());
//        mengklik tombol toolbar back to home untuk kembali ke halaman home movie
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());
        
        
        //        mengklik tombol tab "TV SHOWS" pada tab_home
        Matcher<View> matcherTabTvshow = allOf(withText("TV SHOWS"),
                isDescendantOfA(withId(R.id.tab_home)));
        onView(matcherTabTvshow).perform(click());

//    mengcek list Favorite TvShow ditampil
        onView(withId(R.id.rv_list_favorite)).check(matches(isDisplayed()));
//    mengklik item kedua pada list Favorite Movie untuk masuk ke halaman DetailTvShow
        onView(withId(R.id.rv_list_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
//    mengcek judul TvShow ditampilkan
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
//        mengcek judul movie adalah "Arrow"
        onView(withId(R.id.text_title)).check(matches(withText("Arrow")));
//        mengklik tombol favorite untuk mengsetting TvShow menjadi unfavorite di database
        onView(withId(R.id.action_favorite)).perform(click());
//        mengklik tombol toolbar back to home untuk kembali ke halaman home TvShow
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());
        
    
        
//        Mengset favorite lagi untuk persiapan test FavoritesMovieFragmentTest dan FavoritesTvshowFragmentTest
        //        mengklik bottom navigation Movie
        onView(withId(R.id.action_movie)).perform(click());
//    mengcek list movie ditampilkan
        onView(withId(R.id.rv_list_show)).check(matches(isDisplayed()));
//    mengklik item pertama pada list movie untuk masuk ke halaman DetailMovie
        onView(withId(R.id.rv_list_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
//    mengcek judul movie ditampilkan
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
//        mengcek judul movie adalah "Cars"
        onView(withId(R.id.text_title)).check(matches(withText("Cars")));
//        mengklik tombol favorite untuk mengsetting movie menjadi favorite di database
        onView(withId(R.id.action_favorite)).perform(click());
//        mengklik tombol toolbar back to home untuk kembali ke halaman home movie
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());


//        mengklik bottom navigation TvShow
        onView(withId(R.id.action_tvshow)).perform(click());
//    mengcek list TvShow ditampilkan
        onView(withId(R.id.rv_list_show)).check(matches(isDisplayed()));
//    mengklik item kedua pada list TvShow untuk masuk ke halaman DetailTvShow
        onView(withId(R.id.rv_list_show)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
//    mengcek judul TvShow ditampilkan
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
//        mengcek judul TvShow adalah "Arrow"
        onView(withId(R.id.text_title)).check(matches(withText("Arrow")));
//        mengklik tombol favorite untuk mengsetting movie menjadi favorite di database
        onView(withId(R.id.action_favorite)).perform(click());
//        mengklik tombol toolbar back to home untuk kembali ke halaman home movie
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());
    
    }
}

