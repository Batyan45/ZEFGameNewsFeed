package com.batyan.zefgame.modules.feed;

import com.batyan.zefgame.repository.resources.Constants;
import com.batyan.zefgame.usecase.common.UseCase;
import com.batyan.zefgame.usecase.common.UseCaseExecutor;
import com.batyan.zefgame.usecase.articles.DownloadArticlesUseCase;

public final class FeedPresenter implements FeedModuleContract.IFeedModulePresenter {

    private final UseCaseExecutor useCaseExecutor;
    private final DownloadArticlesUseCase downloadArticlesUseCase;

    FeedPresenter(final UseCaseExecutor useCaseExecutor,
                  final DownloadArticlesUseCase downloadArticlesUseCase) {
        this.useCaseExecutor = useCaseExecutor;
        this.downloadArticlesUseCase = downloadArticlesUseCase;
    }

    @Override
    public void downloadArticles() {
        obtainArticles();
    }

    private void obtainArticles() {
        final DownloadArticlesUseCase.RequestValues requestValues = new DownloadArticlesUseCase.RequestValues(Constants.MAIN_PAGE);

        useCaseExecutor.execute(downloadArticlesUseCase, requestValues, new UseCase.IUseCaseCallback<DownloadArticlesUseCase.ResponseValues>() {
            @Override
            public void onSuccess(final DownloadArticlesUseCase.ResponseValues response) {

            }

            @Override
            public void onError(final String errorMessage) {

            }
        });
    }
}