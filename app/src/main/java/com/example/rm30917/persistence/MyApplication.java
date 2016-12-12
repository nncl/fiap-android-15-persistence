package com.example.rm30917.persistence;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by RM30917 on 12/12/2016.
 */
public class MyApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

}
