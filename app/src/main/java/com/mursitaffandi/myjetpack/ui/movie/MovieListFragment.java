package com.mursitaffandi.myjetpack.ui.movie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.MovieEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieListFragment extends Fragment {

    private RecyclerView rvMovie;
    private ProgressBar progressBar;
    private MovielistAdapter movielistAdapter;
    private MovielistViewModel viewModel;

    public MovieListFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance() {
        MovieListFragment fragment = new MovieListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_movie);
        progressBar = view.findViewById(R.id.progress_bar_movie);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            viewModel = ViewModelProviders.of(this).get(MovielistViewModel.class);
            viewModel.getMovies().observe(this, getmovies);

            movielistAdapter = new MovielistAdapter(getActivity());

            rvMovie.setHasFixedSize(true);
            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setAdapter(movielistAdapter);


            viewModel.setMovies();
            showLoading(true);

        }
    }
    private Observer<ArrayList<MovieEntity>> getmovies = new Observer<ArrayList<MovieEntity>>() {
        @Override
        public void onChanged(ArrayList<MovieEntity> movieEntities) {
            if (movieEntities != null) {
                movielistAdapter.setListShows(movieEntities);
                movielistAdapter.notifyDataSetChanged();

                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
