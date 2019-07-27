package com.mursitaffandi.myjetpack.ui.tvshow;

import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.data.TvShowEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class TvShowlistViewModelTest {
    private TvShowlistViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new TvShowlistViewModel();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getTvShows() {
        List<TvShowEntity> movieEntities = viewModel.getTvShow();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());
    }
}