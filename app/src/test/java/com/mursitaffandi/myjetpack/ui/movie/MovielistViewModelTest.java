package com.mursitaffandi.myjetpack.ui.movie;

import com.mursitaffandi.myjetpack.data.MovieEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovielistViewModelTest {
    private MovielistViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MovielistViewModel();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getMovies() {
        List<MovieEntity> movieEntities = viewModel.getMovies();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());
    }

}