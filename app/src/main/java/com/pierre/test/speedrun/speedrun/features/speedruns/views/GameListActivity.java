package com.pierre.test.speedrun.speedrun.features.speedruns.views;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.pierre.test.speedrun.speedrun.R;
import com.pierre.test.speedrun.speedrun.features.common.BaseActivity;
import com.pierre.test.speedrun.speedrun.features.speedruns.adapters.GameAdapter;
import com.pierre.test.speedrun.speedrun.features.speedruns.presenters.IGameListActivity;
import com.pierre.test.speedrun.speedrun.features.speedruns.presenters.GameListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameListActivity extends BaseActivity implements IGameListActivity {

    @BindView(R.id.game_list_activity_recycler_view)
    RecyclerView mGamesRecyclerView;

    @BindView(R.id.game_list_activity_progress_bar)
    ProgressBar mLoader;

    @BindView(R.id.game_list_activity_retry_button)
    Button mRetryButton;

    private GameListPresenter mPresenter;

    // -- Region Lifecycle --

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

    // -- End Region Lifecycle --

    // -- Region Contract methods --

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

    @Override
    public void showError(boolean show) {
        int visibility = show ? View.VISIBLE : View.GONE;
        mRetryButton.setVisibility(visibility);
    }

    // -- End Region Contract methods --

    // -- Region User input --

    @OnClick(R.id.game_list_activity_retry_button)
    public void onRetryClicked() {
        mPresenter.retryClicked();
    }

    // -- End Region User input --
}
