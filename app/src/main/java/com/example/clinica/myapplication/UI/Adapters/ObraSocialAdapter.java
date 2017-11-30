package com.example.clinica.myapplication.UI.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import com.example.clinica.myapplication.DTO.ObraSocial;
import com.example.clinica.myapplication.R;
import com.example.clinica.myapplication.UI.Holders.ObraSocialHolder;
import com.example.clinica.myapplication.UI.View.ObraSocial.EditarObraSocial;
import com.example.clinica.myapplication.sqlite.BaseDeDatos;
import com.example.clinica.myapplication.sqlite.Tablas;

import java.util.ArrayList;


/**
 * Created by Germanccho on 28/8/2017.
 */

public class ObraSocialAdapter extends RecyclerView.Adapter<ObraSocialHolder> implements Filterable {

    Context c;
    ArrayList<ObraSocial> obraSocial;
    ArrayList<ObraSocial> listaOSFiltrada;
    BaseDeDatos db;
    FiltroOS filtro;


    public ObraSocialAdapter(Context ctx, ArrayList<ObraSocial> obraSocial){
        this.c=ctx;
        this.obraSocial=obraSocial;
        this.listaOSFiltrada=obraSocial;


    }


    @Override
    public ObraSocialHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_os,null);

        //HOLDER
        ObraSocialHolder holder=new ObraSocialHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ObraSocialHolder holder, int position) {
        final ObraSocial s = obraSocial.get(position);
        holder.nombreOS.setText(obraSocial.get(position).getNombre());
        holder.telefonoOS.setText(obraSocial.get(position).getTelefono());


        holder.eliminarOS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle(" - Confirmar - ");
                builder.setMessage("Estas seguro que deseas eliminar esta Obra Social de la lista ?");
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        eliminarOS(Integer.parseInt(s.getCuil()));
                        ((Activity)c).finish();
                        c.startActivity(((Activity) c).getIntent());
                        dialog.dismiss();
                        Toast.makeText(c, "La Obra Social se ha sido eliminado de la lista!!", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        holder.editarOS.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(c, EditarObraSocial.class);
                i.putExtra("cuil", s.getCuil());
                c.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return obraSocial.size();
    }

    @Override
    public Filter getFilter() {
        if (filtro==null){
            filtro = new FiltroOS(listaOSFiltrada, this);
        }
        return filtro;
    }

    public void eliminarOS(int cuil) {
        BaseDeDatos conn = new BaseDeDatos(c,null,null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        db.execSQL("DELETE FROM " + Tablas.TABLA_OS + " WHERE " + Tablas.COLUMNA_CUIL_OS + " = " + cuil + ";");
        db.close();
    }
}
