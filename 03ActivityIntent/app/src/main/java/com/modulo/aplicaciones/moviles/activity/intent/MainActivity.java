package com.modulo.aplicaciones.moviles.activity.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {

    private Button about_button;
    private Button camera_button;
    private Button contact_button;
    private Button phone_button;
    private Button message_button;
    private final static int camera_id = 123456789;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about_button = (Button) findViewById(R.id.about_buttom);
        camera_button = (Button) findViewById(R.id.camera_buttom);
        contact_button = (Button) findViewById(R.id.contact_buttom);
        message_button = (Button) findViewById(R.id.message_buttom);
        phone_button = (Button) findViewById(R.id.phone_buttom);


        about_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchAbout();
            }
        });

        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchCamera();
            }
        });

        contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchContact();
            }
        });

        message_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMessage();
            }
        });

        phone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchPhone();
            }
        });
    }

    public void launchAbout(){
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }

    public void launchCamera(){
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(camera_intent);
    }

    public void launchContact(){
        Intent contact_intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivity(contact_intent);
    }

    public void launchMessage(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(intent);
    }

    public void launchPhone(){
        Intent phone_intent = new Intent(Intent.ACTION_CALL);
        phone_intent.setData(Uri.parse("tel:5556581111"));
        startActivity(phone_intent);
    }


}