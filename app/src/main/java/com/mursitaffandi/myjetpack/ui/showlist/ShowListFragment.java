package com.mursitaffandi.myjetpack.ui.showlist;


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
import com.mursitaffandi.myjetpack.data.ShowsVideo;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowListFragment extends Fragment {
    private static final String KEY_SHOWS = "type";

    private RecyclerView rvCourse;
    private ProgressBar progressBar;
    private ShowlistAdapter showlistAdapter;
    private ShowlistViewModel viewModel;
    private List<ShowsVideo> courses;
    public static final String TYPE_MOVIE = "movie";
    public static final String TYPE_TVSHOW = "tvShow";

    public ShowListFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance(String typeShows) {
        Bundle args = new Bundle();
        args.putString(KEY_SHOWS,typeShows);
        ShowListFragment fragment = new ShowListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCourse = view.findViewById(R.id.rv_academy);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            String key = getArguments().getString(KEY_SHOWS);
            viewModel = ViewModelProviders.of(this).get(ShowlistViewModel.class);

            if (key.equals(TYPE_MOVIE)) courses = viewModel.getMovies();
            else courses = viewModel.getTvShows();

            showlistAdapter = new ShowlistAdapter(getActivity());
            showlistAdapter.setListShows(courses, key);

            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
            rvCourse.setHasFixedSize(true);
            rvCourse.setAdapter(showlistAdapter);
        }
    }

}
