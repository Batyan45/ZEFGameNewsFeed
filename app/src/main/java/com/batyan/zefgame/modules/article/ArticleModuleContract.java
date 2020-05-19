package com.batyan.zefgame.modules.article;

import androidx.lifecycle.LiveData;

import com.batyan.zefgame.App;
import com.batyan.zefgame.model.ArticleModel;
import com.batyan.zefgame.modules.common.IBasePresenter;
import com.batyan.zefgame.modules.common.IBaseView;
import com.batyan.zefgame.repository.resources.database.LocalDatabase;

import java.util.List;

public interface ArticleModuleContract {

    interface IArticleView extends IBaseView<IArticlePresenter> {

    }

    interface IArticlePresenter extends IBasePresenter {
        void setArticle();
    }
}