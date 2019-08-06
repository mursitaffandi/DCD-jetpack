package com.mursitaffandi.myjetpack.di;

import android.app.Application;
import com.mursitaffandi.myjetpack.data.source.ShowRepository;
import com.mursitaffandi.myjetpack.data.source.local.LocalRepository;
import com.mursitaffandi.myjetpack.data.source.remote.RemoteRepository;
import com.mursitaffandi.myjetpack.utils.JsonHelper;

public class Injection {
    public static ShowRepository provideRepository(Application application) {

        LocalRepository localRepository = new LocalRepository();
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));

        return ShowRepository.getInstance(localRepository, remoteRepository);
    }
}
