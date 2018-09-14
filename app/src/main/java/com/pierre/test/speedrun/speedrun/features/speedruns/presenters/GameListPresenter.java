package com.pierre.test.speedrun.speedrun.features.speedruns.presenters;

import android.util.Log;

import com.pierre.test.speedrun.speedrun.features.common.BasePresenter;
import com.pierre.test.speedrun.speedrun.services.SpeedRunService;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GameListPresenter extends BasePresenter<IGameListActivity> {

    private IGameListActivity.Data mData;

    public GameListPresenter(IGameListActivity mView) {
        super(mView);

        // Initialize the data
        mData = new IGameListActivity.Data();
        mData.games = new ArrayList<>();
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        loadGames();
    }

    public void retryClicked() {
        mView.showError(false);
        loadGames();
    }

    public void loadGames() {
        mView.showLoader(true);
        Disposable disposable = SpeedRunService.getGames()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(games -> {
                            mView.showLoader(false);
                            mData.games = games;
                            mView.showContent(mData);
                        },
                        throwable ->
                        {
                            mView.showLoader(false);
                            mView.showError(true);
                            throwable.printStackTrace();
                        }
                );
        mDisposables.add(disposable);
    }
}
