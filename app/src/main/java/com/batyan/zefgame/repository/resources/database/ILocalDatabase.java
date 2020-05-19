package com.batyan.zefgame.repository.resources.database;


import java.util.Date;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.batyan.zefgame.model.ArticleModel;

public interface ILocalDatabase {
    ArticleModel getArticle(int id);

    int insertArticle(List<ArticleModel> articleList);

    LiveData<List<ArticleModel>> getAllArticles();

    LiveData<Integer> getCount();

    void updateChosenArticle(int id);
}

