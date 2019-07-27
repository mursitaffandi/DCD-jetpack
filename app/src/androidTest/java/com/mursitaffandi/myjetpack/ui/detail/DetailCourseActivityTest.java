package com.mursitaffandi.myjetpack.ui.detail;

import android.content.Context;
import android.content.Intent;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import com.dicoding.academies.R;
import com.dicoding.academies.data.CourseEntity;
import com.dicoding.academies.utils.FakeDataDummy;
import com.dicoding.academies.utils.RecyclerViewItemCountAssertion;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.utils.FakeDataDummy;
import com.mursitaffandi.myjetpack.utils.RecyclerViewItemCountAssertion;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class DetailCourseActivityTest {

    private ShowsVideo dummyMovie = FakeDataDummy.generateDummyMovie().get(0);
    private ShowsVideo dummyTvShow = FakeDataDummy.generateDummyMovie().get(0);

    @Rule
    public ActivityTestRule<DetailShowActivity> activityRule = new ActivityTestRule<DetailShowActivity>(DetailShowActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailShowActivity.class);
            result.putExtra(DetailShowActivity.EXTRA_SHOW_ID, dummyMovie.getmId());
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
    public void loadCourse() {
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie.getmTitle())));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(withText(dummyMovie.getmReleaseDate())));
        onView(withId(R.id.text_description)).check(matches(isDisplayed()));
        onView(withId(R.id.text_description)).check(matches(withText(dummyMovie.getmOverview())));
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()));

    }
}
