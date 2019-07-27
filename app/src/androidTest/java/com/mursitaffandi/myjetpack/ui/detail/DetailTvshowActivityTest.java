package com.mursitaffandi.myjetpack.ui.detail;

import android.content.Context;
import android.content.Intent;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.utils.FakeDataDummy;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static com.mursitaffandi.myjetpack.utils.EspressoTestsMatchers.withDrawable;

public class DetailTvshowActivityTest {

    private ShowsVideo dummyTvshow = FakeDataDummy.generateDummyTvShow().get(0);

    @Rule
    public ActivityTestRule<DetailShowActivity> activityRule = new ActivityTestRule<DetailShowActivity>(DetailShowActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailShowActivity.class);
            result.putExtra(DetailShowActivity.EXTRA_SHOW_ID, dummyTvshow.getmId());
            return result;
        }
    };

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadTvShow() {
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dummyTvshow.getmTitle())));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(withText(dummyTvshow.getmReleaseDate())));
        onView(withId(R.id.text_description)).check(matches(isDisplayed()));
        onView(withId(R.id.text_description)).check(matches(withText(dummyTvshow.getmOverview())));
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.image_poster)).check(matches(withDrawable(dummyTvshow.getmPoster())));

    }
}
