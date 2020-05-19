package com.batyan.zefgame.usecase.common;

public final class UseCaseExecutor {

    //region Singleton initialization
    private static UseCaseExecutor sharedInstance;

    public static UseCaseExecutor getInstance() {
        if (null == sharedInstance) {
            sharedInstance = new UseCaseExecutor();
        }
        return sharedInstance;
    }

    private UseCaseExecutor() {

    }
    //endregion

    //region Public interface
    public <T extends UseCase.IRequestValues, R extends UseCase.IResponseValues> void execute(
            final UseCase<T, R> useCase, final T requestValues, final UseCase.IUseCaseCallback<R> callback) {

        useCase.setRequestParameters(requestValues);
        useCase.setCallback(callback);

        useCase.run();
    }
    //endregion
}