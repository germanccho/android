package com.example.clinica.myapplication.UI.View.ObraSocial;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.clinica.myapplication.Controladores.ControladorObraSocial;
import com.example.clinica.myapplication.DTO.ObraSocial;
import com.example.clinica.myapplication.Gestionar_OS;
import com.example.clinica.myapplication.R;

public class agregarObraSocial extends AppCompatActivity {


    public Context context;
    public EditText nombre, direccion, telefono, email, cuil;
    LinearLayout volver, agregar;
    ObraSocial OS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_os);
        nombre = (EditText) findViewById(R.id.nombreOS);
        cuil = (EditText) findViewById(R.id.cuilOS);
        direccion = (EditText) findViewById(R.id.direccionOS);
        telefono = (EditText) findViewById(R.id.telefonoOS);
        email = (EditText) findViewById(R.id.emailOS);
        volver = (LinearLayout) findViewById(R.id.btnVolverGestionarOS);
        agregar = (LinearLayout) findViewById(R.id.btnAgregarOS);
        context = agregarObraSocial.this;




        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControladorObraSocial controlador = new ControladorObraSocial(agregarObraSocial.this);
                if (validarCampos()== true)
                {
                    ObraSocial os = setObraSocial();
                if (controlador.agregarObraSocial(os)==true){
                        confirmacion();
                        limpiarcampos();
                    }else{
                    ErrorAlGuardar();
                    }
                    }
                    else{
                   ErrorCampoIncompleto();
                    }

                }
            }
        );
    }

    public boolean validarCampos(){
        if(nombre.getText().toString().length() > 0 && cuil.getText().toString().length() > 0 && direccion.getText().toString().length() > 0 && telefono.getText().toString().length() > 0 && email.getText().toString().length() > 0){
         return true;
        }else{
            return false;
        }
    }
    public void limpiarcampos(){
        nombre.setText("");
        cuil.setText("");
        direccion.setText("");
        telefono.setText("");
        email.setText("");
    }

    public void confirmacion(){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha agregado una nueva Obra social a la lista!");
        dlgAlert.setTitle("Agregar Obra Social");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent agregar = new Intent(agregarObraSocial.this, Gestionar_OS.class);
                        startActivity(agregar);
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    public void ErrorAlGuardar(){
        Toast.makeText(context, "Error!!! la Obra Social ya se encuentra registrada", Toast.LENGTH_LONG).show();
    }

    public void ErrorCampoIncompleto(){
        Toast.makeText(context, "Error, campos sin completar!!", Toast.LENGTH_LONG).show();
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
}

