package com.batyan.zefgame.repository.resources.database;

import java.util.List;

import androidx.lifecycle.LiveData;

import com.batyan.zefgame.model.ArticleModel;

public interface ILocalDatabase {
    ArticleModel getArticle(int id);

    int insertArticle(List<ArticleModel> articleList);

    LiveData<List<ArticleModel>> getAllArticles();

    LiveData<Integer> getCount();
}

