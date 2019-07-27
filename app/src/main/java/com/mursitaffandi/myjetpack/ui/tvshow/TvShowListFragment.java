package com.mursitaffandi.myjetpack.ui.tvshow;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.TvShowEntity;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowListFragment extends Fragment {

    private RecyclerView rvTvshows;
    private ProgressBar progressBar;
    private TvShowlistAdapter tvShowlistAdapter;
    private TvShowlistViewModel viewModel;
    private List<TvShowEntity> tvShowEntities;

    public TvShowListFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance() {
        TvShowListFragment fragment = new TvShowListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTvshows = view.findViewById(R.id.rv_tvshow);
        progressBar = view.findViewById(R.id.progress_bar_tvshow);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            viewModel = ViewModelProviders.of(this).get(TvShowlistViewModel.class);

            tvShowEntities = viewModel.getTvShow();

            tvShowlistAdapter = new TvShowlistAdapter(getActivity());
            tvShowlistAdapter.setListShows(tvShowEntities);

            rvTvshows.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTvshows.setHasFixedSize(true);
            rvTvshows.setAdapter(tvShowlistAdapter);
        }
    }

}
