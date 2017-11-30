package com.example.clinica.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.clinica.myapplication.UI.View.ObraSocial.BuscarObraSocial;
import com.example.clinica.myapplication.UI.View.ObraSocial.ConfiguracionOS;
import com.example.clinica.myapplication.UI.View.ObraSocial.agregarObraSocial;


public class Gestionar_OS extends AppCompatActivity {


LinearLayout agregar, buscar, configuracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_os);

        agregar = (LinearLayout) findViewById(R.id.agregarOS);
        buscar = (LinearLayout) findViewById(R.id.btnBuscarOS);
        configuracion = (LinearLayout) findViewById(R.id.btnConfiguracionOS);



        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agregar = new Intent(Gestionar_OS.this, agregarObraSocial.class);
                startActivity(agregar);

            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buscar = new Intent(Gestionar_OS.this, BuscarObraSocial.class);
                startActivity(buscar);

            }
        });


        configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent config = new Intent(Gestionar_OS.this, ConfiguracionOS.class);
                startActivity(config);

            }
        });


    }
}
