package com.custom.indianic.custome;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by indianic on 20/04/16.
 */
public class Custome extends Application {
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
