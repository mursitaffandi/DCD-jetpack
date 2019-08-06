package com.mursitaffandi.myjetpack.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import com.mursitaffandi.myjetpack.data.source.local.LocalRepository;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.data.source.remote.RemoteRepository;
import com.mursitaffandi.myjetpack.data.source.remote.response.MovieResponse;
import com.mursitaffandi.myjetpack.data.source.remote.response.TvshowResponse;
import com.mursitaffandi.myjetpack.utils.FakeDataDummy;
import com.mursitaffandi.myjetpack.utils.LiveDataTestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ShowRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalRepository local = Mockito.mock(LocalRepository.class);
    private RemoteRepository remote = Mockito.mock(RemoteRepository.class);
    private FakeShowRepository showRepository = new FakeShowRepository(local, remote);

    private ArrayList<MovieResponse> movieResponses = FakeDataDummy.generateDummyMovie();
    private ArrayList<TvshowResponse> tvshowResponses = FakeDataDummy.generateDummyTvShow();
/*    private int movieId = movieResponses.get(0).getId();
    private int tvshowId = tvshowResponses.get(0).getId();*/

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void getAllTvShows() {

        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvshowsCallback) invocation.getArguments()[0])
                    .onAllTvshowsReceived(tvshowResponses);
            return null;
        }).when(remote).getAllTvshows(any(RemoteRepository.LoadTvshowsCallback.class));

        List<TvshowEntity> result = LiveDataTestUtil.getValue(showRepository.getAllTvShows());

        verify(remote, times(1)).getAllTvshows(any(RemoteRepository.LoadTvshowsCallback.class));

        assertEquals(tvshowResponses.size(), result.size());
    }

    @Test
    public void getAllMovies() {

        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback) invocation.getArguments()[0])
                    .onAllMoviesReceived(movieResponses);
            return null;
        }).when(remote).getAllMovie(any(RemoteRepository.LoadMoviesCallback.class));

        List<MovieEntity> result = LiveDataTestUtil.getValue(showRepository.getAllMovies());

        verify(remote, times(1)).getAllMovie(any(RemoteRepository.LoadMoviesCallback.class));

        assertEquals(movieResponses.size(), result.size());
    }
}
