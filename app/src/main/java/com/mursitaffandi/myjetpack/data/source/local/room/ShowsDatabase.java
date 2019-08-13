package com.mursitaffandi.myjetpack.data.source.local.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.mursitaffandi.myjetpack.data.source.local.entity.MovieEntity;
import com.mursitaffandi.myjetpack.data.source.local.entity.TvshowEntity;

@Database(entities = {MovieEntity.class, TvshowEntity.class},
        version = 1,
        exportSchema = false)
    public abstract class ShowsDatabase extends RoomDatabase {

    private static final Object sLock = new Object();
    private static ShowsDatabase INSTANCE;

    public static ShowsDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        ShowsDatabase.class, "Movies.db")
                        .build();
            }
            return INSTANCE;
        }
    }

    public abstract ShowsDao showsDao();

}