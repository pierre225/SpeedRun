package com.pierre.test.speedrun.speedrun.features.speedrun.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pierre.test.speedrun.speedrun.R;
import com.pierre.test.speedrun.speedrun.features.common.BaseActivity;
import com.pierre.test.speedrun.speedrun.features.speedrun.presenter.ISpeedRunActivity;
import com.pierre.test.speedrun.speedrun.features.speedrun.presenter.SpeedRunPresenter;

public class SpeedRunActivity extends BaseActivity implements ISpeedRunActivity {

    public static final String SPEED_RUN_ID = "SPEED_RUN_ID";

    private SpeedRunPresenter mPresenter;

    public static Intent newIntent(Activity activity, String speedRunId) {
        Intent intent = new Intent(activity, SpeedRunActivity.class);
        intent.putExtra(SPEED_RUN_ID, speedRunId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_run);

        String speedRunId = getIntent().getStringExtra(SPEED_RUN_ID);

        // Init presenter
        mPresenter = new SpeedRunPresenter(this, speedRunId);


        mPresenter.onViewCreated();
    }
}
