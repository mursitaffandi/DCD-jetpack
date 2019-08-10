package com.mursitaffandi.myjetpack.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.di.Injection;
import com.mursitaffandi.myjetpack.ui.detailmovie.DetailMovieViewModel;
import com.mursitaffandi.myjetpack.ui.detailtvshow.DetailTvShowViewModel;
import com.mursitaffandi.myjetpack.ui.listmovie.MovielistViewModel;
import com.mursitaffandi.myjetpack.ui.listtvshow.TvShowlistViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final ShowRepository mAcademyRepository;

    private ViewModelFactory(ShowRepository academyRepository) {
        mAcademyRepository = academyRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovielistViewModel.class)) {
            //noinspection unchecked
            return (T) new MovielistViewModel(mAcademyRepository);
        } else if (modelClass.isAssignableFrom(TvShowlistViewModel.class)) {
            //noinspection unchecked
            return (T) new TvShowlistViewModel(mAcademyRepository);
        } else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)) {
            //noinspection unchecked
            return (T) new DetailMovieViewModel(mAcademyRepository);
        } else if (modelClass.isAssignableFrom(DetailTvShowViewModel.class)) {
            //noinspection unchecked
            return (T) new DetailTvShowViewModel(mAcademyRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

}
