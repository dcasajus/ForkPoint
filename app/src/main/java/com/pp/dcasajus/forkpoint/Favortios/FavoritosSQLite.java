package com.pp.dcasajus.forkpoint.Favortios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by denisplata on 02/03/2016.
 */
public class FavoritosSQLite extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Locals (codigo INTEGER, title TEXT, icon INT, carrer TEXT,preu TEXT)";

    public FavoritosSQLite(Context contexto, String nombre,
                                SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {

        db.execSQL("DROP TABLE IF EXISTS Locals");
        db.execSQL(sqlCreate);
    }
}