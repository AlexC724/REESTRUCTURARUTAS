package com.example.reestructurarutas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inicio_sesion(View view) {

        EditText contrasena = findViewById(R.id.contraseña);
        EditText usua = findViewById(R.id.usuario);
        String us = usua.getText().toString();
        String con = contrasena.getText().toString();
        if (us.contentEquals("admin") && con.contentEquals("123")){
            Intent i = new Intent(MainActivity.this, inicio_usuario.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Algun campo está vacio o el usuario no concuerda con los registros", Toast.LENGTH_SHORT).show();
        }

    }
}