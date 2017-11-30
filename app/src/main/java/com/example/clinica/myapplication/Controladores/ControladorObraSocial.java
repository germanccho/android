package com.example.clinica.myapplication.Controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.clinica.myapplication.DTO.ObraSocial;
import com.example.clinica.myapplication.sqlite.BaseDeDatos;
import com.example.clinica.myapplication.sqlite.Tablas;

import java.util.ArrayList;

/**
 * Created by Germanccho on 8/11/2017.
 */

public class ControladorObraSocial {

    Context context;
    BaseDeDatos db;
    public ArrayList<String> listaOS;
    ArrayList<ObraSocial> OSList;
    public String est, cos, nom;


    public ControladorObraSocial(Context c) {
        this.context = c;
    }

    public boolean agregarObraSocial(ObraSocial os) {
        Cursor cu = validarObraSocial(os);
        if (0 != cu.getCount()) {
            return false;
        } else {
            BaseDeDatos conn = new BaseDeDatos(context, null, null, 1);
            SQLiteDatabase db = conn.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Tablas.COLUMNA_NOMBRE_OS, os.getNombre());
            values.put(Tablas.COLUMNA_CUIL_OS, os.getCuil());
            values.put(Tablas.COLUMNA_DIRECCION_OS, os.getDireccion());
            values.put(Tablas.COLUMNA_TEL_OS, Integer.parseInt(os.getTelefono()));
            values.put(Tablas.COLUMNA_EMAIL_OS, os.getEmail());
            values.put(Tablas.COLUMNA_ESTADO_OS, " ");
            values.put(Tablas.COLUMNA_COSEGURO_OS, " ");
            db.insert(Tablas.TABLA_OS, null, values);
            db.close();
            return true;
        }
    }


    public Cursor validarObraSocial(ObraSocial o) {
        BaseDeDatos conn = new BaseDeDatos(context, null, null, 1);
        SQLiteDatabase bd = conn.getWritableDatabase();
        String query = "SELECT * FROM " + Tablas.TABLA_OS + " WHERE " + Tablas.COLUMNA_CUIL_OS + " = '" + o.getCuil() + "';";
        Cursor c = bd.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public ArrayList<ObraSocial> listaObraSocial() {
        db = new BaseDeDatos(context, null,null,1);
        String sql = "SELECT * FROM " + Tablas.TABLA_OS;
        SQLiteDatabase bd = db.getReadableDatabase();
        ArrayList<ObraSocial> listaOS = new ArrayList<>();
        Cursor cursor = bd.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String cuil = cursor.getString(2);
                String direccion = cursor.getString(3);
                String telefono = cursor.getString(4);
                String email = cursor.getString(5);
                String estado = cursor.getString(6);
                String coseguro = cursor.getString(7);
                listaOS.add(new ObraSocial(id, nombre, cuil, direccion, telefono, email, estado, coseguro));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listaOS;
    }


    public void actualizarOS(ObraSocial os) {
        ContentValues values = new ContentValues();
        BaseDeDatos conn = new BaseDeDatos(context,null,null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        values.put(Tablas.COLUMNA_NOMBRE_OS, os.getNombre());
        values.put(Tablas.COLUMNA_CUIL_OS, os.getCuil());
        values.put(Tablas.COLUMNA_DIRECCION_OS, os.getDireccion());
        values.put(Tablas.COLUMNA_TEL_OS, Integer.parseInt(os.getTelefono()));
        values.put(Tablas.COLUMNA_EMAIL_OS, os.getEmail());
        String[] parametro = {os.getCuil()};
        db.update(Tablas.TABLA_OS, values, Tablas.COLUMNA_CUIL_OS + "= ?", parametro);
        db.close();

    }

    public Cursor OSporCuil(long cuil) {
        BaseDeDatos conn = new BaseDeDatos(context,null,null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String query = "SELECT * FROM " + Tablas.TABLA_OS + " WHERE " + Tablas.COLUMNA_CUIL_OS + " = " + cuil + ";";
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public void cargarSpinnerOS() {
        BaseDeDatos conn = new BaseDeDatos(context,null,null,1);
        SQLiteDatabase data=conn.getReadableDatabase();
        ObraSocial os=null;
        OSList =new ArrayList<ObraSocial>();
        //select * from usuarios
        Cursor cursor=data.rawQuery("SELECT * FROM "+ Tablas.TABLA_OS, null);

        while (cursor.moveToNext()){
            os=new ObraSocial();
            os.setNombre(cursor.getString(1));
            Log.i("Nombre",os.getNombre());
            OSList.add(os);

        }
        obtenerListaOS();
    }

    public void obtenerListaOS() {
        listaOS=new ArrayList<String>();
        listaOS.add("Seleccione");

        for(int i=0;i<OSList.size();i++){
            listaOS.add(OSList.get(i).getNombre());
        }

    }


    public int cargarSpinnerOS(String valorSeleccionado) {
        BaseDeDatos conn = new BaseDeDatos(context,null,null,1);
        SQLiteDatabase data = conn.getReadableDatabase();
        ObraSocial os = null;
        ArrayList<ObraSocial> OSList = new ArrayList<ObraSocial>();

        Cursor cursor = data.rawQuery("SELECT * FROM " + Tablas.TABLA_OS, null);

        while (cursor.moveToNext()) {
            os = new ObraSocial();
            os.setNombre(cursor.getString(1));
            Log.i("Nombre", os.getNombre());
            OSList.add(os);
        }
        listaOS=new ArrayList<String>();
        listaOS.add("Seleccione");
        for (int i = 0; i < OSList.size(); i++) {
            listaOS.add(OSList.get(i).getNombre());
        }
        return obtenerPosicionSeleccionado(listaOS,valorSeleccionado);
    }

    public int obtenerPosicionSeleccionado(ArrayList<String> listaElementos, String valorSeleccionado) {
        int posicion = 0;
        for (int i = 0; i < listaElementos.size(); i++) {
            if(valorSeleccionado.equals(listaElementos.get(i).toString()))
            {
                posicion = i;
            }
        }
        return posicion;
    }


    public void cargarDatos(){
        BaseDeDatos conn = new BaseDeDatos(context,null,null,1);
        ContentValues values = new ContentValues();
        values.put(Tablas.COLUMNA_ESTADO_OS, est);
        values.put(Tablas.COLUMNA_COSEGURO_OS, cos);
        SQLiteDatabase bd = conn.getWritableDatabase();
        String[] parametro = {nom};
        bd.update(Tablas.TABLA_OS, values, Tablas.COLUMNA_NOMBRE_OS + "= ?", parametro);
        bd.close();

    }

    public void setDatos(String nombre, String estado, String coseguro){
       nom = nombre;
       est = estado;
       cos = coseguro;

    }

}

