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

    public SpeedRunPresenter(ISpeedRunActivity mView, ModelGame game) {
        super(mView);
        this.mGame = game;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        // Load speedRun
        loadSpeedruns(mGame.getId());
    }

    private void loadSpeedruns(@NonNull String gameId) {
        Disposable disposable = SpeedRunService.getSpeedruns(gameId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(speedRuns -> {
                            Log.d("testtest", "test");
                },
                        throwable -> throwable.printStackTrace());
        mDisposables.add(disposable);
    }
}
