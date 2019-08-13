package com.mursitaffandi.myjetpack.data.source.remote;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.mursitaffandi.myjetpack.data.source.remote.response.MovieResponse;
import com.mursitaffandi.myjetpack.data.source.remote.response.TvshowResponse;
import com.mursitaffandi.myjetpack.utils.EspressoIdlingResource;
import com.mursitaffandi.myjetpack.utils.JsonHelper;

import java.util.List;

public class RemoteRepository {

    private static RemoteRepository INSTANCE;
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;
    private JsonHelper jsonHelper;

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<List<MovieResponse>>> getAllMovieAsLiveData() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> resultMovie = new MutableLiveData<>();
    
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultMovie.setValue(ApiResponse.success(jsonHelper.loadMovies()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    
        return resultMovie;
    }
    
    public LiveData<ApiResponse<List<TvshowResponse>>> getAllTvshowAsLiveData() {
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<TvshowResponse>>> resultTvshow = new MutableLiveData<>();
        
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultTvshow.setValue(ApiResponse.success(jsonHelper.loadTvshows()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
        
        return resultTvshow;
    }
}

