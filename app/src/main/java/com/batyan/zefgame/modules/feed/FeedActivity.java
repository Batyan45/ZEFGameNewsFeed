package com.batyan.zefgame.modules.feed;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.batyan.zefgame.App;
import com.batyan.zefgame.R;
import com.batyan.zefgame.modules.common.SingleFragmentActivity;
import com.batyan.zefgame.usecase.common.UseCaseExecutor;
import com.batyan.zefgame.usecase.articles.DownloadArticlesUseCase;

public final class FeedActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FeedFragment();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragment(R.id.fragment_container);
        setContentView(R.layout.activity_list);

        final UseCaseExecutor useCaseExecutor = UseCaseExecutor.getInstance();
        final DownloadArticlesUseCase downloadArticlesUseCase = new DownloadArticlesUseCase(App.getInstance());

        final FeedModuleContract.IFeedModuleView view = (FeedModuleContract.IFeedModuleView) fragment;
        final FeedModuleContract.IFeedModulePresenter presenter = new FeedPresenter(useCaseExecutor, downloadArticlesUseCase);
        view.setPresenter(presenter);
    }
}
