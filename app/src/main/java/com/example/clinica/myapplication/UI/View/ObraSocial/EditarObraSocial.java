package com.example.clinica.myapplication.UI.View.ObraSocial;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.clinica.myapplication.Controladores.ControladorObraSocial;
import com.example.clinica.myapplication.DTO.ObraSocial;
import com.example.clinica.myapplication.R;
import com.example.clinica.myapplication.sqlite.BaseDeDatos;


public class EditarObraSocial extends AppCompatActivity {

    EditText nombre, cuil, direccion, telefono, email;
    LinearLayout volver, actualizar;
    BaseDeDatos db;
    Context context;
    String idglobal;
    public ObraSocial os, OS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_obra_social);

        nombre = (EditText) findViewById(R.id.edtNombreOS);
        cuil = (EditText) findViewById(R.id.edtCuilOS);
        direccion = (EditText) findViewById(R.id.edtDireccionOS);
        telefono = (EditText) findViewById(R.id.edtTelefonoOS);
        email = (EditText) findViewById(R.id.edtEmailOS);
        volver = (LinearLayout) findViewById(R.id.btnVolverGestionarOS);
        actualizar = (LinearLayout) findViewById(R.id.btnEdtActualizarOS);
        context = EditarObraSocial.this;
        getObraSocial();



        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControladorObraSocial controlador = new ControladorObraSocial(context);

                if (validarCampos() == true){
                    os = setObraSocial();
                    controlador.OSporCuil(Long.parseLong(idglobal));
                    controlador.actualizarOS(os);
                    confirmacion();
                    finish();
                }else
                {
                    errorCampoIncompleto();
                }
            }
        });
    }


    public void getObraSocial(){
        db = new BaseDeDatos(this,null,null,1);
        ControladorObraSocial controlador = new ControladorObraSocial(context);
        Intent i = getIntent();
        String stringid = i.getStringExtra("cuil");
        long id = Long.parseLong((stringid));
        Cursor c = controlador.OSporCuil(id);
        idglobal = c.getString(c.getColumnIndexOrThrow("cuil"));
        nombre.setText(c.getString(c.getColumnIndexOrThrow("nombre")));
        cuil.setText(c.getString(c.getColumnIndexOrThrow("cuil")));
        direccion.setText(c.getString(c.getColumnIndexOrThrow("direccion")));
        telefono.setText(c.getString(c.getColumnIndexOrThrow("telefono")));
        email.setText(c.getString(c.getColumnIndexOrThrow("email")));

    }

    public ObraSocial setObraSocial(){
        OS = new ObraSocial();
        OS.setNombre(nombre.getText().toString());
        OS.setCuil(cuil.getText().toString());
        OS.setDireccion(direccion.getText().toString());
        OS.setTelefono(telefono.getText().toString());
        OS.setEmail(email.getText().toString());
        return OS;
    }

    public boolean validarCampos(){
        if (nombre.getText().toString().length() > 0 && cuil.getText().toString().length() > 0 && direccion.getText().toString().length() > 0 && telefono.getText().toString().length() > 0 &&  email.getText().toString().length() > 0){
            return true;
         }else
        {
            return false;
        }
    }

    public void confirmacion(){
        Toast.makeText(getBaseContext(), "Los datos de la Obra Social han sido Actualizados!", Toast.LENGTH_LONG).show();
    }

    public void errorCampoIncompleto(){
        Toast.makeText(context, "Error, campos sin completar!!", Toast.LENGTH_LONG).show();
    }

    }

