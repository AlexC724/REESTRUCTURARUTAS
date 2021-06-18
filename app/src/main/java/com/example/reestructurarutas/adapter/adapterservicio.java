package com.example.reestructurarutas.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reestructurarutas.R;
import com.example.reestructurarutas.pojo.servicio;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class adapterservicio extends RecyclerView.Adapter<adapterservicio.viewholderservicio> {

    android.content.Context context;
    ArrayList<servicio> servicioList;
    ArrayList<servicio> listaoriginal;


    public adapterservicio(ArrayList<servicio> servicioList) {

        this.servicioList = servicioList;
        listaoriginal = new ArrayList<>();
        listaoriginal.addAll(servicioList);

    }

    public void filtrado(String searcho) {
        ArrayList<servicio> filtrada = new ArrayList<>();
        if (searcho.length() == 0) {
            filtrada.addAll(servicioList);

        } else {
            for (servicio i : servicioList) {
                if (i.getMedidor().toLowerCase().contains(searcho)) {
                    filtrada.add(i);

                }
                servicioList = filtrada;
            }

        }
        notifyDataSetChanged();

    }


    @NotNull
    @Override
    public viewholderservicio onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_servicio, parent, false);
        viewholderservicio holder = new viewholderservicio(v);


        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewholderservicio holder, int position) {

        servicio sr = servicioList.get(position);

        holder.textviewmedidor.setText(sr.getMedidor());
        holder.textviewrpu.setText(sr.getRpu());
        holder.textviewnombre.setText(sr.getNombre());
        holder.textviewdireccion.setText(sr.getDireccion());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Titulo");
                builder.setMessage("¿Quieres agregar como siguiente servicio?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context.getApplicationContext(),"Agregado a lista...",Toast.LENGTH_SHORT).show();

                                
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context.getApplicationContext(),"Cancel...",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(false)
                        .show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return servicioList.size();
    }


    public class viewholderservicio extends RecyclerView.ViewHolder {

        TextView textviewmedidor, textviewrpu, textviewnombre, textviewdireccion;


        public viewholderservicio(@NonNull View itemView) {
            super(itemView);

            textviewmedidor = itemView.findViewById(R.id.textviewmedidor);
            textviewrpu = itemView.findViewById(R.id.textviewrpu);
            textviewnombre = itemView.findViewById(R.id.textviewnombre);
            textviewdireccion = itemView.findViewById(R.id.textviewdireccion);


        }
    }

}
