package com.modulo.aplicaciones.moviles.activity.datamanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;

import static com.modulo.aplicaciones.moviles.activity.datamanager.KeyValueSharedPreference.MAIL;
import static com.modulo.aplicaciones.moviles.activity.datamanager.KeyValueSharedPreference.NOMBRE;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "FILE.txt";
    private static final String PREFERENCES = "PREFERENCIAS";
    private static  final String DELIM = ":";
    private EditText mail_;
    private EditText nombre_;
    private SharedPreferences sharedpreferences;
    private  DBManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail_ = (EditText) findViewById(R.id.mail_et);
        nombre_ = (EditText) findViewById(R.id.nombre_et);
        sharedpreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);

        db = new DBManager(this);
    }

    public void readSP(View view) {
        String nombre = sharedpreferences.getString(NOMBRE.toString(), "");
        String mail = sharedpreferences.getString(MAIL.toString(), "");
        mail_.setText(mail);
        nombre_.setText(nombre);

        Toast.makeText(MainActivity.this,"Datos Leidos: " +
                "Shared Preferenfes",Toast.LENGTH_LONG).show();
    }

    public void writeSP(View view) {

        String mail = mail_.getText().toString();
        String nombre = nombre_.getText().toString();
        sharedpreferences.edit().putString(NOMBRE.toString(), nombre).commit();
        sharedpreferences.edit().putString(MAIL.toString(), mail).commit();
        Toast.makeText(MainActivity.this,"Datos almacenados: " +
                "Shared Preferenfes",Toast.LENGTH_LONG).show();

    }

    public void readFile(View view) {
        String content="";
        StringTokenizer tk;
        try {
            InputStream inputStream = this.openFileInput(FILE_NAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                content = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        tk = new StringTokenizer(content, DELIM);

        mail_.setText(tk.nextToken());
        nombre_.setText(tk.nextToken());

        Toast.makeText(MainActivity.this,"Datos Leidos: " +
                "FILE",Toast.LENGTH_LONG).show();
    }

    public void writeFile(View view) {
        String mail = mail_.getText().toString();
        String nombre = nombre_.getText().toString();
        String fileContents = mail+DELIM+nombre;
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput(FILE_NAME, Context.MODE_PRIVATE));
            outputStreamWriter.write(fileContents);
            outputStreamWriter.close();
        }
        catch (IOException e) {
        }
        Toast.makeText(MainActivity.this,"Datos almacenados: " +
                "FILE",Toast.LENGTH_LONG).show();
    }

    public void readSQL(View view) {

        List<DataModel> allData = db.getAllData();
        for (DataModel data : allData) {
            String log = "Id: " + data.getPk() + " ,Name: " + data.getNombre() + " ,mail: " +
                    data.getMail();
            // Writing Contacts to log
            Log.d("<tag>", log);
        }
    }

    public void writeSQL(View view) {
        String mail = mail_.getText().toString();
        String nombre = nombre_.getText().toString();

        db.addData(new DataModel(mail, nombre));

        Toast.makeText(MainActivity.this,"Datos almacenados: " +
                "SQLite",Toast.LENGTH_LONG).show();

    }
}