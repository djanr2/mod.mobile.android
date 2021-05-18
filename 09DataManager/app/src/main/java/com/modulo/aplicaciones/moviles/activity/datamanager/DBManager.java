package com.modulo.aplicaciones.moviles.activity.datamanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "SIMPLEDB";
    private static final String TABLE_NAME = "DATA";
    private static final String PK_ID = "id";
    private static final String PK_NAME = "name";
    private static final String PK_MAIL = "mail";


    public DBManager(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DATA_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + PK_ID + " INTEGER PRIMARY KEY," + PK_MAIL + " TEXT,"
                + PK_NAME + " TEXT" + ")";
        db.execSQL(CREATE_DATA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void addData(DataModel data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PK_MAIL, data.getMail());
        values.put(PK_NAME, data.getNombre());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public DataModel getData(int pk_id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { PK_ID,
                        PK_MAIL, PK_NAME }, PK_ID + "=?",
                new String[] { String.valueOf(pk_id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DataModel dataModel = new DataModel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return dataModel;
    }

    public List<DataModel> getAllData(){
        List<DataModel> allData = new ArrayList<DataModel>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                DataModel contact = new DataModel();
                contact.setPk(Integer.parseInt(cursor.getString(0)));
                contact.setMail(cursor.getString(1));
                contact.setNombre(cursor.getString(2));
                allData.add(contact);
            } while (cursor.moveToNext());
        }

        return allData;
    }

    public int updateData(DataModel data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PK_MAIL, data.getMail());
        values.put(PK_NAME, data.getNombre());

        return db.update(TABLE_NAME, values, PK_ID + " = ?",
                new String[] { String.valueOf(data.getPk())});
    }

    public void deleteData(DataModel data) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, PK_ID + " = ?",
                new String[] { String.valueOf(data.getPk()) });
        db.close();
    }

    public int getNumberElements() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}
