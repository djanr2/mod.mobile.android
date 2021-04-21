package com.modulo.aplicaciones.moviles.activity.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button about_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about_button = (Button) findViewById(R.id.about_buttom);
        about_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchAbout();
            }
        });
    }

    public void launchAbout(){
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }
}