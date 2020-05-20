package com.batyan.zefgame.repository.resources.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.batyan.zefgame.model.ArticleModel;

import java.util.ArrayList;
import java.util.List;

public class LocalDatabase implements ILocalDatabase {

    private final AppDatabase mDatabase;

    public LocalDatabase(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    private static ArticleModel convertToArticleModel(ArticleDB articleDB) {
        return new ArticleModel(articleDB.id, articleDB.title, articleDB.pubDate, articleDB.link,
                articleDB.description, articleDB.author, articleDB.text);
    }

    private static ArticleDB convertToArticleDB(final ArticleModel article) {
        return ArticleDB.create(article.getId(), article.getTitle(), article.getPubDate(), article.getLink(),
                article.getDescription(), article.getAuthor(), article.getText());
    }

    private static List<ArticleModel> convertAllToArticleModel(List<ArticleDB> articleDBList) {
        List<ArticleModel> articles = new ArrayList<>();
        for (ArticleDB articleDB : articleDBList) {
            articles.add(convertToArticleModel(articleDB));
        }
        return articles;
    }

    @Override
    public ArticleModel getArticle(int id) {
        return convertToArticleModel(mDatabase.articlesDao().get(id));
    }

    @Override
    public int insertArticle(List<ArticleModel> articleList) {
        if (articleList.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < articleList.size(); i++) {
            ArticleDB articleDB = convertToArticleDB(articleList.get(i));
            mDatabase.articlesDao().insert(articleDB);
            count++;
        }

        return count;
    }

    @Override
    public void updateChosenArticle(int id) {
        mDatabase.articlesDao().findArticleToShow(id);
    }

    @Override
    public LiveData<List<ArticleModel>> getAllArticles() {
        return Transformations.map(mDatabase.articlesDao().getAll(), LocalDatabase::convertAllToArticleModel);
    }

    @Override
    public LiveData<Integer> getCount() {
        return mDatabase.articlesDao().getRowCount();
    }
}
