package com.example.clinica.myapplication.UI.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.clinica.myapplication.R;


/**
 * Created by Germanccho on 26/10/2017.
 */

public class ConfiguracionOSHolder extends RecyclerView.ViewHolder {


    public TextView nombreOS;
    public Spinner estado;
    public EditText coseguroOS;


    public ConfiguracionOSHolder(View itemView) {
        super(itemView);
        this.nombreOS = (TextView) itemView.findViewById(R.id.NombreOS);
        this.estado = (Spinner) itemView.findViewById(R.id.spEstadosOS);
        this.coseguroOS = (EditText) itemView.findViewById(R.id.CoseguroOS);




    }
}