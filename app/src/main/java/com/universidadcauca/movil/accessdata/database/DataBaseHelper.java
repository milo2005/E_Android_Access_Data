package com.universidadcauca.movil.accessdata.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.SensorManager;

/**
 * Created by DarioFernando on 07/05/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME="sistemasolar.db";
    static int version = 1;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+PlanetaDao.NAME+"("
                +PlanetaDao.ID+" INTEGER AUTO_INCREMENT PRIMARY KEY, "
                +PlanetaDao.C_NAME+" VARCHAR, "
                +PlanetaDao.C_GRAVITY+" FLOAT, "
                +PlanetaDao.C_POS+" INTEGER)"
               );

        ContentValues cV = new ContentValues();
        cV.put(PlanetaDao.C_NAME,"Tierra");
        cV.put(PlanetaDao.C_GRAVITY,9.8f);
        cV.put(PlanetaDao.C_POS, 3);

        db.insert(PlanetaDao.NAME, null, cV);

        cV = new ContentValues();
        cV.put(PlanetaDao.C_NAME, "Marte");
        cV.put(PlanetaDao.C_GRAVITY, SensorManager.GRAVITY_MARS);
        cV.put(PlanetaDao.C_POS, 4);

        db.insert(PlanetaDao.NAME, null, cV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+PlanetaDao.NAME);
        onCreate(db);
    }
}
