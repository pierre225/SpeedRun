package com.pierre.test.speedrun.speedrun.features.speedruns.views;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.pierre.test.speedrun.speedrun.R;
import com.pierre.test.speedrun.speedrun.features.common.BaseActivity;
import com.pierre.test.speedrun.speedrun.features.speedruns.adapters.GameAdapter;
import com.pierre.test.speedrun.speedrun.features.speedruns.presenters.IGameListActivity;
import com.pierre.test.speedrun.speedrun.features.speedruns.presenters.GameListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameListActivity extends BaseActivity implements IGameListActivity {

    @BindView(R.id.game_list_activity_recycler_view)
    RecyclerView mGamesRecyclerView;

    @BindView(R.id.game_list_activity_progress_bar)
    ProgressBar mLoader;

    private GameListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        getSupportActionBar().hide();

        // Init views
        ButterKnife.bind(this);

        // Init presenter
        mPresenter = new GameListPresenter(this);

        // Recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mGamesRecyclerView.setLayoutManager(layoutManager);
        mGamesRecyclerView.setHasFixedSize(true);

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

    @Override
    public void showLoader(boolean show) {
        int visibility = show ? View.VISIBLE : View.GONE;
        mLoader.setVisibility(visibility);
    }

    @Override
    public void showContent(Data data) {
        GameAdapter adapter = new GameAdapter(data.games);
        mGamesRecyclerView.setAdapter(adapter);
    }
}
