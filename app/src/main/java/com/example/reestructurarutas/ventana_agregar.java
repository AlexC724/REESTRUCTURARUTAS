package com.example.reestructurarutas;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reestructurarutas.adapter.adapterservicio;
import com.example.reestructurarutas.pojo.servicio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ventana_agregar extends AppCompatActivity implements SearchView.OnQueryTextListener {

    DatabaseReference ref;
    ArrayList<servicio> list;
    RecyclerView rv;
    SearchView searcho;
    adapterservicio adapter;

    LinearLayoutManager lm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_agregar);

        rv = findViewById(R.id.rv);
        ref = FirebaseDatabase.getInstance().getReference("ServiciosBD");
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new adapterservicio(list);
        rv.setAdapter(adapter);

        searcho = findViewById(R.id.searchview);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    servicio ser = dataSnapshot.getValue(servicio.class);
                    list.add(ser);

                    Toast.makeText(ventana_agregar.this, "Started BD", Toast.LENGTH_LONG).show();

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        searcho.setOnQueryTextListener(this);

    }

    private void buscar(String s) {

        ArrayList<servicio> milista = new ArrayList<>();


        for (servicio obj : list) {
            if (obj.getMedidor().toUpperCase().contains(s.toLowerCase())) {
                milista.add(obj);
            }
        }
        adapterservicio adapterservicio = new adapterservicio(milista);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filtrado(newText);
        return false;
    }
}