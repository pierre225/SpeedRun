package com.pierre.test.speedrun.speedrun.features.speedruns.presenters;

import com.pierre.test.speedrun.speedrun.features.common.BasePresenter;
import com.pierre.test.speedrun.speedrun.services.SpeedRunService;

import io.reactivex.disposables.Disposable;

public class SpeedRunListPresenter extends BasePresenter<ISpeedRunListActivity> {

    public SpeedRunListPresenter(ISpeedRunListActivity mView) {
        super(mView);
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        loadGames();
    }

    public void loadGames() {
        Disposable disposable = SpeedRunService.getGames()
                .subscribe();
        mDisposables.add(disposable);
    }
}
