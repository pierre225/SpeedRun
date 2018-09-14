package com.pierre.test.speedrun.speedrun.features.speedrun.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pierre.test.speedrun.speedrun.R;
import com.pierre.test.speedrun.speedrun.features.common.BaseActivity;
import com.pierre.test.speedrun.speedrun.features.speedrun.presenter.ISpeedRunActivity;
import com.pierre.test.speedrun.speedrun.features.speedrun.presenter.SpeedRunPresenter;
import com.pierre.test.speedrun.speedrun.model.game.ModelGame;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SpeedRunActivity extends BaseActivity implements ISpeedRunActivity {

    @BindView(R.id.speed_run_activity_game_name)
    TextView mGameName;

    @BindView(R.id.speed_run_activity_game_logo)
    ImageView mGameLogo;

    @BindView(R.id.speed_run_activity_run_time)
    TextView mRunTime;

    @BindView(R.id.speed_run_activity_video_button)
    Button mVideoButton;

    @BindView(R.id.speed_run_activity_user_name)
    TextView mUserName;

    @BindView(R.id.speed_run_activity_loader)
    ProgressBar mLoader;

    @BindView(R.id.speed_run_activity_retry_button)
    Button mRetryButton;

    public static final String MODEL_GAME = "MODEL_GAME";

    private SpeedRunPresenter mPresenter;

    public static Intent newIntent(Activity activity, ModelGame game) {
        Intent intent = new Intent(activity, SpeedRunActivity.class);
        intent.putExtra(MODEL_GAME, game);
        return intent;
    }

    // -- Region Lifecycle --

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_run);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        ModelGame game = getIntent().getParcelableExtra(MODEL_GAME);

        // Init presenter
        mPresenter = new SpeedRunPresenter(this, game);

        // Set the game data
        mGameName.setText(game.getNames().getInternational());
        Picasso.get().load(game.getAssets().getCover().getUri()).into(mGameLogo);

        mPresenter.onViewCreated();
    }

    // -- End Region Lifecycle --

    // -- Region Contract methods --

    @Override
    public void showContent(Data data) {
        if (data != null) {
            // Set the runtime
            mRunTime.setText(getString(R.string.speed_run_activity_run_time, data.speedRun.getTimes().getTime()));

            // Set the name or id of the first player
            String name = data.speedRun.getPlayers().get(0).getName();
            String nameOrId = name != null ? name : data.speedRun.getPlayers().get(0).getId();
            mUserName.setText(getString(R.string.speed_run_activity_user_name_label, nameOrId));
        }
    }

    @Override
    public void showLoader(boolean show) {
        int visibility = show ? View.VISIBLE : View.GONE;
        mLoader.setVisibility(visibility);
    }

    @Override
    public void showError(boolean show) {
        int visibility = show ? View.VISIBLE : View.GONE;
        mRetryButton.setVisibility(visibility);
    }

    // -- End Region Contract methods --

    // -- Region User interface --

    @OnClick(R.id.speed_run_activity_video_button)
    public void onVideoClicked() {
        mPresenter.videoClicked(this);
    }

    @OnClick(R.id.speed_run_activity_retry_button)
    public void onRetryClicked() {
        mPresenter.retryClicked();
    }

    // -- End Region User interface --
}
