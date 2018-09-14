package com.pierre.test.speedrun.speedrun.helpers;

import android.content.Intent;
import android.net.Uri;

public class IntentHelper {

    /**
     * Get an intent to play a video
     * @param uri the uri of the media that will be played
     *
     * return Intent
     */
    public static Intent getVideoIntent(String uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        return intent;
    }
}

