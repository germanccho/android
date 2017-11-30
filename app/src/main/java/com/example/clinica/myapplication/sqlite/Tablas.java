package com.example.clinica.myapplication.sqlite;

/**
 * Created by Germanccho on 6/11/2017.
 */

public class Tablas {


    public static final String TABLA_OS ="obraSocial";
    public static final String COLUMNA_ID_OS = "id";
    public static final String COLUMNA_NOMBRE_OS = "nombre";
    public static final String COLUMNA_CUIL_OS = "cuil";
    public static final String COLUMNA_DIRECCION_OS = "direccion";
    public static final String COLUMNA_TEL_OS = "telefono";
    public static final String COLUMNA_EMAIL_OS = "email";
    public static final String COLUMNA_ESTADO_OS = "estado";
    public static final String COLUMNA_COSEGURO_OS = "coseguro";


    public static final String CREAR_TABLA_OS = "CREATE TABLE " + TABLA_OS + "(" +
            COLUMNA_ID_OS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMNA_NOMBRE_OS + " TEXT, " +
            COLUMNA_CUIL_OS + " INTEGER, " +
            COLUMNA_DIRECCION_OS + " TEXT, " +
            COLUMNA_TEL_OS + " INTEGER, " +
            COLUMNA_EMAIL_OS + " TEXT, " +
            COLUMNA_ESTADO_OS + " TEXT, " +
            COLUMNA_COSEGURO_OS + " TEXT " +
            ");";

}
