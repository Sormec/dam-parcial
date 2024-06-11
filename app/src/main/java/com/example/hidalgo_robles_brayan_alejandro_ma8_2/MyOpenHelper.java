package com.example.hidalgo_robles_brayan_alejandro_ma8_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {
    public static final String usuario = "CREATE TABLE usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "cedula TEXT," +
            "apellidosnombres TEXT," +
            "ratingusuario FLOAT)";
    public static final String dbName = "ecualingo.sqlite";
    public static final int dbversion = 1;

    public MyOpenHelper(Context context){
        super(context, dbName, null, dbversion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
