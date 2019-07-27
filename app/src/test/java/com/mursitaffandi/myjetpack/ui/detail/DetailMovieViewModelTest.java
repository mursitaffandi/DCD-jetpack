package com.mursitaffandi.myjetpack.ui.detail;

import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.MovieEntity;
import com.mursitaffandi.myjetpack.data.TvShowEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailMovieViewModelTest {
    private DetailMovieViewModel viewModel;
    private MovieEntity dummyMovie;
    private TvShowEntity dummyTvshow;

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel();
        dummyMovie = new MovieEntity(1,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "February 14, 2019",
                R.drawable.poster_movie_alita,
                R.drawable.poster_movie_alita);

        dummyTvshow = new TvShowEntity(
                3,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.",
                "February 26, 1986",
                R.drawable.poster_tvshow_dragon_ball,
                R.drawable.poster_tvshow_dragon_ball
        );
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getMovie() {
        viewModel.setMovieId(dummyMovie.getmId(), "movie");
        MovieEntity movieEntity = (MovieEntity) viewModel.getShow();
        assertNotNull(movieEntity);
        assertEquals(dummyMovie.getmId(), movieEntity.getmId());
        assertEquals(dummyMovie.getmLogo(), movieEntity.getmLogo());
        assertEquals(dummyMovie.getmOverview(), movieEntity.getmOverview());
        assertEquals(dummyMovie.getmPoster(), movieEntity.getmPoster());
        assertEquals(dummyMovie.getmReleaseDate(), movieEntity.getmReleaseDate());
        assertEquals(dummyMovie.getmTitle(), movieEntity.getmTitle());
    }

    @Test
    public void getTvShow() {
        viewModel.setMovieId(dummyTvshow.getmId(), "tv_show");
        TvShowEntity tvShowEntity = (TvShowEntity) viewModel.getShow();
        assertNotNull(tvShowEntity);
        assertEquals(dummyTvshow.getmId(), tvShowEntity.getmId());
        assertEquals(dummyTvshow.getmLogo(), tvShowEntity.getmLogo());
        assertEquals(dummyTvshow.getmOverview(), tvShowEntity.getmOverview());
        assertEquals(dummyTvshow.getmPoster(), tvShowEntity.getmPoster());
        assertEquals(dummyTvshow.getmReleaseDate(), tvShowEntity.getmReleaseDate());
        assertEquals(dummyTvshow.getmTitle(), tvShowEntity.getmTitle());
    }
}