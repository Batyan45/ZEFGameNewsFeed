package com.batyan.zefgame.modules.feed;

import android.content.Intent;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.batyan.zefgame.App;
import com.batyan.zefgame.R;
import com.batyan.zefgame.model.ArticleModel;
import com.batyan.zefgame.repository.resources.Constants;
import com.batyan.zefgame.repository.resources.database.LocalDatabase;
import com.batyan.zefgame.utilities.DatabaseService;

class FeedModuleContract {
    private static final String KEY_URL = App.getInstance().getString(R.string.url);

    static LiveData<List<ArticleModel>> listLiveData = (new LocalDatabase(App.getInstance().getDatabase()))
            .getAllArticles();

    static void downloadArticles() {
        Intent intentDownloadService = new Intent(App.getInstance(), DatabaseService.class);
        intentDownloadService.putExtra(KEY_URL, Constants.MAIN_PAGE);
        App.getInstance().startService(intentDownloadService);
    }
}