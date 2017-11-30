package com.example.clinica.myapplication.UI.Adapters;

import android.widget.Filter;

import com.example.clinica.myapplication.DTO.ObraSocial;

import java.util.ArrayList;

/**
 * Created by Germanccho on 30/8/2017.
 */

public class FiltroOS extends Filter {


    ObraSocialAdapter adapter;
    ConfiguracionOSAdapter adapte;
    ArrayList<ObraSocial> listaOSFiltrada;

    public FiltroOS(ArrayList<ObraSocial> listaOSFiltrada, ObraSocialAdapter adapter){
        this.adapter=adapter;
        this.listaOSFiltrada=listaOSFiltrada;
    }

    public FiltroOS(ArrayList<ObraSocial> listaOSFiltrada, ConfiguracionOSAdapter adapte){
        this.adapte=adapte;
        this.listaOSFiltrada=listaOSFiltrada;
    }




    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults r = new FilterResults();
        if (constraint != null && constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ObraSocial> filtroOS = new ArrayList<>();
            for (int i=0; i< listaOSFiltrada.size();i++){
                if (listaOSFiltrada.get(i).getNombre().toUpperCase().contains(constraint) || listaOSFiltrada.get(i).getCuil().toUpperCase().contains(constraint)){
                    filtroOS.add(listaOSFiltrada.get(i));
                }
            }
            r.count=filtroOS.size();
            r.values=filtroOS;
        }else{
            r.count=listaOSFiltrada.size();
            r.values=listaOSFiltrada;
        }
        return r;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults r) {
        adapter.obraSocial = (ArrayList<ObraSocial>) r.values;
        adapter.notifyDataSetChanged();
        adapte.OS = (ArrayList<ObraSocial>) r.values;
        adapte.notifyDataSetChanged();

    }
    }

