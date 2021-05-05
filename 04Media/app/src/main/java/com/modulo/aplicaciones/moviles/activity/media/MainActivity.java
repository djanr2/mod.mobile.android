package com.modulo.aplicaciones.moviles.activity.media;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.modulo.aplicaciones.moviles.activity.media.activity.ImageActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openVideo(View view) {
        // Do something in response to button click
    }

    public void openImage(View view) {
        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }

    public void openAudio(View view) {
        // Do something in response to button click
    }

}