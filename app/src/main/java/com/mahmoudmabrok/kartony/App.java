package com.mahmoudmabrok.kartony;

import android.app.Application;

import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by Mahmoud on 7/22/2018.
 */

public class App extends Application {


    /**
     * APPid : ca-app-pub-8802187210935584~6180842695
     * banner  : ca-app-pub-8802187210935584/1702116601
     */

    @Override
    public void onCreate() {
        super.onCreate();

        new Prefs.Builder()
                .setContext(this)
                .setMode(MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .build();

    }

}
