package com.mursitaffandi.myjetpack.utils;

import com.mursitaffandi.myjetpack.R;
import com.mursitaffandi.myjetpack.data.MovieEntity;
import com.mursitaffandi.myjetpack.data.ShowsVideo;
import com.mursitaffandi.myjetpack.data.TvShowEntity;

import java.util.ArrayList;

public class FakeDataDummy {

    public static ArrayList<ShowsVideo> generateDummyMovie() {

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

    public static ArrayList<ShowsVideo> generateDummyTvShow() {
        ArrayList<ShowsVideo> tvShowEntityArrayList = new ArrayList<>();

        tvShowEntityArrayList.add(new TvShowEntity(
                1,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "October 10, 2012",
                R.drawable.poster_tvshow_arrow,
                R.drawable.poster_tvshow_arrow
        ));
        tvShowEntityArrayList.add(new TvShowEntity(
                2,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "February 15, 2019",
                R.drawable.poster_tvshow_doom_patrol,
                R.drawable.poster_tvshow_doom_patrol
        ));
        tvShowEntityArrayList.add(new TvShowEntity(
                3,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.",
                "February 26, 1986",
                R.drawable.poster_tvshow_dragon_ball,
                R.drawable.poster_tvshow_dragon_ball
        ));
        tvShowEntityArrayList.add(new TvShowEntity(
                4,
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "October 12, 2009",
                R.drawable.poster_tvshow_fairytail,
                R.drawable.poster_tvshow_fairytail
        ));
        tvShowEntityArrayList.add(new TvShowEntity(
                5,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "January 31, 1999",
                R.drawable.poster_tvshow_family_guy,
                R.drawable.poster_tvshow_family_guy
        ));
        tvShowEntityArrayList.add(new TvShowEntity(
                6,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only meta-human who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "October 7, 2014",
                R.drawable.poster_tvshow_flash,
                R.drawable.poster_tvshow_flash
        ));
        tvShowEntityArrayList.add(new TvShowEntity(
                7,
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "April 17, 2011",
                R.drawable.poster_tvshow_god,
                R.drawable.poster_tvshow_god
        ));
        tvShowEntityArrayList.add(new TvShowEntity(
                8,
                "Gotham",
                "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "September 22, 2014",
                R.drawable.poster_tvshow_gotham,
                R.drawable.poster_tvshow_gotham
        ));
        tvShowEntityArrayList.add(new TvShowEntity(
                9,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "March 27, 2005",
                R.drawable.poster_tvshow_grey_anatomy,
                R.drawable.poster_tvshow_grey_anatomy
        ));
        tvShowEntityArrayList.add(new TvShowEntity(
                10,
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "March 28, 2019",
                R.drawable.poster_tvshow_hanna,
                R.drawable.poster_tvshow_hanna
        ));
        return tvShowEntityArrayList;
    }

    public static ShowsVideo getMovie(int movieId, String type){

        for (int i = 0; i< generateDummyMovie().size();i++){
            MovieEntity entity = (MovieEntity) generateDummyMovie().get(i);
            if (entity.getmId() == movieId) {
                return entity;
            }
        }
        return null;
    }

}
