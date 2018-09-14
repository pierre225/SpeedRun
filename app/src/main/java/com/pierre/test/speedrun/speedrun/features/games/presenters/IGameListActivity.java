package com.pierre.test.speedrun.speedrun.features.games.presenters;

import com.pierre.test.speedrun.speedrun.features.common.IView;
import com.pierre.test.speedrun.speedrun.model.game.ModelGame;

import java.util.List;

public interface IGameListActivity extends IView {

    // -- Region Contract methods --
    void showLoader(boolean show);
    void showContent(Data data);
    void showError(boolean show);
    void gameSelected(ModelGame gameSelected);

    // -- Region Contract data --
    class Data {
        public List<ModelGame> games;
    }
}
