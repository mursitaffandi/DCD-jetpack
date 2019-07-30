package com.mursitaffandi.myjetpack.ui.movie;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mursitaffandi.myjetpack.data.MovieEntity;
import com.mursitaffandi.myjetpack.utils.Cons;
import cz.msebera.android.httpclient.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovielistViewModel extends ViewModel {
    private MutableLiveData<ArrayList<MovieEntity>> listMovie = new MutableLiveData<>();

    void setMovies() {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<MovieEntity> listItems = new ArrayList<>();
        String url = Cons.BASE_URL + "movie/popular?" + Cons.API_KEY;

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("results");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject movieObj = list.getJSONObject(i);
                        MovieEntity movie = new MovieEntity(
                                Integer.parseInt(movieObj.getString("id")),
                                movieObj.getString("title"),
                                movieObj.getString("release_date"),
                                movieObj.getString("poster_path"));
                        movie.getmId();
                        listItems.add(movie);
                    }
                    listMovie.postValue(listItems);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    LiveData<ArrayList<MovieEntity>> getMovies() {
        return listMovie;
    }
}

