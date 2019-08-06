package com.mursitaffandi.myjetpack.utils;


import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.data.source.remote.response.MovieResponse;
import com.mursitaffandi.myjetpack.data.source.remote.response.TvshowResponse;

import java.util.ArrayList;

public class FakeDataDummy {

    public static ArrayList<MovieResponse> generateDummyMovie() {

        ArrayList<MovieResponse> movieEntityList = new ArrayList<>();

        movieEntityList.add(new MovieResponse(
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.",
                "en",
                "Fast & Furious Presents: Hobbs & Shaw",
                false,
                "Fast & Furious Presents: Hobbs & Shaw",
                "/keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
                "/hpgda6P9GutvdkDX5MUJ92QG9aj.jpg",
                "2019-08-01",
                6.8,
                413.258,
                384018,
                false,
                168
        ));

        return movieEntityList;
    }

    public static ArrayList<MovieEntity> generateDummyMovieEntity() {

        ArrayList<MovieEntity> movieEntityList = new ArrayList<>();

        movieEntityList.add(new MovieEntity(
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.",
                "en",
                "Fast & Furious Presents: Hobbs & Shaw",
                false,
                "Fast & Furious Presents: Hobbs & Shaw",
                "/keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
                "/hpgda6P9GutvdkDX5MUJ92QG9aj.jpg",
                "2019-08-01",
                6.8,
                413.258,
                384018,
                false,
                168
        ));

        return movieEntityList;
    }

    public static ArrayList<TvshowResponse> generateDummyTvShow() {
        ArrayList<TvshowResponse> tvShowEntityArrayList = new ArrayList<>();

        tvShowEntityArrayList.add(new TvshowResponse(
                "The Flash",
                "The Flash",
                263.85,
                2763,
                "2014-10-07",
                "/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg",
                "en",
                60735,
                6.7,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/fki3kBlwJzFp8QohL43g9ReV455.jpg"
        ));
        return tvShowEntityArrayList;
    }

    public static ArrayList<TvshowEntity> generateDummyTvShowEntity() {
        ArrayList<TvshowEntity> tvShowEntityArrayList = new ArrayList<>();

        tvShowEntityArrayList.add(new TvshowEntity(
                "2014-10-07",
                "/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "en",
                "The Flash",
                263.85,
                6.7,
                "The Flash",
                60735,
                2763,
                "/fki3kBlwJzFp8QohL43g9ReV455.jpg"
        ));
        return tvShowEntityArrayList;
    }
}