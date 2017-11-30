package com.example.clinica.myapplication.UI.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clinica.myapplication.R;


/**
 * Created by Germanccho on 29/8/2017.
 */

public class ObraSocialHolder  extends RecyclerView.ViewHolder {


    public TextView nombreOS,  telefonoOS;
    public ImageView editarOS, eliminarOS;

    public ObraSocialHolder(View itemView) {
        super(itemView);
        this.nombreOS = (TextView) itemView.findViewById(R.id.txtNombreOS);
        this.telefonoOS = (TextView) itemView.findViewById(R.id.txtTelefonoOS);
        eliminarOS = (ImageView) itemView.findViewById(R.id.eliminarOS);
        editarOS = (ImageView) itemView.findViewById(R.id.edtOS);
    }
}