package com.batyan.zefgame.repository.resources.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ArticleDB.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticlesDao articlesDao();
}
