package com.example.reestructurarutas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class inicio_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_usuario);
    }

    public void continuar_ruta(View view) {
        Intent continuar_ruta = new Intent(inicio_usuario.this, RUTA.class);
        startActivity(continuar_ruta);


    }

    public void comenzar_rutabtn(View view) {
        Intent comenzar_ruta = new Intent(inicio_usuario.this, comenzar_ruta.class);
        startActivity(comenzar_ruta);


    }

    public void cerrarsesionUsusario(View view) {
        Intent cerrar_sesion = new Intent(inicio_usuario.this, MainActivity.class);
        startActivity(cerrar_sesion);
        finish();

    }
}