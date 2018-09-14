package com.pierre.test.speedrun.speedrun.features.speedruns.presenters;

import com.pierre.test.speedrun.speedrun.features.common.IView;
import com.pierre.test.speedrun.speedrun.model.game.ModelGame;

import java.util.List;

public interface IGameListActivity extends IView {

    void showLoader(boolean show);
    void showContent(Data data);

    class Data {
        public List<ModelGame> games;
    }
}
