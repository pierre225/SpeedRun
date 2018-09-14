package com.pierre.test.speedrun.speedrun.features.common;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<T extends IView> {

    protected T mView;

    protected CompositeDisposable mDisposables = new CompositeDisposable();

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public void onViewCreated() {}

    public void onViewResumed() {}

    public void onViewPaused() {}

    public void onViewDestroyed() {
        mDisposables.dispose();
    }
}
