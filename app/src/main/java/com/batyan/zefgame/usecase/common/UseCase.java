package com.batyan.zefgame.usecase.common;

public abstract class UseCase<IN extends UseCase.IRequestValues,
        OUT extends UseCase.IResponseValues> {

    protected abstract void execute(final IN requestParameters);

    public interface IRequestValues {
    }

    public interface IResponseValues {
    }

    public interface IUseCaseCallback<T> {
        void onSuccess(final T response);

        void onError(final String errorMessage);
    }

    private IN requestParameters;
    private IUseCaseCallback<OUT> callback;

    public void run() {
        execute(requestParameters);
    }

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
}
