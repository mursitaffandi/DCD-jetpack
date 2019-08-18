package com.mursitaffandi.myjetpack.utils;


import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;
import com.mursitaffandi.myjetpack.data.source.remote.response.MovieResponse;
import com.mursitaffandi.myjetpack.data.source.remote.response.TvshowResponse;

import java.util.ArrayList;

public class FakeDataDummy {
    
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
                168,
                false
        ));
        movieEntityList.add(new MovieEntity(
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "en",
                "The Lion King",
                false,
                "The Lion King",
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "/1TUg5pO1VZ4B0Q1amk3OlXvlpXV.jpg",
                "2019-07-12",
                7.2,
                385.054,
                420818,
                false,
                1389,
                false
        ));
        
        return movieEntityList;
    }
    
    public static MovieEntity getMovie(int movieId) {
        for (int i = 0; i < generateDummyMovieEntity().size(); i++) {
            MovieEntity entity = generateDummyMovieEntity().get(i);
            if (entity.getId() == movieId) {
                return entity;
            }
        }
        return null;
    }
    
    public static ArrayList<MovieResponse> generateDummyMovieResponse() {
        
        ArrayList<MovieResponse> movieResponseList = new ArrayList<>();
        
        movieResponseList.add(new MovieResponse(
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
        
        movieResponseList.add(new MovieResponse(
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "en",
                "The Lion King",
                false,
                "The Lion King",
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "/1TUg5pO1VZ4B0Q1amk3OlXvlpXV.jpg",
                "2019-07-12",
                7.2,
                385.054,
                420818,
                false,
                1389
        ));
        
        return movieResponseList;
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
                "/fki3kBlwJzFp8QohL43g9ReV455.jpg",
                false
        ));
        
        tvShowEntityArrayList.add(new TvshowEntity(
                "2019-07-25",
                "/bI37vIHSH7o4IVkq37P8cfxQGMx.jpg",
                "A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.",
                "en",
                "The Boys",
                221.738,
                8.4,
                "The Boys",
                76479,
                51,
                "/dzOxNbbz1liFzHU1IPvdgUR647b.jpg",
                false
        ));
        
        
        return tvShowEntityArrayList;
    }
    public static TvshowEntity getTvshow(int tvshowId) {
        for (int i = 0; i < generateDummyTvShowEntity().size(); i++) {
            TvshowEntity entity = generateDummyTvShowEntity().get(i);
            if (entity.getId() == tvshowId) {
                return entity;
            }
        }
        return null;
    }
    
    public static ArrayList<TvshowResponse> generateDummyTvShowResponse() {
        ArrayList<TvshowResponse> tvshowResponseArrayList = new ArrayList<>();
        
        tvshowResponseArrayList.add(new TvshowResponse(
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
        
        tvshowResponseArrayList.add(new TvshowResponse(
                "The Boys",
                "The Boys",
                221.738,
                51,
                "2019-07-25",
                "/bI37vIHSH7o4IVkq37P8cfxQGMx.jpg",
                "en",
                76479,
                8.4,
                "A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.",
                "/dzOxNbbz1liFzHU1IPvdgUR647b.jpg"
        ));
        
        
        return tvshowResponseArrayList;
    }
}