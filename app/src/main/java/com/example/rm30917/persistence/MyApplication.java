package com.example.rm30917.persistence;

import android.app.Application;
import android.content.Context;

import com.example.rm30917.persistence.DAO.DBHelper;
import com.example.rm30917.persistence.DAO.DatabaseManager;
import com.facebook.stetho.Stetho;

/**
 * Created by RM30917 on 12/12/2016.
 */
public class MyApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        DatabaseManager.initializeInstance(new DBHelper());
    }

    // Return context cause we need it into our DBHelper bro
    public static Context getContext(){
        return getContext();
    }

}
