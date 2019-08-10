package com.mursitaffandi.myjetpack.ui.favorite.favoritesmovie;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mursitaffandi.myjetpack.R;

public class FavoritesMovieFragment extends Fragment {

    private FavoritesMovieViewModel mViewModel;

    public static FavoritesMovieFragment newInstance() {
        return new FavoritesMovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_show, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FavoritesMovieViewModel.class);
        // TODO: Use the ViewModel
    }

}
