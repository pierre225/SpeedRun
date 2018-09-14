package com.pierre.test.speedrun.speedrun.features.speedrun.presenter;

import com.pierre.test.speedrun.speedrun.features.common.IView;
import com.pierre.test.speedrun.speedrun.model.speedrun.ModelSpeedRun;

public interface ISpeedRunActivity extends IView {

    // -- Region Contract methods --
    void showContent(Data data);
    void showLoader(boolean show);
    void showError(boolean show);

    // -- Region Contract data --
    class Data {
        public ModelSpeedRun speedRun;
    }
}
