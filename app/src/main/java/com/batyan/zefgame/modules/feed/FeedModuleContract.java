package com.batyan.zefgame.modules.feed;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.batyan.zefgame.App;
import com.batyan.zefgame.model.ArticleModel;
import com.batyan.zefgame.modules.common.IBasePresenter;
import com.batyan.zefgame.modules.common.IBaseView;
import com.batyan.zefgame.repository.resources.database.LocalDatabase;

public interface FeedModuleContract {
    LiveData<List<ArticleModel>> listLiveData = (new LocalDatabase(App.getInstance().getDatabase()))
            .getAllArticles();

    interface IFeedModuleView extends IBaseView<IFeedModulePresenter> {
        void showArticles(final List<ArticleModel> articles);
        void showError(final String errorMessage);
    }

    interface IFeedModulePresenter extends IBasePresenter {
        void downloadArticles();
    }
}