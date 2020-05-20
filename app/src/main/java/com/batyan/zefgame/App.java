package com.batyan.zefgame;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.room.Room;

import com.batyan.zefgame.repository.resources.database.AppDatabase;

public class App extends Application {
    private AppDatabase database;
    @SuppressLint("StaticFieldLeak")
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        this.database = Room.databaseBuilder(this, AppDatabase.class, "database").build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}