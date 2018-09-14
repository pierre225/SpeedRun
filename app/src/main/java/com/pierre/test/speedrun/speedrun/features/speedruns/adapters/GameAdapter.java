package com.pierre.test.speedrun.speedrun.features.speedruns.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pierre.test.speedrun.speedrun.R;
import com.pierre.test.speedrun.speedrun.model.game.ModelGame;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private List<ModelGame> mGames;

    public GameAdapter(List<ModelGame> mGames) {
        this.mGames = mGames;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.game_item, viewGroup, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder gameViewHolder, int position) {
        // Get the object at position
        ModelGame game = mGames.get(position);

        // Set the object information to the view
        gameViewHolder.mName.setText(game.getNames().getInternational());
        Picasso.get()
                .load(game.getAssets().getCover().getUri())
                .into(gameViewHolder.mCover);
    }

    @Override
    public int getItemCount() {
        return mGames.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private ImageView mCover;

        public GameViewHolder(View view) {
            super(view);

            mName = view.findViewById(R.id.game_item_name);
            mCover = view.findViewById(R.id.game_item_cover);
        }

    }
}
