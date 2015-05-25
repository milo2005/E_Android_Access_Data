package com.universidadcauca.movil.accessdata;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    static final String KEY_INFO ="info";

    TextView txt;
    Button btn;
    EditText edit;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.saved);
        btn = (Button) findViewById(R.id.btn);
        edit = (EditText) findViewById(R.id.edit);

        btn.setOnClickListener(this);

        preferences = getPreferences(MODE_PRIVATE);
        editor = preferences.edit();

        txt.setText(preferences.getString(KEY_INFO,""));
    }


    @Override
    public void onClick(View v) {
        String info = edit.getText().toString();
        editor.putString(KEY_INFO, info);
        editor.commit();

    }
}
