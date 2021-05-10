package com.modulo.aplicaciones.moviles.activity.hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_task;
    ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress_bar = (ProgressBar) findViewById(R.id.progress_task);
        button_task = (Button) findViewById(R.id.start_task);
        button_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress_bar.setVisibility(View.VISIBLE);
                new Hilo().start();
            }
        });
    }

    class Hilo extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Proceso terminado", Toast.LENGTH_SHORT).show();
                        progress_bar.setVisibility(View.INVISIBLE);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}