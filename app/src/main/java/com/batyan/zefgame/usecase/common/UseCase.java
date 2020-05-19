package com.batyan.zefgame.usecase.common;

public abstract class UseCase<IN extends UseCase.IRequestValues,
                              OUT extends UseCase.IResponseValues> {

    //region Abstract section. Must be overwritten
    protected abstract void execute(final IN requestParameters);
    //endregion

    //region Internal types which describes request and response types
    public interface IRequestValues {}
    public interface IResponseValues {}

    public interface IUseCaseCallback<T> {
        void onSuccess(final T response);
        void onError(final String errorMessage);
    }
    //endregion

    //region Private entities. UseCase state
    private IN requestParameters;
    private IUseCaseCallback<OUT> callback;
    //endregion

    //region Public interface
    public void run() {
        execute(requestParameters);
    }
    //endregion

    //region Getters and Setters
    public IN getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(final IN requestParameters) {
        this.requestParameters = requestParameters;
    }

    public IUseCaseCallback<OUT> getCallback() {
        return callback;
    }

    public void setCallback(final IUseCaseCallback<OUT> callback) {
        this.callback = callback;
    }
    //endregion
}
