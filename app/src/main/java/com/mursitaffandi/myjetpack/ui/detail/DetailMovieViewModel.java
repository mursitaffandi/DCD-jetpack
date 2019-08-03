package com.mursitaffandi.myjetpack.ui.detail;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mursitaffandi.myjetpack.data.DetailMovieG;
import com.mursitaffandi.myjetpack.data.MovieEntity;
import com.mursitaffandi.myjetpack.utils.Cons;
import cz.msebera.android.httpclient.Header;
import java.util.ArrayList;

public class DetailMovieViewModel extends ViewModel {
    private MutableLiveData<DetailMovieG> listMovie = new MutableLiveData<>();

    void setMovies(String id) {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<MovieEntity> listItems = new ArrayList<>();
        String url = Cons.BASE_URL + "tv/"+ id+ "?" + Cons.API_KEY;

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                listMovie.postValue(gson.fromJson(result, DetailMovieG.class));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    LiveData<DetailMovieG> getMovies() {
        return listMovie;
    }
}
