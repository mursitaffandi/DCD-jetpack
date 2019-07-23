package com.mursitaffandi.myjetpack.utils;

import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.MovieEntity;
import com.mursitaffandi.myjetpack.data.ShowsVideo;

import java.util.ArrayList;

public class DataDummy {

    public static ArrayList<ShowsVideo> generateDummyMovie(){
        ArrayList<ShowsVideo> movieEntityList = new ArrayList<>();

        movieEntityList.add(new MovieEntity(1,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "February 14, 2019",
                R.drawable.poster_movie_alita,
                R.drawable.poster_movie_alita));

        movieEntityList.add(new MovieEntity(2,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "October 5, 2018",
                R.drawable.poster_movie_a_start_is_born,
                R.drawable.poster_movie_a_start_is_born));

        movieEntityList.add(new MovieEntity(3,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "February 8, 2019",
                R.drawable.poster_movie_cold_persuit,
                R.drawable.poster_movie_cold_persuit));

        movieEntityList.add(new MovieEntity(4,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "November 16, 2018",
                R.drawable.poster_movie_crimes,
                R.drawable.poster_movie_crimes));

        movieEntityList.add(new MovieEntity(5,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "February 22, 2019",
                R.drawable.poster_movie_how_to_train,
                R.drawable.poster_movie_how_to_train));

        movieEntityList.add(new MovieEntity(6,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "December 21, 2018",
                R.drawable.poster_movie_aquaman,
                R.drawable.poster_movie_aquaman));

        movieEntityList.add(new MovieEntity(7,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "October 30, 2018",
                R.drawable.poster_movie_bohemian,
                R.drawable.poster_movie_bohemian));

        movieEntityList.add(new MovieEntity(8,
                "Creed",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "November 25, 2015",
                R.drawable.poster_movie_creed,
                R.drawable.poster_movie_creed));

        movieEntityList.add(new MovieEntity(9,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "January 18, 2019",
                R.drawable.poster_movie_glass,
                R.drawable.poster_movie_glass));

        movieEntityList.add(new MovieEntity(10,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "April 23, 2018",
                R.drawable.poster_movie_infinity_war,
                R.drawable.poster_movie_infinity_war));
        return movieEntityList;
    }
}
