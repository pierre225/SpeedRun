package com.pierre.test.speedrun.speedrun.features.speedrun.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pierre.test.speedrun.speedrun.R;
import com.pierre.test.speedrun.speedrun.features.common.BaseActivity;
import com.pierre.test.speedrun.speedrun.features.speedrun.presenter.ISpeedRunActivity;
import com.pierre.test.speedrun.speedrun.features.speedrun.presenter.SpeedRunPresenter;
import com.pierre.test.speedrun.speedrun.model.game.ModelGame;

public class SpeedRunActivity extends BaseActivity implements ISpeedRunActivity {

    public static final String MODEL_GAME = "MODEL_GAME";

    private SpeedRunPresenter mPresenter;

    public static Intent newIntent(Activity activity, ModelGame game) {
        Intent intent = new Intent(activity, SpeedRunActivity.class);
        intent.putExtra(MODEL_GAME, game);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_run);

        ModelGame game = (ModelGame) getIntent().getParcelableExtra(MODEL_GAME);

        // Init presenter
        mPresenter = new SpeedRunPresenter(this, game);


        mPresenter.onViewCreated();
    }
}
