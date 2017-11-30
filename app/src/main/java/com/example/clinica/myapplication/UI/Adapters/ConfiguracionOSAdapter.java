package com.example.clinica.myapplication.UI.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.clinica.myapplication.DTO.ObraSocial;
import com.example.clinica.myapplication.R;
import com.example.clinica.myapplication.UI.Holders.ConfiguracionOSHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Germanccho on 26/10/2017.
 */

public class ConfiguracionOSAdapter extends RecyclerView.Adapter<ConfiguracionOSHolder> implements Filterable {

    Context c;
    public ArrayList<ObraSocial> OS, listaFiltrada;
    FiltroConfiguracionOS filtro;


    public List<String> coseguro = new ArrayList<>();
    public List<String> estado = new ArrayList<>();
    public List<String> nombre = new ArrayList<>();




    public ConfiguracionOSAdapter(Context ctx, ArrayList<ObraSocial> OS){
        this.c=ctx;
        this.OS=OS;
        this.listaFiltrada=OS;


    }


    @Override
    public ConfiguracionOSHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_configuracion_os,null);

        //HOLDER
        ConfiguracionOSHolder holder=new ConfiguracionOSHolder(v);
        return holder;


    }

    @Override
    public void onBindViewHolder(final ConfiguracionOSHolder holder, int position) {

        holder.nombreOS.setText(OS.get(position).getNombre());
        holder.estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                nombre.add(holder.nombreOS.getText().toString());
                estado.add(holder.estado.getSelectedItem().toString());


                if (position == 1) {
                    holder.coseguroOS.setEnabled(true);


                }else {
                    holder.coseguroOS.setText("");
                    holder.coseguroOS.setEnabled(false);

                }
                }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        holder.coseguroOS.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                coseguro.add(holder.coseguroOS.getText().toString());

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });
    }


    @Override
    public int getItemCount() {
        return OS.size();
    }

    @Override
    public Filter getFilter() {
        if (filtro==null){
            filtro = new FiltroConfiguracionOS(listaFiltrada, this);
        }
        return filtro;
    }

}


