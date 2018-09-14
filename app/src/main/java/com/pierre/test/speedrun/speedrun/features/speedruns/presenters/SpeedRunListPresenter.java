package com.pierre.test.speedrun.speedrun.features.speedruns.presenters;

import android.util.Log;

import com.pierre.test.speedrun.speedrun.features.common.BasePresenter;
import com.pierre.test.speedrun.speedrun.services.SpeedRunService;

public class SpeedRunListPresenter extends BasePresenter<ISpeedRunListActivity> {

    public SpeedRunListPresenter(ISpeedRunListActivity mView) {
        super(mView);
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();


    }

    public void loadGames() {
        SpeedRunService.getGames()
                .subscribe();
    }
}
