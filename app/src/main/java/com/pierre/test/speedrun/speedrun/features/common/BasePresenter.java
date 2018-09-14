package com.pierre.test.speedrun.speedrun.features.common;

public abstract class BasePresenter<T extends IView> {

    protected T mView;

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public void onViewCreated() {}

    public void onViewResumed() {}

    public void onViewPaused() {}

    public void onViewDestroyed() {}
}
