package com.universidadcauca.movil.accessdata;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.universidadcauca.movil.accessdata.adpters.PlanetaAdapter;
import com.universidadcauca.movil.accessdata.database.PlanetaDao;
import com.universidadcauca.movil.accessdata.models.Planeta;

import java.util.List;


public class PlanetasActivity extends ActionBarActivity {

    ListView list;
    List<Planeta> data;
    PlanetaAdapter adater;

    PlanetaDao planetaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planetas);

        list = (ListView) findViewById(R.id.list);
        planetaDao = new PlanetaDao(this);

        data = planetaDao.getAllPlanetas();

        adater = new PlanetaAdapter(this, data);

        list.setAdapter(adater);


    }

    @Override
    protected void onRestart() {
        super.onRestart();

        data = planetaDao.getAllPlanetas();
        adater.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_planetas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
