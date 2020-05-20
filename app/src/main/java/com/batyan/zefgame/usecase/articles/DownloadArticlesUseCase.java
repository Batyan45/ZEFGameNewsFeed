package com.batyan.zefgame.usecase.articles;

import android.content.Intent;

import com.batyan.zefgame.App;
import com.batyan.zefgame.usecase.common.UseCase;
import com.batyan.zefgame.utilities.DatabaseService;

public final class DownloadArticlesUseCase
        extends UseCase<DownloadArticlesUseCase.RequestValues, DownloadArticlesUseCase.ResponseValues> {

    public static final class RequestValues implements UseCase.IRequestValues {
        private final String url;

        public RequestValues(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public static final class ResponseValues implements UseCase.IResponseValues {

    }

    private final App application;

    public DownloadArticlesUseCase(final App application) {
        this.application = application;
    }

    @Override
    protected void execute(final RequestValues requestParameters) {
        Intent intentDownloadService = new Intent(application, DatabaseService.class);
        intentDownloadService.putExtra("url", requestParameters.getUrl());
        application.startService(intentDownloadService);
    }
}
