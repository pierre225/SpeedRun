package com.pierre.test.speedrun.speedrun.features.speedrun.presenter;

import android.util.Log;

import com.pierre.test.speedrun.speedrun.features.common.BasePresenter;
import com.pierre.test.speedrun.speedrun.model.game.ModelGame;
import com.pierre.test.speedrun.speedrun.services.SpeedRunService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SpeedRunPresenter extends BasePresenter<ISpeedRunActivity> {

    private ModelGame mGame;

    private ISpeedRunActivity.Data mData;

    public SpeedRunPresenter(ISpeedRunActivity mView, ModelGame game) {
        super(mView);
        this.mGame = game;
        mData = new ISpeedRunActivity.Data();
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        // Load speedRun when launching the activity
        loadSpeedruns(mGame.getId());
    }

    private void loadSpeedruns(@NonNull String gameId) {
        mView.showLoader(true);
        Disposable disposable = SpeedRunService.getSpeedruns(gameId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(speedRuns -> {
                    mView.showLoader(false);
                    // We only want to show the first speed run
                    mData.speedRun = speedRuns.get(0);
                    mView.showContent(mData);
                },
                        throwable -> {
                    mView.showLoader(false);
                    throwable.printStackTrace();
                        });
        mDisposables.add(disposable);
    }
}
