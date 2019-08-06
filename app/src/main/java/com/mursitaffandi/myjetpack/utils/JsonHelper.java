package com.mursitaffandi.myjetpack.utils;

import android.app.Application;
import com.mursitaffandi.myjetpack.data.source.remote.response.MovieResponse;
import com.mursitaffandi.myjetpack.data.source.remote.response.TvshowResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    private Application application;

    public JsonHelper(Application application) {
        this.application = application;
    }

    private String parsingFileToString(String fileName) {
        try {
            InputStream is = application.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<MovieResponse> loadMovies() {
        ArrayList<MovieResponse> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("movies.json"));
            JSONArray listArray = responseObject.getJSONArray("movies");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject course = listArray.getJSONObject(i);

                int vote_count = course.getInt("vote_count");
                int id = course.getInt("id");
                boolean video = course.getBoolean("video");
                double vote_average = course.getDouble("vote_average");
                String title = course.getString("title");
                double popularity = course.getDouble("popularity");
                String poster_path = course.getString("poster_path");
                String original_language = course.getString("original_language");
                String original_title = course.getString("original_title");
                String backdrop_path = course.getString("backdrop_path");
                boolean adult = course.getBoolean("adult");
                String overview = course.getString("overview");
                String release_date = course.getString("release_date");

                MovieResponse courseResponse = new MovieResponse(
                        overview,
                        original_language,
                        original_title,
                        video,
                        title,
                        poster_path,
                        backdrop_path,
                        release_date,
                        vote_average,
                        popularity,
                        id,
                        adult,
                        vote_count
                        );
                list.add(courseResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<TvshowResponse> loadTvshows() {
        String fileName = String.format("tvshows.json");
        ArrayList<TvshowResponse> list = new ArrayList<>();
        try {

            String result = parsingFileToString(fileName);
            if (result != null) {
                JSONObject responseObject = new JSONObject(result);
                JSONArray listArray = responseObject.getJSONArray("tvshow");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject course = listArray.getJSONObject(i);

                    String original_name = course.getString("original_name");
                    String name = course.getString("name");
                    double popularity = course.getDouble("popularity");
                    int vote_count = course.getInt("vote_count");
                    String first_air_date = course.getString("first_air_date");
                    String backdrop_path = course.getString("backdrop_path");
                    String original_language = course.getString("original_language");
                    int id = course.getInt("id");
                    double vote_average = course.getDouble("vote_average");
                    String overview = course.getString("overview");
                    String poster_path = course.getString("poster_path");

                    TvshowResponse courseResponse = new TvshowResponse(
                            original_name,
                            name,
                            popularity,
                            vote_count,
                            first_air_date,
                            backdrop_path,
                            original_language,
                            id,
                            vote_average,
                            overview,
                            poster_path
                    );
                    list.add(courseResponse);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}

