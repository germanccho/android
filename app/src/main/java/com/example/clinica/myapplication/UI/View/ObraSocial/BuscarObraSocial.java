package com.example.clinica.myapplication.UI.View.ObraSocial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.clinica.myapplication.Controladores.ControladorObraSocial;
import com.example.clinica.myapplication.R;
import com.example.clinica.myapplication.UI.Adapters.ObraSocialAdapter;


public class BuscarObraSocial extends AppCompatActivity {

    SearchView sv;
    RecyclerView osView;
    LinearLayout volver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_obra_social);

        volver = (LinearLayout) findViewById(R.id.btnVolverGestionarOSBuscar);
        sv = (SearchView) findViewById(R.id.buscarOS);
        osView = (RecyclerView) findViewById(R.id.listaOS);
        osView.setLayoutManager(new LinearLayoutManager(this));
        osView.setItemAnimator(new DefaultItemAnimator());
        ControladorObraSocial controlador = new ControladorObraSocial(BuscarObraSocial.this);
        final ObraSocialAdapter adapter = new ObraSocialAdapter(this, controlador.listaObraSocial());
        osView.setAdapter(adapter);


        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
