package com.pierre.test.speedrun.speedrun.features.speedruns.presenters;

import android.util.Log;

import com.pierre.test.speedrun.speedrun.features.common.BasePresenter;
import com.pierre.test.speedrun.speedrun.services.SpeedRunService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(games ->
                                Log.d("testtest", games.toString()),
                                throwable -> throwable.printStackTrace()
                );
        mDisposables.add(disposable);
    }
}
