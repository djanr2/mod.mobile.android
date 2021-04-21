package com.modulo.aplicaciones.moviles.activity.intent;

import android.app.Activity;
import android.os.Bundle;


public class AboutActivity extends Activity {
    /*De acuerdo al ciclo de vida de un actividad el método inicial que se ejecuta cuando
    * se inicia una clase de tipo Activity es onCreate()*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);
    }
}
