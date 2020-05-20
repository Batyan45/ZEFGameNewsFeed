package com.batyan.zefgame.repository.resources.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArticlesDao {

    @Query("SELECT * FROM ArticleDB WHERE id=:id")
    ArticleDB get(int id);

    @Query("SELECT * FROM ArticleDB ORDER BY id DESC")
    LiveData<List<ArticleDB>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ArticleDB news);

    @Query("SELECT COUNT(id) FROM ArticleDB")
    LiveData<Integer> getRowCount();

    @Query("UPDATE ArticleDB SET isOnScreen = 1 WHERE id = :id")
    void findArticleToShow(int id);
}
