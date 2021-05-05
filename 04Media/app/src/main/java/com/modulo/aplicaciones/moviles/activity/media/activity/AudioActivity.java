package com.modulo.aplicaciones.moviles.activity.media.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


import com.modulo.aplicaciones.moviles.activity.media.R;


public class AudioActivity extends Activity {
    private MediaPlayer mp;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        mp = MediaPlayer.create(this, R.raw.yolo);
    }

    public void stopAudio(View view){
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    public void startAudio(View view){
        mp.start();
    }
}
