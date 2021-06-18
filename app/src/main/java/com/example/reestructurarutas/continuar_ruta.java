package com.example.reestructurarutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class continuar_ruta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuar_ruta);
    }

    public void entrarruta(View view) {

        Intent comenzar_ruta = new Intent(continuar_ruta.this, RUTA.class);
        startActivity(comenzar_ruta);
    }
}