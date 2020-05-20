package com.batyan.zefgame.modules.article;

import com.batyan.zefgame.modules.common.IBasePresenter;
import com.batyan.zefgame.modules.common.IBaseView;

public interface ArticleModuleContract {

    interface IArticleView extends IBaseView<IArticlePresenter> {

    }

    interface IArticlePresenter extends IBasePresenter {
        void setArticle();
    }
}