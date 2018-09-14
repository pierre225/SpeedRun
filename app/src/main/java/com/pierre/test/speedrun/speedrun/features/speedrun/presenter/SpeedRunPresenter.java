package com.pierre.test.speedrun.speedrun.features.speedrun.presenter;

import android.util.Log;

import com.pierre.test.speedrun.speedrun.features.common.BasePresenter;
import com.pierre.test.speedrun.speedrun.services.SpeedRunService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SpeedRunPresenter extends BasePresenter<ISpeedRunActivity> {

    private String mGameId;

    public SpeedRunPresenter(ISpeedRunActivity mView, String gameId) {
        super(mView);
        this.mGameId = gameId;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        // Load speedRun
        loadSpeedruns(mGameId);
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
