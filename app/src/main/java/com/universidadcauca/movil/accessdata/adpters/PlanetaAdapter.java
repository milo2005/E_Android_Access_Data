package com.universidadcauca.movil.accessdata.adpters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.universidadcauca.movil.accessdata.R;
import com.universidadcauca.movil.accessdata.models.Planeta;

import java.util.List;

/**
 * Created by DarioFernando on 08/05/2015.
 */
public class PlanetaAdapter extends BaseAdapter {

    Context context;
    List<Planeta> data;

    public PlanetaAdapter(Context context, List<Planeta> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;

        if(convertView==null)
            v= View.inflate(context, R.layout.template_planeta, null);
        else
            v = convertView;

        Planeta p = (Planeta) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.txt_nombre);
        txt.setText(p.getNombre());

        txt = (TextView) v.findViewById(R.id.txt_gravedad);
        txt.setText(""+p.getGravedad());

        return v;
    }
}
