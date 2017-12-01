package com.example.clinica.myapplication.UI.View.ObraSocial;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.clinica.myapplication.Controladores.ControladorObraSocial;
import com.example.clinica.myapplication.R;
import com.example.clinica.myapplication.UI.Adapters.ConfiguracionOSAdapter;
import com.example.clinica.myapplication.sqlite.BaseDeDatos;


public class ConfiguracionOS extends AppCompatActivity {

    BaseDeDatos db;
    RecyclerView osView;
    LinearLayout cancelar, actualizar;
    int contador;
    Context context;
    String nombre, est, cos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_os);
        context = ConfiguracionOS.this;

        db = new BaseDeDatos(context,null,null,1);
        osView = (RecyclerView) findViewById(R.id.configuracionOS);
        osView.setLayoutManager(new LinearLayoutManager(context));
        osView.setItemAnimator(new DefaultItemAnimator());
        ControladorObraSocial controlador = new ControladorObraSocial(context);
        final ConfiguracionOSAdapter adapter = new ConfiguracionOSAdapter(context, controlador.listaObraSocial());
        osView.setAdapter(adapter);
        adapter.nombre.clear();
        adapter.coseguro.clear();
        adapter.estado.clear();


        cancelar = (LinearLayout) findViewById(R.id.btnVolverGestionarOS);
        actualizar = (LinearLayout) findViewById(R.id.btnActualizarEstadoOS);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
            });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControladorObraSocial controlador = new ControladorObraSocial(context);

                contador = ((ConfiguracionOSAdapter)osView.getAdapter()).nombre.size();

                for (int i=0; i < contador; i++ ) {
                    nombre = adapter.nombre.get(i);
                    est = adapter.estado.get(i);
                    cos = adapter.coseguro.get(i);

                    controlador.setDatos(nombre, est, cos);
                    controlador.cargarDatos();
                }

                finish();
            }
        });
    }
    }

