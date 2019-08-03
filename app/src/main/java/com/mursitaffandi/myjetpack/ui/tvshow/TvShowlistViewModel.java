package com.mursitaffandi.myjetpack.ui.tvshow;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mursitaffandi.myjetpack.data.TvShowEntity;
import com.mursitaffandi.myjetpack.utils.Cons;
import cz.msebera.android.httpclient.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TvShowlistViewModel extends ViewModel {

    private MutableLiveData<ArrayList<TvShowEntity>> listTvShow = new MutableLiveData<>();

    void setTvShows() {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<TvShowEntity> listItems = new ArrayList<>();
        String url = Cons.BASE_URL + "tv/popular?" + Cons.API_KEY;

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("results");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject movieObj = list.getJSONObject(i);
                        TvShowEntity movie = new TvShowEntity(
                                movieObj.getString("original_name"),
                                movieObj.getString("name"),
                                movieObj.getInt("vote_count"),
                                movieObj.getString("first_air_date"),
                                movieObj.getString("backdrop_path"),
                                movieObj.getString("original_language"),
                                movieObj.getInt("id"),
                                movieObj.getString("overview"),
                                movieObj.getString("poster_path")
                        );
                        listItems.add(movie);
                    }
                    listTvShow.postValue(listItems);
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

    LiveData<ArrayList<TvShowEntity>> getTvShows() {
        return listTvShow;
    }
}

