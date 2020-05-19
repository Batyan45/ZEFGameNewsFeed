package com.batyan.zefgame;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.batyan.zefgame.repository.resources.database.AppDatabase;

import java.io.Serializable;

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