package com.pierre.test.speedrun.speedrun.features.speedruns.views;

import android.os.Bundle;

import com.pierre.test.speedrun.speedrun.R;
import com.pierre.test.speedrun.speedrun.features.common.BaseActivity;
import com.pierre.test.speedrun.speedrun.features.speedruns.presenters.ISpeedRunListActivity;
import com.pierre.test.speedrun.speedrun.features.speedruns.presenters.SpeedRunListPresenter;

public class SpeedRunListActivity extends BaseActivity implements ISpeedRunListActivity {

    private SpeedRunListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_run_list);

        // Init presenter
        mPresenter = new SpeedRunListPresenter(this);

        mPresenter.onViewCreated();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onViewResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onViewPaused();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onViewDestroyed();
    }
}
