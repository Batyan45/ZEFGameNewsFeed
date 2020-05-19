package com.batyan.zefgame.modules.common;

public interface IBaseView<T extends IBasePresenter> {

    void setPresenter(final T presenter);
}
