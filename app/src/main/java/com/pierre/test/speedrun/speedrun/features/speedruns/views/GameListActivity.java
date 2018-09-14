package com.pierre.test.speedrun.speedrun.features.speedruns.views;

import android.os.Bundle;

import com.pierre.test.speedrun.speedrun.R;
import com.pierre.test.speedrun.speedrun.features.common.BaseActivity;
import com.pierre.test.speedrun.speedrun.features.speedruns.presenters.IGameListActivity;
import com.pierre.test.speedrun.speedrun.features.speedruns.presenters.GameListPresenter;

public class GameListActivity extends BaseActivity implements IGameListActivity {

    private GameListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        // Init presenter
        mPresenter = new GameListPresenter(this);

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
