package com.sbl.viewstudy;

import android.app.Application;

public class App extends Application {
    private static App myApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static App getApplication() {
        if (myApplication == null) {
            myApplication = new App();
        }
        return myApplication;

    }
}
