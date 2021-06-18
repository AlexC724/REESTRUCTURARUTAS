package com.example.reestructurarutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RUTA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);
    }

    public void agregarbtn(View view) {

        Intent agregar = new Intent(RUTA.this, ventana_agregar.class);
        startActivity(agregar);


    }
}