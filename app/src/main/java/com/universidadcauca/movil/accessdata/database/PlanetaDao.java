package com.universidadcauca.movil.accessdata.database;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.universidadcauca.movil.accessdata.models.Planeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarioFernando on 07/05/2015.
 */
public class PlanetaDao {
    public static final String NAME="planeta";
    public static final String ID="_id";
    public static final String C_NAME="nombre";
    public static final String C_GRAVITY="gravedad";
    public static final String C_POS="posicion";

    SQLiteDatabase db;

    public PlanetaDao(Context context){
        DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insertPlaneta(Planeta planeta){
        ContentValues cV = new ContentValues();
        cV.put(C_NAME, planeta.getNombre());
        cV.put(C_GRAVITY, planeta.getGravedad());
        cV.put(C_POS, planeta.getPos());

        planeta.setId((int)db.insert(NAME, null, cV));
    }


    public void updatePlaneta(Planeta planeta){
        ContentValues cV = new ContentValues();
        cV.put(C_NAME, planeta.getNombre());
        cV.put(C_GRAVITY, planeta.getGravedad());
        cV.put(C_POS, planeta.getPos());

        db.update(NAME, cV, ID + "=" + planeta.getId(), null);


    }

    public void deletePlaneta(Planeta planeta){
        db.delete(NAME, ID + "=" + planeta.getId(), null);
    }

    public Planeta getPlanetaById(int id){
        String sql="SELECT * FROM "+NAME+" WHERE "+ID+"="+id;

        Planeta p = null;

        Cursor c = db.rawQuery(sql, null);
        if(c.getCount()>0){

            c.moveToNext();
            p= new Planeta();

            p.setId(c.getInt(0));
            p.setNombre(c.getString(1));
            p.setGravedad(c.getFloat(2));
            p.setPos(c.getInt(3));

        }
        return  p;
    }

    public List<Planeta> getAllPlanetas(){
        List<Planeta> data = new ArrayList<>();
        String sql = "SELECT * FROM "+NAME;

        Cursor c = db.rawQuery(sql, null);
        for (int i=0;i<c.getCount();i++){
            c.moveToPosition(i);
            Planeta p= new Planeta();

            p.setId(c.getInt(0));
            p.setNombre(c.getString(1));
            p.setGravedad(c.getFloat(2));
            p.setPos(c.getInt(3));
            data.add(p);
        }
        return data;
    }

    public List<Planeta> getAllPlanetasByNombre(String nombre){
        List<Planeta> data = new ArrayList<>();
        String sql = "SELECT * FROM "+NAME+" WHERE "+C_NAME+" LIKE '%"+nombre+"%'";

        Cursor c = db.rawQuery(sql, null);
        for (int i=0;i<c.getCount();i++){
            c.moveToPosition(i);
            Planeta p= new Planeta();

            p.setId(c.getInt(0));
            p.setNombre(c.getString(1));
            p.setGravedad(c.getFloat(2));
            p.setPos(c.getInt(3));
            data.add(p);
        }
        return data;
    }
}
